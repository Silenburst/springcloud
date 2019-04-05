package com.wpf.eurekaclient.enums;

public enum UserTypeEnum {

  Admin(0, "管理员"), 
  Normal(1, "普通用户");

  private UserTypeEnum(int id, String name) {
    this.id = id;
    this.name = name;
  }

  private int id;
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
