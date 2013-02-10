<%@ page import="travelbook.User"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<title>List of users</title>
</head>
<body>
	<div id="page">
		<h2>List of users</h2>
		<table class="users">
			<g:each in="${usersList}" status="i" var="memberInstance">
				<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					<td><g:link controller="user" action="profile"
							id="${memberInstance?.id}">
							<img class="profile"
								src="${resource(dir: 'images/picts/', file: memberInstance.urlProfilePicture())}" />
						</g:link></td>
					<td><g:link controller="user" action="profile"
							id="${memberInstance?.id}">
							${memberInstance.firstName}
							${memberInstance.lastName}
						</g:link></td>
					<td><g:form controller="user">
								<g:hiddenField name="id" value="${friendInstance?.id}" />	
							<g:if
								test="${!userInstance.isFriendWith(memberInstance) && !userInstance.equals(memberInstance) }">
								<g:actionSubmit value="Add as friend" action="addFriendFromList"
									id="${memberInstance.id}" />
							</g:if>
							<g:if
								test="${userInstance.isFriendWith(memberInstance) && !userInstance.equals(memberInstance)}">
								<g:actionSubmit value="Delete friend" action="deleteFriendFromList"
									id="${memberInstance.id}" />
							</g:if>

						</g:form></td>
				</tr>
			</g:each>
		</table>
	</div>
</body>
</html>
