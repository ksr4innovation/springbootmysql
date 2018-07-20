package com.snkit.srpingjunedemo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="microservice",name="puser_project_mapping")
public class ProjectUserEntity implements Serializable {
	
	
	private static final long serialVersionUID = -8763977161007689038L;

	public ProjectUserEntity() {
		
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	
	@Column(name="status")
	private String status;

	

	@Column(name="projectid",insertable=false,updatable=false)
	private Long projId;
	
	@Column(name="puserid",insertable=false,updatable=false)
	private Long userId;

	
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="projectid")
	private ProjectEntity projectEntity ;
	
	
	
	
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="puserid")
	private EmployeEntity employeEntity ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getProjId() {
		return projId;
	}

	public void setProjId(Long projId) {
		this.projId = projId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public ProjectEntity getProjectEntity() {
		return projectEntity;
	}

	public void setProjectEntity(ProjectEntity projectEntity) {
		this.projectEntity = projectEntity;
	}

	public EmployeEntity getEmployeEntity() {
		return employeEntity;
	}

	public void setEmployeEntity(EmployeEntity employeEntity) {
		this.employeEntity = employeEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((projId == null) ? 0 : projId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectUserEntity other = (ProjectUserEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (projId == null) {
			if (other.projId != null)
				return false;
		} else if (!projId.equals(other.projId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	

	
	
	
	
}
