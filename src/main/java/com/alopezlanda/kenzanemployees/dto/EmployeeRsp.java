package com.alopezlanda.kenzanemployees.dto;


import java.time.format.DateTimeFormatter;

import com.alopezlanda.kenzanemployees.entity.EmployeeEntity;
import com.alopezlanda.kenzanemployees.utils.CommonUtils;
import com.alopezlanda.kenzanemployees.utils.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_NULL)
@Data
public class EmployeeRsp {
  private Long id;
  private String firstName;
  private String middleName;
  private String lastName;
  private String dateOfBirth;
  private String dateOfEmployment;
  private StatusEnum status;
  
  
  public EmployeeRsp (EmployeeEntity entity) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern(CommonUtils.dateFormat);
    
    this.id = entity.getId();
    this.firstName = entity.getFirstName();
    this.middleName = entity.getMiddleName();
    this.lastName = entity.getLastName();
    this.status = entity.getStatus();
    this.dateOfBirth = entity.getDateOfBirth().format(dtf);
    this.dateOfEmployment = entity.getDateOfEmployment().format(dtf);
  }
}
 