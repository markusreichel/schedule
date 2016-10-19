package org.reichel.schedule.business;

import java.util.List;

import org.reichel.schedule.domain.Show;

public interface ShowBusiness {

	List<Show> list();

	Show create(Show show);

	Show edit(Show show);

	void delete(Show show);
	
}
