package com.gopi.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="roles_tbl")
public class Role {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleid;
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL , mappedBy = "roles")
	private Set<User> users = new HashSet<User>();
	/*
	 * There is no data base change in ManyMany bi-directional mapping (same as the uni-directional mapping )
	 * there is a change wrt the entities
	 * 
	 * */
	
	
	public Long getRoleid() {
		return roleid;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
