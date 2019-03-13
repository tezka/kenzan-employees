package com.alopezlanda.kenzanemployees.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

import com.alopezlanda.kenzanemployees.dto.EmployeeReq;
import com.alopezlanda.kenzanemployees.entity.EmployeeEntity;

public class CommonUtils {
  
  public static final String dateFormat = "dd/MM/yyyy";

  public static EmployeeEntity prepareUpdate(EmployeeEntity src, EmployeeReq update) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
    
    if( !StringUtils.isEmpty(update.getFirstName() )) 
      src.setFirstName(update.getFirstName());
    
    if( !StringUtils.isEmpty(update.getLastName() ))
      src.setLastName(update.getLastName());
    
    if( !StringUtils.isEmpty(update.getDateOfBirth())) 
      src.setDateOfBirth(LocalDate.parse(update.getDateOfBirth(), dtf));
    
    if( !StringUtils.isEmpty(update.getDateOfEmployment())) 
      src.setDateOfEmployment(LocalDate.parse(update.getDateOfEmployment(), dtf));
    
    src.setMiddleName(update.getMiddleName());
    
    return src;
  }
}
