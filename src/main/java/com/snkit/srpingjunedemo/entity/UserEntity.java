package com.snkit.srpingjunedemo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="microservice",name="user")
public class UserEntity implements Serializable {
	
	
	private static final long serialVersionUID = -8763977161007689038L;

	public UserEntity() {
		
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="userEntity",fetch=FetchType.LAZY)	
	private List<AddressEntity> addressList = new ArrayList<AddressEntity>();
	
	@ManyToMany(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
	@JoinTable(name="user_role_mapping" ,joinColumns= {@JoinColumn( name="user_id",referencedColumnName="id")},
	inverseJoinColumns= {@JoinColumn( name="role_id",referencedColumnName="roleid")})
	private List<RoleEntity> rolesList =  new ArrayList<>() ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AddressEntity> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressEntity> addressList) {
		this.addressList = addressList;
	}

	public List<RoleEntity> getRolesList() {
		return rolesList;
	}

	public void setRolesList(List<RoleEntity> rolesList) {
		this.rolesList = rolesList;
	}
	
	
	
	
	
}
