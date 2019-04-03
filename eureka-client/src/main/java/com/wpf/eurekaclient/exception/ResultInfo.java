/**
 * @Title: ResultInfo.java
 * @Package com.wpf.eurekaclient.exception
 * @Description: TODO(用一句话描述该文件做什么)
 * @author pengfei.wang
 * @date 2019年4月3日 下午5:15:53
 * @version V1.0
 */
package com.wpf.eurekaclient.exception;

/**
 * @ClassName: ResultInfo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author pengfei.wang
 * @date 2019年4月3日 下午5:15:53
 */
public class ResultInfo {

  private int code;
  private String desc;
  private Object data;

  public ResultInfo() {
    this.code = StatusEnum.SUCCESS.getCode();
    this.desc = StatusEnum.SUCCESS.getDesc();
  }

  public ResultInfo(Object data) {
    this.code = StatusEnum.SUCCESS.getCode();
    this.desc = StatusEnum.SUCCESS.getDesc();
    this.data = data;
  }

  public ResultInfo(StatusEnum statu, Object data) {
    this.code = statu.getCode();
    this.desc = statu.getDesc();
    this.data = data;
  }

  public ResultInfo(StatusEnum statu) {
    this.code = statu.getCode();
    this.desc = statu.getDesc();
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

  /**
   * @return data
   */
  public Object getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(Object data) {
    this.data = data;
  }

}
