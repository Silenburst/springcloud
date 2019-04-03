package com.wpf.eurekaclient.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: User
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author pengfei.wang
 * @date 2019年4月3日 下午5:06:48
 */
public class User implements Serializable {
  /**
   * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
   */
  private static final long serialVersionUID = 1L;

  private Integer id;

  private Integer openId;

  private String login;

  private String name;

  private Integer sex;

  private Integer status;

  private Date createTime;

  private Date updateTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getOpenId() {
    return openId;
  }

  public void setOpenId(Integer openId) {
    this.openId = openId;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login == null ? null : login.trim();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
}