package org.reichel.schedule.dto;

import java.util.ArrayList;
import java.util.List;

import org.reichel.schedule.domain.Season;
import org.reichel.schedule.domain.Show;

public class ShowDto extends AbstractDto {

	private static final long serialVersionUID = 1L;

	private String showName;

	private List<SeasonDto> seasons = new ArrayList<SeasonDto>();

	public ShowDto(){ }
	
	public ShowDto(Show show) {
		if(show != null){
			setId(show.getId());
			setVersion(show.getVersion());
			setShowName(show.getShowName());
			for(Season season : show.getSeasons()){
				this.seasons.add(new SeasonDto(season));
			}
		}
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public List<SeasonDto> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<SeasonDto> seasons) {
		this.seasons = seasons;
	}
}
