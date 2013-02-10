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
					<td>
						<g:link controller="user" action="profile" id="${memberInstance?.id}">
							<img class="profile" src="${resource(dir: 'images/picts/', file: memberInstance.urlProfilePicture())}" />
						</g:link>
					</td>
					<td>
						<g:link controller="user" action="profile" id="${memberInstance?.id}">
							${memberInstance.firstName} ${memberInstance.lastName} 
						</g:link>
					</td>
					<td>
						<g:form controller="user">
							<g:hiddenField name="emailUser" value="${memberInstance.email}" />
							<g:actionSubmit value="Add as friend" action="addFriend" id="${memberInstance.id}" />
							<g:actionSubmit value="Delete friend" action="deleteFriend" id="${memberInstance.id}" />
						</g:form>
					</td>
				</tr>
			</g:each>
		</table>
	</div>
</body>
</html>
