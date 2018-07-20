package com.snkit.srpingjunedemo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(schema="microservice",name="role")
public class RoleEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6105148664600158206L;

	public RoleEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="roleid")
	private Long roleId;
	
	@Column(name="rolename")
	private String roleName;
	
	
	
	
	@ManyToMany(mappedBy="rolesList")
	private List<UserEntity> userEntityList = new ArrayList<UserEntity>();

	public Long getRoleId() {
		return roleId;
	}

	
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<UserEntity> getUserEntityList() {
		return userEntityList;
	}

	public void setUserEntityList(List<UserEntity> userEntityList) {
		this.userEntityList = userEntityList;
	} 
	
	
	

}
