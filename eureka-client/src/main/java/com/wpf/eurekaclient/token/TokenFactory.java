/**
 * @Title: TokenFactory.java
 * @Package com.wpf.eurekaclient.token
 * @Description: TODO(用一句话描述该文件做什么)
 * @author pengfei.wang
 * @date 2019年4月3日 下午6:23:18
 * @version V1.0
 */
package com.wpf.eurekaclient.token;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.wpf.eurekaclient.entity.User;
import com.wpf.eurekaclient.utils.AesUtil;
import com.wpf.eurekaclient.utils.DateUtil;

/**
 * @ClassName: TokenFactory
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author pengfei.wang
 * @date 2019年4月3日 下午6:23:18
 */
public class TokenFactory {

  public static Token decryptToken(String encodeRules, String tokenStr) {
    return strToToken(AesUtil.decode(encodeRules, tokenStr));
  }

  public static String encryptToken(String encodeRules, String tokenStr) {
    return AesUtil.encode(encodeRules, tokenStr);
  }

  public static Token strToToken(String tokenStr) {
    if (StringUtils.isNotBlank(tokenStr)) {
      String[] arr = tokenStr.split("&%");
      if (arr.length == 7) {
        return new Token(arr[0], Integer.valueOf(arr[1]), Integer.valueOf(arr[2]), arr[3], arr[4], Integer.valueOf(arr[5]), Long.valueOf(arr[6]));
      }
    }
    return null;
  }

  public static String generateTokenStr(Token token) {
    StringBuffer sb = new StringBuffer();
    if (null != token) {
      sb.append(token.getAppId()).append("&%");
      sb.append(token.getUserId()).append("&%");
      sb.append(token.getUserType()).append("&%");
      sb.append(token.getOpenId()).append("&%");
      sb.append(token.getSessionKey()).append("&%");
      sb.append(token.getVersion()).append("&%");
      sb.append(token.getExpire());
    }
    return sb.toString();
  }

  public static Token generateToken(User user, String sessionKey, int version) {
    if (null != user) {
      Token token = new Token();
      token.setAppId(user.getAppId());
      token.setOpenId(user.getOpenId());
      token.setUserId(user.getId());
      token.setUserType(user.getUserType());
      token.setSessionKey(sessionKey);
      token.setVersion(version);
      token.setExpire(DateUtil.getNextDate(new Date()).getTime());
      return token;
    }
    return null;
  }

}
