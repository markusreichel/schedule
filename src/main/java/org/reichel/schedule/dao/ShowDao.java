package org.reichel.schedule.dao;

import org.reichel.schedule.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowDao extends JpaRepository<Show, Long> {
	
}
