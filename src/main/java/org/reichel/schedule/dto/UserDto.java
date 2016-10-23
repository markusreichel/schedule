package org.reichel.schedule.dto;

import org.reichel.schedule.domain.User;

public class UserDto {

	private Long id;
	
	private String login;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	private Boolean enabled;

	public UserDto(){}
	
	public UserDto(User user){
		if(user != null){
			this.id = user.getId();
			this.firstName = user.getFirstName();
			this.lastName = user.getLastName();
			this.login = user.getLogin();
			this.email = user.getEmail();
			this.enabled = user.getEnabled();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
}
