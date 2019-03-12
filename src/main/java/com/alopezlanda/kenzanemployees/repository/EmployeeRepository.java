package com.alopezlanda.kenzanemployees.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alopezlanda.kenzanemployees.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
  
  @Query("SELECT e FROM EmployeeEntity e WHERE e.status = 'ACTIVE'")
  public List<EmployeeEntity> findAllActives();
  
  @Query("SELECT e FROM EmployeeEntity e WHERE e.id=:id AND e.status = 'ACTIVE'")
  public Optional<EmployeeEntity> findActiveById(@Param("id") Long id);
}
