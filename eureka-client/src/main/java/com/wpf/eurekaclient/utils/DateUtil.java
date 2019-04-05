package com.wpf.eurekaclient.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: DateUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author pengfei.wang
 * @date 2019年4月5日 下午1:37:11
 */
public class DateUtil {

  public static Date getNextDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DAY_OF_MONTH, +1);// +1今天的时间加一天
    date = calendar.getTime();
    return date;
  }
}
