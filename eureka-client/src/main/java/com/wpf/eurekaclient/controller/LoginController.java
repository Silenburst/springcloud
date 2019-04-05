/**
 * @Title: LoginController.java
 * @Package com.wpf.eurekaclient.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author pengfei.wang
 * @date 2019年4月3日 上午10:36:57
 * @version V1.0
 */
package com.wpf.eurekaclient.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.wpf.eurekaclient.constant.Constant;
import com.wpf.eurekaclient.entity.User;
import com.wpf.eurekaclient.enums.UserTypeEnum;
import com.wpf.eurekaclient.exception.GlobalException;
import com.wpf.eurekaclient.exception.ResultInfo;
import com.wpf.eurekaclient.exception.StatusEnum;
import com.wpf.eurekaclient.service.UserService;
import com.wpf.eurekaclient.token.TokenFactory;
import com.wpf.eurekaclient.utils.HttpUtil;

/**
 * @ClassName: LoginController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author pengfei.wang
 * @date 2019年4月3日 上午10:36:57
 */
@RestController
public class LoginController extends ControllerBase {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResultInfo login(@RequestBody JSONObject param) throws GlobalException {
    String tokenStr = param.getString("token");
    String login = param.getString("login");
    String password = param.getString("password");
    String code = param.getString("code");
    if (StringUtils.isNotBlank(tokenStr)) {
      if (super.verifyToken(tokenStr)) {
        return new ResultInfo(StatusEnum.LOGINSUCCESS);
      }
      throw new GlobalException(StatusEnum.TOKENISNOTVALID);
    } else {
      if (StringUtils.isNotBlank(login) && StringUtils.isNotBlank(password)) {
        try {
          password = DigestUtils.md5Hex(password.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
          throw new GlobalException(StatusEnum.EXCEPTION, "加密失败");
        }
        User user = userService.login(login, password);
        String openId = null;
        String sessionKey = null;
        String url = String.format(Constant.CODE_URL, Constant.APP_ID, Constant.APP_SECRET, code);
        String result = HttpUtil.doGet(url, null);
        if (JSONObject.isValidObject(result)) {
          JSONObject obj = JSONObject.parseObject(result);
          openId = obj.getString("openid");
          sessionKey = obj.getString("session_key");
        }
        if (StringUtils.isBlank(openId) || StringUtils.isBlank(sessionKey)) {
          throw new GlobalException(StatusEnum.WEIXINHTTPFAIL);
        }
        if (null != user) {
          return new ResultInfo(StatusEnum.LOGINSUCCESS,
              TokenFactory.generateTokenStr(TokenFactory.generateToken(user, sessionKey, Constant.VERSION_1)));
        } else {
          user = userService.getUserByOpenId(openId);
          if (null == user) {
            throw new GlobalException(StatusEnum.UNREGISTERED);
          }
          throw new GlobalException(StatusEnum.LOGINFAIL);
        }
      }
      throw new GlobalException(StatusEnum.LOGINPASSWORDISBLANK);
    }

  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public ResultInfo register(@RequestBody JSONObject param) throws GlobalException {
    String login = param.getString("login");
    String password = param.getString("password");
    String password2 = param.getString("password2");
    String code = param.getString("code");

    if (StringUtils.isNotBlank(login) && StringUtils.isNotBlank(password) && StringUtils.isNotBlank(password2)) {
      if (null != userService.getUserByLoginAndApp(login, Constant.APP_ID)) {
        throw new GlobalException(StatusEnum.LOGINEXISTS);
      }
      if (password.equals(password2)) {
        try {
          password = DigestUtils.md5Hex(password.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
          throw new GlobalException(StatusEnum.EXCEPTION, "加密失败");
        }
        String openId = null;
        String sessionKey = null;
        String url = String.format(Constant.CODE_URL, Constant.APP_ID, Constant.APP_SECRET, code);
        String result = HttpUtil.doGet(url, null);
        if (JSONObject.isValidObject(result)) {
          JSONObject obj = JSONObject.parseObject(result);
          openId = obj.getString("openid");
          sessionKey = obj.getString("session_key");
        }
        if (StringUtils.isBlank(openId) || StringUtils.isBlank(sessionKey)) {
          throw new GlobalException(StatusEnum.WEIXINHTTPFAIL);
        }
        User user = new User();
        user.setOpenId(openId);
        user.setLogin(login);
        user.setPassword(password);
        user.setUserType(UserTypeEnum.Normal.getId());
        user.setAppId(Constant.APP_ID);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        int id = userService.register(user);
        if (id != 0) {
          user.setId(id);
          return new ResultInfo(StatusEnum.REGISTERSUCCESS,
              TokenFactory.generateTokenStr(TokenFactory.generateToken(user, sessionKey, Constant.VERSION_1)));
        }
        throw new GlobalException(StatusEnum.REGISTERFAIL);
      }
    }
    throw new GlobalException(StatusEnum.LOGINPASSWORDISBLANK);
  }
}
