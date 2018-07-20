package com.snkit.srpingjunedemo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snkit.srpingjunedemo.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	
	public UserEntity findByEmail(String email);
	
	public UserEntity findByName(String name);
	
	public UserEntity findByEmailAndName(String email,String name);

}
