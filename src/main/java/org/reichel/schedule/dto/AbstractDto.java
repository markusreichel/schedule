package org.reichel.schedule.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class AbstractDto implements Serializable {

	private Long id;

	private Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
