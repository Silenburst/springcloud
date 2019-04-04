/**
 * @Title: WeixinConfig.java
 * @Package com.wpf.eurekaclient.config
 * @Description: TODO(用一句话描述该文件做什么)
 * @author pengfei.wang
 * @date 2019年4月4日 下午2:08:11
 * @version V1.0
 */
package com.wpf.eurekaclient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName: WeixinConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author pengfei.wang
 * @date 2019年4月4日 下午2:08:11
 */
@Configuration
@PropertySource("classpath:/weixin/config.properties")
public class WeixinConfig {

  private String appId;
  private String appSecret;
  private String openIdByCodeUrl;

  /**
   * @return appId
   */
  public String getAppId() {
    return appId;
  }

  /**
   * @param appId the appId to set
   */
  public void setAppId(String appId) {
    this.appId = appId;
  }

  /**
   * @return appSecret
   */
  public String getAppSecret() {
    return appSecret;
  }

  /**
   * @param appSecret the appSecret to set
   */
  public void setAppSecret(String appSecret) {
    this.appSecret = appSecret;
  }

  /** 
   * @return openIdByCodeUrl 
   */
  public String getOpenIdByCodeUrl() {
    return openIdByCodeUrl;
  }

  /**
   * @param openIdByCodeUrl the openIdByCodeUrl to set
   */
  public void setOpenIdByCodeUrl(String openIdByCodeUrl) {
    this.openIdByCodeUrl = openIdByCodeUrl;
  }

}
