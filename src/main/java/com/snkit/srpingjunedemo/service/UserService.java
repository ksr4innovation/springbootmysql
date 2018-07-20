package com.snkit.srpingjunedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snkit.srpingjunedemo.entity.EmployeEntity;
import com.snkit.srpingjunedemo.entity.ProjectEntity;
import com.snkit.srpingjunedemo.entity.ProjectUserEntity;
import com.snkit.srpingjunedemo.entity.UserEntity;
import com.snkit.srpingjunedemo.repository.EmployeRepository;
import com.snkit.srpingjunedemo.repository.ProjectRepository;
import com.snkit.srpingjunedemo.repository.UserRepository;
import com.snkit.srpingjunedemo.vo.Address;
import com.snkit.srpingjunedemo.vo.AddressBuilder;
import com.snkit.srpingjunedemo.vo.User;
import com.snkit.srpingjunedemo.vo.UserBuilder;
import com.snkit.srpingjunedemo.vo.UserReq;
import com.snkit.srpingjunedemo.vo.UserResp;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;

	public UserResp getUsers() {
		UserResp resp = new UserResp();

		List<UserEntity> userList = userRepository.findAll();

		userList.stream().forEach(userEntity -> {

			UserBuilder builder = new UserBuilder();

			User user = builder.setEmail(userEntity.getEmail()).setId(userEntity.getId()).setName(userEntity.getName())
					.build();

			System.out.println("  Before invoking Address relation ");

			userEntity.getAddressList().stream().forEach(addressEntity -> {
				AddressBuilder adBuilder = new AddressBuilder();

				Address ad = adBuilder.setAddId(addressEntity.getAddId()).setCountry(addressEntity.getCountry())
						.setStreet(addressEntity.getStreet()).build();

				user.getAddList().add(ad);
			});
			resp.getUserList().add(user);

		});

		return resp;
	}

	public void findUser(UserReq req) {
		UserEntity userByEmail = userRepository.findByEmail(req.getEmail());

		System.out.println("  userByEmail  " + userByEmail.getEmail());

		UserEntity userByName = userRepository.findByName(req.getName());

		System.out.println("  userByName  " + userByName.getEmail());

		UserEntity userByEmailAndName = userRepository.findByEmailAndName(req.getEmail(), req.getName());

		System.out.println("  userByEmailAndName  " + userByEmailAndName.getEmail());

	}
	@Autowired
	EmployeRepository employeRepository ;
	@Autowired
	ProjectRepository projectRepository;
	
	public void saveProjectEmployeeMapping() {

		ProjectEntity proj = new ProjectEntity();
		proj.setName("E-Commerce");
		
		EmployeEntity David = new EmployeEntity();		
		David.setName("David");
		
		EmployeEntity Steve = new EmployeEntity();
		Steve.setName("Steve");
		
		EmployeEntity Srinu = new EmployeEntity();
		Srinu.setName("Srinu");
		
		
		
		
		ProjectUserEntity projEmpMapping1 = new ProjectUserEntity();
		projEmpMapping1.setStatus("A");
		projEmpMapping1.setEmployeEntity(David);
		projEmpMapping1.setProjectEntity(proj);
		
		//mouli.getEmpProjEntityList().add(task1);
		
		
		ProjectUserEntity projEmpMapping2 = new ProjectUserEntity();
		projEmpMapping2.setStatus("A");
		projEmpMapping2.setEmployeEntity(Steve);
		projEmpMapping2.setProjectEntity(proj);
		
		//swamy.getEmpProjEntityList().add(task2);
		
		ProjectUserEntity projEmpMapping3 = new ProjectUserEntity();
		projEmpMapping3.setStatus("A");
		projEmpMapping3.setEmployeEntity(Srinu);
		projEmpMapping3.setProjectEntity(proj);
		
		// karithikeyan.getEmpProjEntityList().add(task3);
		
		
		
		
		proj.getProjUserEntityList().add(projEmpMapping1);		
		proj.getProjUserEntityList().add(projEmpMapping2);		
		proj.getProjUserEntityList().add(projEmpMapping3);
		
		
		
		employeRepository.save(David);
		employeRepository.save(Steve);
		employeRepository.save(Srinu);
		
		
		projectRepository.save(proj);
	}
}
