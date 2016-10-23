<#-- <#assign  security=JspTaglibs["http://www.springframework.org/security/tags"] /> -->

<#import "/spring.ftl" as spring />

<#macro head title scripts=[] styles=[] >
	<#assign defaultScripts = ['/layout/jquery/js/jquery.js','/layout/knockout/js/knockout.js','/layout/bootstrap/js/bootstrap.js','/layout/schedule/js/common.js'] />
	<#assign defaultStyles = ['/layout/schedule/css/common.css','/layout/bootstrap/css/bootstrap.css'] />
	<head>
	    <meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>${title?html}</title>
	
		<script>var contextPath = '${springMacroRequestContext.contextPath}';</script>
		
		<#list defaultScripts as script>
			<script src="<@spring.url relativeUrl=script />"></script>
		</#list>
	
		<#list scripts as script>
			<script src="<@spring.url relativeUrl=script />"></script>
		</#list>
	
		<#list defaultStyles as style>
			<link rel="stylesheet" type="text/css" href="<@spring.url relativeUrl=style />" />
		</#list>
		
		<#list styles as style>
			<link rel="stylesheet" type="text/css" href="<@spring.url relativeUrl=style />" />
		</#list>
		<meta name="_csrf" content="${_csrf.token}"/>
		<!-- default header name is X-CSRF-TOKEN -->
		<meta name="_csrf_header" content="${_csrf.headerName}"/>		
	</head>
</#macro>

<#macro form action class databind="">
	<form action="<@spring.url relativeUrl=action />" method="POST" class="${class}" <#if databind?length gt 0>data-bind="${databind}"</#if> >
		<#nested />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</#macro>

<#macro menu >
	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
	            <a class="navbar-brand" href="<@spring.url relativeUrl='/' />">Scheduler</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="<@spring.url relativeUrl='/user#users' />">Users</a></li>
					<li><a href="<@spring.url relativeUrl='/show#shows' />">Shows</a></li>
					<li><a href="<@spring.url relativeUrl='/schedule#schedules' />">Schedules</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li class="dropdown-header">User</li>
							<li><a href="#">Profile</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<@spring.url relativeUrl='/logout' />">logout</a></li>
						</ul>
					</li>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</nav>
</#macro>

<#macro body>
	<body>
		<div class="container">
			<div class="header">
				<@menu />
			</div>
			<div id="alert-container" class="alert-container">
				<#if error?exists>
					<div class="alert alert-dismissable alert-danger" role="alert"><span id="alert-message">${error?html}</span><button id="alert-close" type="button" class="close" data-dismiss = "alert" aria-hidden = "true">&times;</button></div>
				</#if>
			</div>
			<div class="main">
				<#nested />
			</div>
		</div>
	</body>
</#macro>

<#macro page title scripts=[] styles=[]>
	<@head title=title scripts=scripts styles=styles />
	<@body>
		<#nested />
	</@body>
</#macro>