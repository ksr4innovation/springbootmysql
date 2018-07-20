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
@Table(schema="microservice",name="project")
public class ProjectEntity implements Serializable {
	
	
	private static final long serialVersionUID = -8763977161007689038L;

	public ProjectEntity() {
		
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	
	@Column(name="name")
	private String name;
	
	
	@OneToMany(mappedBy="projectEntity",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<ProjectUserEntity> projUserEntityList = new ArrayList<ProjectUserEntity>();

	
	
	public List<ProjectUserEntity> getProjUserEntityList() {
		return projUserEntityList;
	}


	public void setProjUserEntityList(List<ProjectUserEntity> projUserEntityList) {
		this.projUserEntityList = projUserEntityList;
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
