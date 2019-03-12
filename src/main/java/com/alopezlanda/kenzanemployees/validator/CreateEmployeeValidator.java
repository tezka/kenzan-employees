package com.alopezlanda.kenzanemployees.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.alopezlanda.kenzanemployees.dto.EmployeeReq;
import com.alopezlanda.kenzanemployees.utils.CommonUtils;

@Component
public class CreateEmployeeValidator implements Validator {

  @Override
  public boolean supports(Class<?> arg0) {
    return EmployeeReq.class.equals(arg0);
  }

  @Override
  public void validate(Object obj, Errors errors) {
    EmployeeReq req = (EmployeeReq) obj;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern(CommonUtils.dateFormat);
    
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName can't be empty or null");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName can't be empty or null");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "dateOfBirth can't be empty or null");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfEmployment", "dateOfEmployment can't be empty or null");
    
    if(req.getDateOfBirth()!=null) {
      try {
        LocalDate.parse(req.getDateOfBirth(), dtf);
      } catch(DateTimeParseException ex) {
        errors.rejectValue("dateOfBirth", "the format must be " + CommonUtils.dateFormat);
      }
    }

    if(req.getDateOfEmployment()!=null) {
      try {
        LocalDate.parse(req.getDateOfEmployment(), dtf);
      } catch(DateTimeParseException ex) {
        errors.rejectValue("dateOfEmployment", "the format must be " + CommonUtils.dateFormat);
      }
    }
  }
}
