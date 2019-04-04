/**
 * @Title: ControllerBase.java
 * @Package com.wpf.eurekaclient.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author pengfei.wang
 * @date 2019年4月4日 下午3:07:20
 * @version V1.0
 */
package com.wpf.eurekaclient.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wpf.eurekaclient.entity.User;
import com.wpf.eurekaclient.service.UserService;
import com.wpf.eurekaclient.token.Token;
import com.wpf.eurekaclient.token.TokenFactory;
import com.wpf.eurekaclient.utils.AesUtil;

/**
 * @ClassName: ControllerBase
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author pengfei.wang
 * @date 2019年4月4日 下午3:07:20
 */
@Component
public abstract class ControllerBase {

  @Autowired
  private UserService userService;

  private boolean isVerifyToken = true;
  private Token token = null;

  public boolean verifyToken(String tokenStr) {
    if (isVerifyToken) {
      token = TokenFactory.decryptToken(AesUtil.ENCODERULES, tokenStr);
      if (null != token) {
        if (new Date().getTime() < token.getExpire()) {
          User user = userService.verifyUser(token.getOpenId(), token.getUserId(), token.getAppId());
          if (null == user) {
            return false;
          }
          return true;
        }
      }
      return false;
    } else {
      return true;
    }
  }

  public void isNotVerifyToken() {
    this.isVerifyToken = false;
  }
}
