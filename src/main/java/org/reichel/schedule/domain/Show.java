package org.reichel.schedule.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sch_show")
public class Show extends AbstractDomain {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, unique = true)
	private String showName;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Season> seasons = new ArrayList<Season>();
	
	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public List<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}

}
