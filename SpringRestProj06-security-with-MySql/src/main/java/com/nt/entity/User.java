package com.nt.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String username;
	private String email;
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    private	Set<Role> roles;

}
