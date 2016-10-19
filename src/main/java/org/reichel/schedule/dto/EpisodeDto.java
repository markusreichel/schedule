package org.reichel.schedule.dto;

import java.util.Date;

import org.reichel.schedule.domain.Episode;

public class EpisodeDto extends AbstractDto {

	private static final long serialVersionUID = 1L;

	private Integer number;
	
	private Date air;
	
	private Boolean downloaded;
	
	private Boolean subtitle;

	public EpisodeDto() { }
	
	public EpisodeDto(Episode episode) {
		if(episode != null){
			setId(episode.getId());
			setVersion(episode.getVersion());
			setNumber(episode.getNumber());
			setAir(episode.getAir());
			setDownloaded(episode.getDownloaded());
			setSubtitle(episode.getSubtitle());
		}
	}

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
