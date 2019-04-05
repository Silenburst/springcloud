/**
 * @Title: Token.java
 * @Package com.wpf.eurekaclient.token
 * @Description: TODO(用一句话描述该文件做什么)
 * @author pengfei.wang
 * @date 2019年4月3日 下午6:18:18
 * @version V1.0
 */
package com.wpf.eurekaclient.token;

/**
 * @ClassName: Token
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author pengfei.wang
 * @date 2019年4月3日 下午6:18:18
 */
public class Token {

  private String appId;
  private int userId;
  private int userType;
  private String openId;
  private String sessionKey;
  private int version;
  private long expire;

  public Token(String appId, int userId, int userType, String openId, String sessionKey, int version, long expire) {
    this.appId = appId;
    this.userId = userId;
    this.userType = userType;
    this.openId = openId;
    this.sessionKey = sessionKey;
    this.version = version;
    this.expire = expire;
  }

  public Token() {

  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getUserType() {
    return userType;
  }

  public void setUserType(int userType) {
    this.userType = userType;
  }

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getSessionKey() {
    return sessionKey;
  }

  public void setSessionKey(String sessionKey) {
    this.sessionKey = sessionKey;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  public long getExpire() {
    return expire;
  }

  public void setExpire(long expire) {
    this.expire = expire;
  }

}
