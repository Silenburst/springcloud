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

  private int appId = 0;
  private int userId = 0;
  private int userTypeId = 0;
  private String openId = "0";
  private String sessionKey = "0";
  private int version = 0;
  private long expire = 0;

  public Token(int appId, int userId, int userTypeId, String openId, String sessionKey, int version, long expire) {
    this.appId = appId;
    this.userId = userId;
    this.userTypeId = userTypeId;
    this.openId = openId;
    this.sessionKey = sessionKey;
    this.version = version;
    this.expire = expire;
  }

  public Token() {

  }

  /**
   * @return version
   */
  public int getVersion() {
    return version;
  }

  /**
   * @param version the version to set
   */
  public void setVersion(int version) {
    this.version = version;
  }

  /**
   * @return expire
   */
  public long getExpire() {
    return expire;
  }

  /**
   * @param expire the expire to set
   */
  public void setExpire(long expire) {
    this.expire = expire;
  }

  /**
   * @return appId
   */
  public int getAppId() {
    return appId;
  }

  /**
   * @param appId the appId to set
   */
  public void setAppId(int appId) {
    this.appId = appId;
  }

  /**
   * @return userId
   */
  public int getUserId() {
    return userId;
  }

  /**
   * @param userId the userId to set
   */
  public void setUserId(int userId) {
    this.userId = userId;
  }

  /**
   * @return userTypeId
   */
  public int getUserTypeId() {
    return userTypeId;
  }

  /**
   * @param userTypeId the userTypeId to set
   */
  public void setUserTypeId(int userTypeId) {
    this.userTypeId = userTypeId;
  }

  /**
   * @return openId
   */
  public String getOpenId() {
    return openId;
  }

  /**
   * @param openId the openId to set
   */
  public void setOpenId(String openId) {
    this.openId = openId;
  }

  /**
   * @return sessionKey
   */
  public String getSessionKey() {
    return sessionKey;
  }

  /**
   * @param sessionKey the sessionKey to set
   */
  public void setSessionKey(String sessionKey) {
    this.sessionKey = sessionKey;
  }

}
