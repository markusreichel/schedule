package org.reichel.schedule.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sch_season")
public class Season extends AbstractDomain {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private Integer number;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Episode> episodes = new ArrayList<Episode>();

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public List<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}
}
