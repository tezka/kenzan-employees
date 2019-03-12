package com.alopezlanda.kenzanemployees.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alopezlanda.kenzanemployees.dto.EmployeeReq;
import com.alopezlanda.kenzanemployees.utils.CommonUtils;
import com.alopezlanda.kenzanemployees.utils.StatusEnum;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee")
@Data
@NoArgsConstructor
public class EmployeeEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  
  @Column(nullable=false, updatable=true,  length=40, name="first_name")
  private String firstName;

  @Column(nullable=true, updatable=true,  length=30, name="middle_name")
  private String middleName;

  @Column(nullable=false, updatable=true,  length=50, name="last_name")
  private String lastName;

  @Column(nullable=false, updatable=true, name="date_of_birth")
  private LocalDate dateOfBirth;

  @Column(nullable=false, updatable=true, name="date_of_employment")
  private LocalDate dateOfEmployment;

  @Column(nullable=true, updatable=true,  length=13, name="status")
  @Enumerated(EnumType.STRING)
  private StatusEnum status = StatusEnum.ACTIVE;
  
  // Create the Entity from the Create employee request
  public EmployeeEntity(EmployeeReq req){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern(CommonUtils.dateFormat);
    
    this.firstName = req.getFirstName();
    this.middleName = req.getMiddleName();
    this.lastName = req.getLastName();
    this.dateOfBirth = LocalDate.parse(req.getDateOfBirth(), dtf);
    this.dateOfEmployment = LocalDate.parse(req.getDateOfEmployment(), dtf);
  }
  
  
  // Create the entity from the Update employee request
  public EmployeeEntity(EmployeeReq req, Long id) {
    this(req);
    this.id = id;
  }
}
