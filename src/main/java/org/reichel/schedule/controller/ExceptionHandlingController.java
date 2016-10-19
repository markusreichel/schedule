package org.reichel.schedule.controller;

import org.reichel.schedule.dto.AjaxResult;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlingController {

	@ExceptionHandler({ IllegalArgumentException.class, BadCredentialsException.class })
	public @ResponseBody AjaxResult illegalArgumentError(Exception exception) {
		return AjaxResult.error(exception);
	}
}
