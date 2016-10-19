package org.reichel.schedule.dao;

import org.reichel.schedule.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long>{

	User findByLoginAndPassword(String login, String password);

	User findByLogin(String login);
	
}
