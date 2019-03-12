package com.alopezlanda.kenzanemployees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alopezlanda.kenzanemployees.dto.EmployeeReq;
import com.alopezlanda.kenzanemployees.dto.EmployeeRsp;
import com.alopezlanda.kenzanemployees.service.EmployeeService;
import com.alopezlanda.kenzanemployees.validator.CreateEmployeeValidator;

@CrossOrigin
@RestController
@RequestMapping(value = "/kenzan/v1/employee")
public class EmployeeController {
  
  @Autowired EmployeeService service;
  @Autowired CreateEmployeeValidator createValidator;

  @InitBinder("employeeReq")
  private void initBinder1(WebDataBinder binder) {
    binder.setValidator(createValidator);
  }
  

  @RequestMapping(value = "/", method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.CREATED)
  public void  create(
      @RequestBody @Validated EmployeeReq req) {

    service.createEmployee(req);
  }


  @RequestMapping(value = "/", method = RequestMethod.GET)
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<List<EmployeeRsp>>  list () {
  
    return new ResponseEntity<List<EmployeeRsp>>(service.getAllEmployees(), HttpStatus.OK);
  }


  @RequestMapping(value = "/{ID}", method = RequestMethod.GET)
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<EmployeeRsp> get (
      @PathVariable("ID") Long id) {

    return new ResponseEntity<EmployeeRsp>(service.getEmployeById(id), HttpStatus.OK);
  }
  

  @RequestMapping(value = "/{ID}", method = RequestMethod.PUT)
  public ResponseEntity<EmployeeRsp>  update(
      @PathVariable("ID") Long id,
      @RequestBody EmployeeReq req) {
    
    return new ResponseEntity<EmployeeRsp>(service.updateEmployee(id, req), HttpStatus.OK);
  }
  

  @RequestMapping(value = "/secure/{ID}", method = RequestMethod.DELETE)
  public ResponseEntity<EmployeeRsp>  delete (
      @PathVariable("ID") Long id,
      @RequestHeader(name = "auth-token", required = true) String authToken) {
    
    return new ResponseEntity<EmployeeRsp>(service.deleteEmployee(id), HttpStatus.OK);
  }
  
  

}
