package org.reichel.schedule.controller;

import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

import org.reichel.schedule.business.UserBusiness;
import org.reichel.schedule.domain.User;
import org.reichel.schedule.dto.AjaxResult;
import org.reichel.schedule.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(path="/user/list", method = RequestMethod.POST)
	public @ResponseBody AjaxResult findAll(){
		return AjaxResult.success(userBusiness.findAll().stream().map((user) -> new UserDto(user)).collect(Collectors.toList()));
	}
}
