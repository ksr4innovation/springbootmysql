package com.snkit.srpingjunedemo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="microservice",name="puser")
public class EmployeEntity implements Serializable {
	
	
	private static final long serialVersionUID = -8763977161007689038L;

	public EmployeEntity() {
		
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="employeEntity",cascade=CascadeType.ALL)
	private List<ProjectUserEntity> empProjEntityList = new ArrayList<ProjectUserEntity>();

	
	

	


	public List<ProjectUserEntity> getEmpProjEntityList() {
		return empProjEntityList;
	}


	public void setEmpProjEntityList(List<ProjectUserEntity> empProjEntityList) {
		this.empProjEntityList = empProjEntityList;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	

	
	
	

	

	
	
	
	
	
	
}
