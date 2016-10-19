package org.reichel.schedule.business;

import java.util.List;

import org.reichel.schedule.dao.ShowDao;
import org.reichel.schedule.domain.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class ShowBusinessImpl implements ShowBusiness {

	@Autowired
	private ShowDao showDao;
	
	@Override
	public List<Show> list() {
		return showDao.findAll();
	}

	@Override
	public Show create(Show show) {
		Assert.notNull(show, "Show cannot be empty or null.");
		Assert.hasText(show.getShowName(), "Show name cannot be empty or null.");
		Assert.isTrue(show.getShowName().length() <= 255, "Show name cannot be greater then 255.");
		return showDao.saveAndFlush(show);
	}

	@Override
	public Show edit(Show show) {
		Assert.notNull(show, "Show cannot be empty or null.");
		Assert.notNull(show.getId(), "Show cannot be empty or null.");
		Assert.hasText(show.getShowName(), "Show name cannot be empty or null.");
		Assert.isTrue(show.getShowName().length() <= 255, "Show name cannot be greater then 255.");
		
		Show persisted = showDao.findOne(show.getId());
		persisted.setShowName(show.getShowName());
		persisted.setVersion(show.getVersion());
		
		return showDao.saveAndFlush(persisted);
	}

	@Override
	public void delete(Show show) {
		Assert.notNull(show, "Show cannot be empty or null.");
		Assert.notNull(show.getId(), "Show cannot be empty or null.");
		showDao.delete(show.getId());
	}

}
