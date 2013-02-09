<%@page import="travelbook.UserController"%>
<%@ page import="travelbook.User"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main" />
		<title>TravelBook</title>
	</head>
	<body>
		<div id="page">
			
			<div id="inscription_left">
				<img src="./images/travelbook/travels_pictures.jpg" />
			</div>
			
			<div id="inscription_right">
				<sec:ifNotLoggedIn>
					<div id="connexion">			
						<g:render template="/user/loginForm" />
					</div>
					
					<g:set var="userInstance" value="${new User()}" />
					<div id="inscription">
						<g:render template="/user/signinForm" />
					</div>
				</sec:ifNotLoggedIn>
			</div>
			
		</div>
	</body>
</html>
