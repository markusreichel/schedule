package org.reichel.schedule.dto;

import java.util.ArrayList;
import java.util.List;

import org.reichel.schedule.domain.Episode;
import org.reichel.schedule.domain.Season;

public class SeasonDto extends AbstractDto {

	private static final long serialVersionUID = 1L;

	private Integer number;
	
	private List<EpisodeDto> episodes = new ArrayList<EpisodeDto>();

	public SeasonDto(){}
	
	public SeasonDto(Season season) {
		if(season != null){
			setId(season.getId());
			setVersion(season.getVersion());
			setNumber(season.getNumber());
			for(Episode episode : season.getEpisodes()){
				this.episodes.add(new EpisodeDto(episode));
			}
		}
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public List<EpisodeDto> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<EpisodeDto> episodes) {
		this.episodes = episodes;
	}
}
