package org.reichel.schedule.dto;

public class AjaxResult {

	private boolean success;
	
	private String errorMessage;
	
	private Object result;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public static AjaxResult error(Exception exception) {
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setSuccess(false);
		ajaxResult.setErrorMessage(exception.getMessage());
		return ajaxResult;
	}
	
	public static AjaxResult success(){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setSuccess(true);
		return ajaxResult;
	}
	
	public static AjaxResult success(Object object){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setSuccess(true);
		ajaxResult.setResult(object);
		return ajaxResult;
	}
	
}
