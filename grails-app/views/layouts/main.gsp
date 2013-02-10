<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><g:layoutTitle default="TravelBook" /></title>
	<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'jqueryFancybox.css')}" type="text/css">
</head>
<body>
	<div id="container">

		<div id="banniere">
			<h1 class="titleTravelBook">Travel Book</h1>
		</div>

		<sec:ifLoggedIn>
			<div id="nav">
				<ul>
					<li><g:link controller="travel" action="list">Last travels</g:link></li>
					<li><g:link controller="user" action="list">Members list</g:link></li>
					<li><g:link controller="user" action="friends">Friends list</g:link></li>
					<li><g:link controller="user" action="profile" id="${userInstance?.id}">My profile</g:link></li>
				</ul>
			</div>
		</sec:ifLoggedIn>

		<g:layoutBody />

		<div class="footer" role="contentinfo">
			<p>Copyright © 2013 TravelBook - Black TEAM</p>
			<sec:ifLoggedIn>
				<p>
					<g:link controller="logout">Logout</g:link>
				</p>
			</sec:ifLoggedIn>
		</div>

		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
		<script src="http://camping-lachataigneraie24.com/scripts/jquery.fancybox.pack.js"></script>
		
		<script>
			$(document).ready(function() {
				$('.fancybox').fancybox();
			});
		</script>
	</div>
</body>
</html>
