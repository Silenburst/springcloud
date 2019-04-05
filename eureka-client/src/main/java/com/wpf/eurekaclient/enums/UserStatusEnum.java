package com.wpf.eurekaclient.enums;

public enum UserStatusEnum {

  NOTVALID(0, "失效"), 
  VALID(1, "有效");

  private UserStatusEnum(int id, String name) {
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
