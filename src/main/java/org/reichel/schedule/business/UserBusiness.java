package org.reichel.schedule.business;

import org.reichel.schedule.domain.User;


public interface UserBusiness {

	User create(User user);
	
	User findByLoginAndPassword(User user);

	User findByLogin(String username);
	
}
