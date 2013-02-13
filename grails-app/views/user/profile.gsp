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

		

		<table class="profile_table">
			<tr>
				<td rowspan="6"><img class="profile" src="${resource(dir: 'images/picts/', file: nameProfilePicture)}" alt="${userProfile.firstName} ${userProfile.lastName}"/></td>
				<td>First name :</td>
				<td>${userProfile.firstName}</td>
			</tr>
			<tr>
				<td>Last name :</td>
				<td>${userProfile.lastName}</td>
			</tr>
			<tr>
				<td>Email :</td>
				<td>${userProfile.email}</td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td>${userProfile.gender}</td>
			</tr>
			<tr>
				<td>Age :</td>
				<td>${userProfile.getAge()} years old</td>
			</tr>
			<tr>
				<td colspan="2"></td>
			</tr>
		</table>

		<div id="profile_friends">
			<h2>Friends</h2>
		<table class="friends">
				<g:each in="${userProfileFriends}" status="i" var="friendInstance">
					<g:if test="${(i % 4) == 0}">
					     <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					</g:if>
					<td>
						<g:link controller="user" action="profile" id="${friendInstance?.id}">
								<img alt="${friendInstance.firstName} ${friendInstance.lastName}" class="profile" src="${resource(dir: 'images/picts/', file: friendInstance.urlProfilePicture())}" />
							</g:link>
					</td>
					<td>
						<g:link controller="user" action="profile" id="${friendInstance?.id}">
								${friendInstance.firstName} ${friendInstance.lastName} 
							</g:link>
					</td>
					<g:if test="${(i == 3) || i == (userProfileFriends.size() - 1)}">
					     </tr>
					</g:if>
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
								<img alt="${travelInstance.destination}" class="travel" src="${resource(dir: 'images/picts/', file: travelInstance.urlMainPicture())}" />
							</g:link>
						</td>
						<td>
							<g:link controller="travel" action="show" id="${travelInstance?.id}">
								${travelInstance.destination}
							</g:link>
						</td>
						<td>
							${travelInstance.getDateDebut().format('dd/MM/yyyy')} to ${travelInstance.getDateFin().format('dd/MM/yyyy')} 
						</td>
					</tr>
				</g:each>
			</table>
		</div>				
	</div>
</body>
</html>
