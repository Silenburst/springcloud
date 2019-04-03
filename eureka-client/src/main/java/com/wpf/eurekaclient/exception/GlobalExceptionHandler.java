/**
 * @Title: GlobalExceptionHandler.java
 * @Package com.wpf.eurekaclient.exception
 * @Description: TODO(用一句话描述该文件做什么)
 * @author pengfei.wang
 * @date 2019年4月3日 下午5:31:10
 * @version V1.0
 */
package com.wpf.eurekaclient.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: GlobalExceptionHandler
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author pengfei.wang
 * @date 2019年4月3日 下午5:31:10
 */

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResultInfo globalException(Exception e) {
    return new ResultInfo(StatusEnum.EXCEPTION, e.toString());
  }
}
