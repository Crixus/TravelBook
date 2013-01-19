<%@ page import="travelbook.User"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Welcome to Grails</title>
<style type="text/css" media="screen">
#status {
	background-color: #eee;
	border: .2em solid #fff;
	margin: 2em 2em 1em;
	padding: 1em;
	width: 12em;
	float: left;
	-moz-box-shadow: 0px 0px 1.25em #ccc;
	-webkit-box-shadow: 0px 0px 1.25em #ccc;
	box-shadow: 0px 0px 1.25em #ccc;
	-moz-border-radius: 0.6em;
	-webkit-border-radius: 0.6em;
	border-radius: 0.6em;
}

.ie6 #status {
	display: inline;
	/* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
}

#status ul {
	font-size: 0.9em;
	list-style-type: none;
	margin-bottom: 0.6em;
	padding: 0;
}

#status li {
	line-height: 1.3;
}

#status h1 {
	text-transform: uppercase;
	font-size: 1.1em;
	margin: 0 0 0.3em;
}

#page-body {
	margin: 2em 1em 1.25em 18em;
}

h2 {
	margin-top: 1em;
	margin-bottom: 0.3em;
	font-size: 1em;
}

p {
	line-height: 1.5;
	margin: 0.25em 0;
}

#controller-list ul {
	list-style-position: inside;
}

#controller-list li {
	line-height: 1.3;
	list-style-position: inside;
	margin: 0.25em 0;
}

@media screen and (max-width: 480px) {
	#status {
		display: none;
	}
	#page-body {
		margin: 0 1em 1em;
	}
	#page-body h1 {
		margin-top: 0;
	}
}
</style>
</head>
<body>
	<a href="#page-body" class="skip"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<sec:ifNotLoggedIn>
		<div id="connexion">
			<h1>S'inscrire :</h1>
			<g:set var="userInstance" value="${new User()}" />
			<g:form action="save" controller="user" enctype="multipart/form-data">
				<fieldset class="form">
					
					<g:render template="/user/form" var="${userInstance}  " />
	
					<div class="fieldcontain">
						<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
					</div>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save"
						value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
	</sec:ifNotLoggedIn>
	
	<div id="page-body" role="main">
		<sec:ifNotLoggedIn>
			<h1>Se Connecter :</h1>
			<form method="POST"
				action="${resource(file: 'j_spring_security_check')}">
				<table style="width: 20%; text-align: right;">
					<tr>
						<td>Username:</td>
						<td><g:textField name="j_username" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input name="j_password" type="password" /></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: right;">
							<%--				      <input type='hidden' name='spring-security-redirect' value='${params['spring-security-redirect']}'/>--%>
							<g:submitButton name="login" value="Login" />
						</td>
					</tr>
				</table>
			</form>
		</sec:ifNotLoggedIn>
	</div>
</body>
</html>
