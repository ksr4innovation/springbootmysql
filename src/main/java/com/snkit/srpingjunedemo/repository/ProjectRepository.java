package com.snkit.srpingjunedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snkit.srpingjunedemo.entity.ProjectEntity;
@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

}
