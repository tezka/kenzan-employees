package com.alopezlanda.kenzanemployees.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_NULL)
@Data
public class EmployeeReq {
  @ApiModelProperty(example="Test Name")
  private String firstName;
  @ApiModelProperty(example="Test MiddleName")
  private String middleName;
  @ApiModelProperty(example="Test LastName")
  private String lastName;
  @ApiModelProperty(example="30/01/2019", value="dd/mm/yyyy")
  private String dateOfBirth;
  @ApiModelProperty(example="30/01/2019", value="dd/mm/yyyy")
  private String dateOfEmployment;
}
 