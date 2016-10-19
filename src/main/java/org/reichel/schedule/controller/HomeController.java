package org.reichel.schedule.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.reichel.schedule.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping(path="/")
    public String home(Map<String, Object> model) {
        return "welcome";
    }
	
	@RequestMapping(path="/login", method = { RequestMethod.GET, RequestMethod.POST})
    public String login(@RequestParam(value = "error", required = false) String error,
    					@RequestParam(value = "logout", required = false) String logout,
    					ModelMap modelMap){
		if(error != null){
			Exception e = (Exception) httpSession.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
			if(e != null){
				modelMap.addAttribute("error", e.getMessage());
			}
		}
		if(logout != null){
			userDetailsService.logout();
		}
		return "login";
    }
}
