package org.reichel.schedule.business;

import org.apache.commons.codec.digest.DigestUtils;
import org.reichel.schedule.dao.UserDao;
import org.reichel.schedule.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UserBusinessImpl implements UserBusiness {

	@Autowired
	private UserDao userDao;
	
	public User create(User user) {
		Assert.notNull(user, "Parameter user cannot be null.");
		Assert.hasText(user.getEmail(), "Email cannot be empty.");
		Assert.hasText(user.getFirstName(), "First name cannot be empty.");
		Assert.hasText(user.getLastName(), "Last name cannot be empty.");
		Assert.hasText(user.getLogin(), "Login cannot be empty.");
		Assert.hasText(user.getPassword(), "Password cannot be empty.");
		
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		
		return this.userDao.save(user);
	}
	
	public User findByLoginAndPassword(User user){
		Assert.notNull(user, "Parameter user cannot be null.");
		Assert.hasText(user.getLogin(), "Login cannot be empty.");
		Assert.hasText(user.getPassword(), "Password cannot be empty.");
		User result = this.userDao.findByLoginAndPassword(user.getLogin(), DigestUtils.md5Hex(user.getPassword()));
		result.setPassword(user.getPassword());
		return result;
	}

	@Override
	public User findByLogin(String login) {
		Assert.hasText(login, "Login cannot be empty.");
		return this.userDao.findByLogin(login);
	}
}
