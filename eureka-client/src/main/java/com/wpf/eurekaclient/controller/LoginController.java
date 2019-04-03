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

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.wpf.eurekaclient.entity.User;
import com.wpf.eurekaclient.exception.GlobalException;
import com.wpf.eurekaclient.exception.ResultInfo;
import com.wpf.eurekaclient.exception.StatusEnum;
import com.wpf.eurekaclient.service.UserService;

/**
 * @ClassName: LoginController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author pengfei.wang
 * @date 2019年4月3日 上午10:36:57
 */
@RestController
public class LoginController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResultInfo login(@RequestBody JSONObject param) throws GlobalException {
    String login = param.getString("login");
    String password = param.getString("password");
    if (StringUtils.isBlank(login) || StringUtils.isBlank(password)) {
      throw new GlobalException(new ResultInfo(StatusEnum.LOGINFAIL));
    }
    String md5Pass = "";
    try {
      md5Pass = DigestUtils.md5Hex(password.getBytes("utf-8"));
    } catch (UnsupportedEncodingException e) {
      throw new GlobalException(new ResultInfo(StatusEnum.EXCEPTION, "MD5加密失败"));
    }
    User user = userService.login(login, md5Pass);
    if (null == user) {
      throw new GlobalException(new ResultInfo(StatusEnum.LOGINFAIL));
    }
    return new ResultInfo(user);
  }

}
