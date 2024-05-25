package com.gopi.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="user_tbl",
	uniqueConstraints = @UniqueConstraint(
			name="unique_email",
			columnNames = "email"
			)
)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
	private String fristName;
	private String lastName;
	private String email;
	private String password;
	
	//Eager -> whenever we load User entity hibernate will load Role entity also 
	@ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	//If we dont use @JoinTable , hibernate will create its own table, columns names
	@JoinTable(name="users_roles_customname" ,
			joinColumns = @JoinColumn(
						name="user_id_foreignkey" , referencedColumnName = "userid"
					) ,
			inverseJoinColumns = @JoinColumn(
					name="role_id_foreignkey" ,  referencedColumnName = "roleid"
					)
	
			)
	Set<Role> roles = new HashSet<Role>();
	
	
	
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
