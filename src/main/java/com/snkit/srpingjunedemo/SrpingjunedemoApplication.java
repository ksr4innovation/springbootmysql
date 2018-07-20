package com.snkit.srpingjunedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.snkit.srpingjunedemo.repository.RoleRepository;
import com.snkit.srpingjunedemo.repository.UserRepository;
import com.snkit.srpingjunedemo.service.UserService;

@SpringBootApplication
public class SrpingjunedemoApplication implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SrpingjunedemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		System.out.println("  Git branch version merge and pull request test");
		
		userService.saveProjectEmployeeMapping();
		
		
		/*UserEntity user = new UserEntity();
		
		user.setEmail("test11@test.com");
		
		user.setName("Sreeni11");
		
		
		AddressEntity ad = new AddressEntity();
		
		ad.setCountry("India");
		ad.setStreet("Hyd");
		
		ad.setUserEntity(user);
		
		
		AddressEntity ad1 = new AddressEntity();
		ad1.setCountry("India");
		ad1.setStreet("Cheeni");
		ad1.setUserEntity(user);
		
		
		user.getAddressList().add(ad);
		
		user.getAddressList().add(ad1);
		
		
		
		userRepository.save(user);
		
		*
		*	/*RoleEntity role = new RoleEntity();
		role.setRoleName("ROLE_ADMIN");
		role.getUserEntityList().add(user);
		
		RoleEntity role1 = new RoleEntity();
		role1.setRoleName("ROLE_USER");
		role1.getUserEntityList().add(user);
		
		user.getRolesList().add(role);
		user.getRolesList().add(role1);*/
		
		/* List<RoleEntity> roleList = roleRepository.findAll();
		 
		 
		
		UserEntity user = new UserEntity();
		user.setName("mouli");
		user.setEmail("mouli@gmail.com");
		
		
		List<RoleEntity> roleListT = new ArrayList<RoleEntity>();
		roleList.stream().forEach(rolet -> {
		
			
			RoleEntity r = new RoleEntity();
			r.setRoleName(rolet.getRoleName());
			r.setRoleId(rolet.getRoleId());
			r.getUserEntityList().add(user);
			roleListT.add(r);
		});
		
		user.setRolesList(roleListT);
	
		
		AddressEntity ad = new AddressEntity();
		
		ad.setCountry("India");
		ad.setStreet("Hyd");
		
		user.getAddressList().add(ad);
		
		ad.setUserEntity(user);
		
		userRepository.save(user);*/
		
		
		
		
		
	}
	
	
	

	
}
