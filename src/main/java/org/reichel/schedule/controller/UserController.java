package org.reichel.schedule.controller;

import java.util.Date;
import java.util.Map;

import org.reichel.schedule.business.UserBusiness;
import org.reichel.schedule.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@Autowired
	private UserBusiness userBusiness;
	
	@RequestMapping(path="/user")
    public String home(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "Home");
        return "user";
    }

	
	@RequestMapping(path="/user/create", method = RequestMethod.POST)
	public String create(User user){
		userBusiness.create(user);
		return "user";
	}
}
