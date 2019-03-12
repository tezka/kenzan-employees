package com.alopezlanda.kenzanemployees.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alopezlanda.kenzanemployees.dto.EmployeeReq;
import com.alopezlanda.kenzanemployees.dto.EmployeeRsp;
import com.alopezlanda.kenzanemployees.entity.EmployeeEntity;
import com.alopezlanda.kenzanemployees.exception.ResourceNotFoundException;
import com.alopezlanda.kenzanemployees.repository.EmployeeRepository;
import com.alopezlanda.kenzanemployees.utils.CommonUtils;
import com.alopezlanda.kenzanemployees.utils.StatusEnum;


@Service
public class EmployeeServiceImpl implements EmployeeService {
  
  @Autowired EmployeeRepository repository;

  /** 
   * Create new Employee
   * @param req Employee data
   * @return void
   */
  @Override
  public void createEmployee(EmployeeReq req) {
    repository.save(new EmployeeEntity(req));
  }

  
  /**
   * Find employee by Id
   * @param id Id of employee
   * @return EmployeeRsp obj or ResourceNotFoundException if not employee found
   */
  @Override
  public EmployeeRsp getEmployeById(Long id) {
    Optional<EmployeeEntity> optional = repository.findActiveById(id);
    if(!optional.isPresent()) {
      throw new ResourceNotFoundException("User not found with id: " + id);
    }
    return new EmployeeRsp(optional.get());
  }

  /**
   * List all ACTIVE Employees
   * @return List of employees
   */
  @Override
  public List<EmployeeRsp> getAllEmployees() {
    List<EmployeeRsp> response = null;
    
    response = repository.findAllActives()
      .stream()
      .map( e -> new EmployeeRsp(e) )
      .collect(Collectors.toList());
    
    return response;
  }

  /** 
   * Update an employee by Id
   * @param id Id of employee
   * @return EmployeeRsp object of updated employee or ResourceNotFoundException if not employee found
   */
  @Override
  public EmployeeRsp updateEmployee(Long id, EmployeeReq req) {
    Optional<EmployeeEntity> optional = repository.findActiveById(id);
    if(!optional.isPresent()) {
      throw new ResourceNotFoundException("User not found with id: " + id);
    }

    EmployeeEntity entity = optional.get();
    entity = repository.saveAndFlush(CommonUtils.prepareUpdate(entity, req));
    return new EmployeeRsp(entity);
  }

  
  /**
   * Delete employee
   * @param id Id of employee
   * @return EmployeeRsp of deleted employee or ResourceNotFoundException if not employee found
   */
  @Override
  public EmployeeRsp deleteEmployee(Long id) {
    Optional<EmployeeEntity> optional = repository.findById(id);
    if(!optional.isPresent()) {
      throw new ResourceNotFoundException("User not found with id: " + id);
    }
    
    EmployeeEntity entity = optional.get();
    entity.setStatus(StatusEnum.INACTIVE);
    repository.save(entity);
    return new EmployeeRsp(entity);
  }

}
