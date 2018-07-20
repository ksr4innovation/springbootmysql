package com.snkit.srpingjunedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snkit.srpingjunedemo.entity.EmployeEntity;
@Repository
public interface EmployeRepository extends JpaRepository<EmployeEntity, Long> {

}
