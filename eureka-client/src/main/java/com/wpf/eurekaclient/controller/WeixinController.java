package com.wpf.eurekaclient.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

@RestController
@RequestMapping("/weixin")
public class WeixinController {

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String home(HttpServletRequest request) throws AesException {
    String signature = request.getParameter("signature");
    String timeStamp = request.getParameter("timestamp");
    String nonce = request.getParameter("nonce");
    String echoStr = request.getParameter("echostr");
    WXBizMsgCrypt wXBizMsgCrypt = new WXBizMsgCrypt("test123", "L5Xq644Z2wVlhOa9TPTeBAcr2u2Cn1ksm6UgGwS9289", "wx5b07035a88d620a5");
    return wXBizMsgCrypt.verifyUrl(signature, timeStamp, nonce, echoStr);
  }
}
