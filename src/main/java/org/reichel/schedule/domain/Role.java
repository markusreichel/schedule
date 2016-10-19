package org.reichel.schedule.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sch_role")
public class Role extends AbstractDomain {

	private static final long serialVersionUID = 1L;

	@Column(length = 255, nullable = false)
	private String groupName;
	
	@Column(length = 255, nullable = false, unique = true)
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
