<%@ page import="travelbook.User"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Friends of ${userInstance.lastName}</title>
	</head>
	<body>
	<div id="page">
		<h2>Friends of ${userInstance.lastName}</h2>
		<table class="friends">
			<g:each in="${userInstanceFriends}" status="i" var="friendInstance">
				<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					<td>
						<g:link controller="user" action="profile" id="${memberInstance?.id}">
							<img class="profile" src="${resource(dir: 'images/picts/', file: friendInstance.urlProfilePicture())}" />
						</g:link>
					</td>
					<td>
						${friendInstance.firstName} ${friendInstance.lastName} 
					</td>
					<td>
						<g:form controller="user">
							<g:actionSubmit value="Delete friend" action="deleteFriend" id="${friendInstance.id}" onclick="return confirm('Delete ${friendInstance.firstName} ?');"/>
						</g:form>
					</td>
				</tr>
			</g:each>
		</table>
	</div>
</body>
</html>
