package org.reichel.schedule.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.reichel.schedule.business.ShowBusiness;
import org.reichel.schedule.domain.Show;
import org.reichel.schedule.dto.AjaxResult;
import org.reichel.schedule.dto.ShowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShowController {

	@Autowired
	private ShowBusiness showBusiness;
	
	@RequestMapping(path="/show")
    public String home(Map<String, Object> model) {
        return "show";
    }

	@RequestMapping(path="/show/list")
	public @ResponseBody List<ShowDto> list(){
		return this.showBusiness.list().stream().map((show) -> new ShowDto(show)).collect(Collectors.toList());
	}
	
	@RequestMapping(path="/show/create", method = RequestMethod.POST)
	public @ResponseBody AjaxResult create(Show show){
		return AjaxResult.success(new ShowDto(this.showBusiness.create(show)));
	}
	
	@RequestMapping(path="/show/edit", method = RequestMethod.POST)
	public @ResponseBody AjaxResult edit(Show show){
		return AjaxResult.success(new ShowDto(this.showBusiness.edit(show)));
	}

	@RequestMapping(path="/show/delete", method = RequestMethod.POST)
	public @ResponseBody AjaxResult delete(Show show){
		this.showBusiness.delete(show);
		return AjaxResult.success();
	}

}
