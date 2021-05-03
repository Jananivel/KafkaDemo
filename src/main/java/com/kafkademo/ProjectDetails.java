package com.kafkademo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class ProjectDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="ID")
	private int projectID;
	@Column(name="Name")
	private String projectName;
	@Column(name="Description")
	private String projectDescription;
	
	public ProjectDetails() {
		
	}
	
	public ProjectDetails(String projectName, String projectDescription) {
		super();
		
		this.projectName = projectName;
		this.projectDescription = projectDescription;
	}
	
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public int getProjectID() {
		return projectID;
	}
	public String getProjectName() {
		return projectName;
	}
	public String getProjectDescription() {
		return projectDescription;
	}

	@Override
	public String toString() {
		return "ProjectDetails [projectID=" + projectID + ", projectName=" + projectName + ", projectDescription="
				+ projectDescription + "]";
	}
	
	

}
