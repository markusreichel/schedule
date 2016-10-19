<#import "macro.ftl" as main />
<#import "/spring.ftl" as spring />

<@main.page title="Welcome to Scheduler!" scripts=['/layout/schedule/js/login.js'] styles=['/layout/schedule/css/login.css']>
	<@main.form action="/login" class="col-xs-4" databind="submit: loginViewModel.validateLogin">
		<div class="form-group" data-bind="css: { 'has-error': loginViewModel.hasError }">
		  <label class="form-control-label" for="login1">Login</label>
		  <input id="login1" name="login" type="text" class="form-control" placeholder="Login" data-bind="textInput: loginViewModel.login">
		</div>
	
		<div class="form-group" data-bind="css: { 'has-error': loginViewModel.hasError }">
		  <label class="form-control-label" for="password1">Password</label>
		  <input id="password1" name="password" type="password" class="form-control" placeholder="Password" data-bind="textInput: loginViewModel.password">
		</div>
		<button type="submit" class="btn btn-default">Login</button>
	</@main.form>
</@main.page>