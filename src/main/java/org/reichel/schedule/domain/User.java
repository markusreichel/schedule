package org.reichel.schedule.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sch_user")
public class User extends AbstractDomain {
	
	private static final long serialVersionUID = 1L;

	@Column(length = 255, nullable = false, unique = true)
	private String login;
	
	@Column(length = 255, nullable = false, unique = true)
	private String email;
	
	@Column(length = 255, nullable = false)
	private String firstName;
	
	@Column(length = 255, nullable = false)
	private String lastName;
	
	@Column(length = 255, nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles = new HashSet<Role>();

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
