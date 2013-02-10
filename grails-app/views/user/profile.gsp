<%@ page import="travelbook.User"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<title>
	${userProfile.lastName} ${userProfile.firstName}'s profile
</title>
</head>
<body>
	<div id="page">
		<h2>
			${userProfile.lastName}
			${userProfile.firstName}'s profile
		</h2>

		<img src="${resource(dir: 'images/picts/', file: nameProfilePicture)}" />

		<table>
			<tr>
				<td>Email :</td>
				<td>
					${userProfile.email}
				</td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td>
					${userProfile.gender}
				</td>
			</tr>
			<tr>
				<td>Age :</td>
				<td>
					${userProfile.getAge()} years old
				</td>
			</tr>
		</table>
		
		<div id="profile_friends">
			<h2>Friends</h2>
			<table class="friends">
				<g:each in="${userProfileFriends}" status="i" var="friendInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>
							<g:link controller="user" action="profile" id="${friendInstance?.id}">
								<img class="profile" src="${resource(dir: 'images/picts/', file: friendInstance.urlProfilePicture())}" />
							</g:link>
						</td>
						<td>
							<g:link controller="user" action="profile" id="${friendInstance?.id}">
								${friendInstance.firstName} ${friendInstance.lastName} 
							</g:link>
						</td>
					</tr>
				</g:each>
			</table>
		</div>
		
		<div id="profile_travels">
			<h2>Travels</h2>
			<table class="travels">
				<g:each in="${userProfileTravels}" status="i" var="travelInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>
							<g:link controller="travel" action="show" id="${travelInstance?.id}">
								<img class="travel" src="${resource(dir: 'images/picts/', file: travelInstance.urlMainPicture())}" />
							</g:link>
						</td>
						<td>
							<g:link controller="travel" action="show" id="${travelInstance?.id}">
								${travelInstance.getDestination()}
							</g:link>
						</td>
						<td>
							${travelInstance.getDateDebut()}
						</td>
						<td>
							${travelInstance.getDateFin()} 
						</td>
					</tr>
				</g:each>
			</table>
		</div>				
	</div>
</body>
</html>
