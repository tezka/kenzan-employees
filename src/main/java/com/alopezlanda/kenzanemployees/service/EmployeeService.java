package com.alopezlanda.kenzanemployees.service;

import java.util.List;

import com.alopezlanda.kenzanemployees.dto.EmployeeReq;
import com.alopezlanda.kenzanemployees.dto.EmployeeRsp;

public interface EmployeeService {
  void createEmployee(EmployeeReq req);
  EmployeeRsp getEmployeById(Long id);
  List<EmployeeRsp> getAllEmployees();
  EmployeeRsp updateEmployee(Long id, EmployeeReq res);
  EmployeeRsp deleteEmployee(Long id);
}
