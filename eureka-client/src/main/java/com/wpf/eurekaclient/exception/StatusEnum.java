/**
 * @Title: ExceptionEnum.java
 * @Package com.wpf.eurekaclient.enums
 * @Description: TODO(用一句话描述该文件做什么)
 * @author pengfei.wang
 * @date 2019年4月3日 下午5:07:50
 * @version V1.0
 */
package com.wpf.eurekaclient.exception;

/**
 * @ClassName: ExceptionEnum
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author pengfei.wang
 * @date 2019年4月3日 下午5:07:50
 */
public enum StatusEnum {

  EXCEPTION(-1, "系统异常"),
  SUCCESS(0, "成功"),
  LOGINSUCCESS(1, "登录成功"), 
  LOGINFAIL(2, "登录失败"),
  HTTPEXCEPTION(3, "http请求异常"),
  UNREGISTERED(4,"未注册"),
  UNLOGIN(5,"未登录"),
  TOKENISNOTVALID(6,"token已经失效"),
  LOGINEXISTS(7,"用户名已经存在"),
  WEIXINHTTPFAIL(8,"请求微信接口失败"),
  LOGINPASSWORDISBLANK(9,"用户名密码不能为空"),
  REGISTERFAIL(10,"注册失败"),
  REGISTERSUCCESS(11,"注册成功");

  private int code;
  private String desc;

  private StatusEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  /**
   * @return code
   */
  public int getCode() {
    return code;
  }

  /**
   * @param code the code to set
   */
  public void setCode(int code) {
    this.code = code;
  }

  /**
   * @return desc
   */
  public String getDesc() {
    return desc;
  }

  /**
   * @param desc the desc to set
   */
  public void setDesc(String desc) {
    this.desc = desc;
  }

}
