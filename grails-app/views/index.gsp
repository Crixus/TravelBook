<%@page import="travelbook.UserController"%>
<%@ page import="travelbook.User"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main" />
		<title>TravelBook</title>
	</head>
	<body>
		<div id="page" role="main">
			
			<sec:ifNotLoggedIn>
				<g:set var="userInstance" value="${new User()}" />
				<div id="inscription">
					<g:render template="/user/signinForm" />
				</div>
	
				<div id="connexion">			
					<g:render template="/user/loginForm" />
				</div>
			</sec:ifNotLoggedIn>
			<sec:ifLoggedIn>
				<g:set var="userInstance" value="${User.findByUsername(sec.loggedInUserInfo(field:'username'))}" />
				<g:set var="userInstanceFriends" value="${UserController.friends()}" />
				<g:render template="/home" />
			</sec:ifLoggedIn>
		</div>
	</body>
</html>
