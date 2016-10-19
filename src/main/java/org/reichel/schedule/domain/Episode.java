package org.reichel.schedule.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sch_episode")
public class Episode extends AbstractDomain {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private Integer number;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date air;
	
	@Column(nullable = false)
	private Boolean downloaded;
	
	@Column(nullable = false)
	private Boolean subtitle;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getAir() {
		return air;
	}

	public void setAir(Date air) {
		this.air = air;
	}

	public Boolean getDownloaded() {
		return downloaded;
	}

	public void setDownloaded(Boolean downloaded) {
		this.downloaded = downloaded;
	}

	public Boolean getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(Boolean subtitle) {
		this.subtitle = subtitle;
	}
}
