/**
 * @Title: GlobalException.java
 * @Package com.wpf.eurekaclient.exception
 * @Description: TODO(用一句话描述该文件做什么)
 * @author pengfei.wang
 * @date 2019年4月3日 下午5:44:33
 * @version V1.0
 */
package com.wpf.eurekaclient.exception;

/**
 * @ClassName: GlobalException
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author pengfei.wang
 * @date 2019年4月3日 下午5:44:33
 */
public class GlobalException extends Exception {

  /**
   * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
   */
  private static final long serialVersionUID = 1L;
  private ResultInfo result;

  public GlobalException(StatusEnum statu) {
    this.result = new ResultInfo(statu);
  }

  public GlobalException(StatusEnum statu, Object data) {
    this.result = new ResultInfo(statu, data);
  }

  /**
   * @return result
   */
  public ResultInfo getResult() {
    return result;
  }

  /**
   * @param result the result to set
   */
  public void setResult(ResultInfo result) {
    this.result = result;
  }

}
