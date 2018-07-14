package com.snkit.srpingjunedemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.snkit.srpingjunedemo.entity.UserEntity;
import com.snkit.srpingjunedemo.repository.UserRepository;

@SpringBootApplication
public class SrpingjunedemoApplication implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SrpingjunedemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		System.out.println("  Git branch version merge and pull request test");
		
		UserEntity user = new UserEntity();
		
		user.setEmail("test@test.com");
		
		user.setName("Sreeni");
		
		userRepository.save(user);
		
		List<UserEntity> userList =  userRepository.findAll();
		
		userList.stream().forEach(entity ->  {
			
			System.out.println("    Retriving data   id = "+entity.getId()+"  email= "+entity.getEmail()+" name="+entity.getName());
		});
		
		
	}
	
	
	

	
}
