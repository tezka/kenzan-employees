package com.alopezlanda.kenzanemployees.utils;

public enum StatusEnum {
  INACTIVE("INACTIVE"),
  ACTIVE("ACTIVE");
  
  private String statusName;
  
  private StatusEnum(String status) {
    this.statusName = status;
  }
  
  public String getStatus() {
    return statusName;
  }
}
