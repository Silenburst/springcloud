package com.wpf.eurekaclient.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

@RestController
@RequestMapping("/weixin")
public class WeixinController {

  private String token = "";
  private String encodingAesKey = "";
  private String appId = "";

  @RequestMapping(value = "/hello")
  public String home(HttpServletRequest request) throws AesException {
    String signature = request.getParameter("signature");
    String timeStamp = request.getParameter("timestamp");
    String nonce = request.getParameter("nonce");
    String echoStr = request.getParameter("echostr");
    WXBizMsgCrypt wXBizMsgCrypt = new WXBizMsgCrypt(token, encodingAesKey, appId);
    return wXBizMsgCrypt.verifyUrl(signature, timeStamp, nonce, echoStr);
  }
}
