<%@ page import="travelbook.User"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Friends of ${userInstance.lastName}</title>
	</head>
	<body>
<h2>Friends of ${userInstance.lastName}</h2>
<table>
	<g:each in="${userInstanceFriends}" status="i" var="friendInstance">
		<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
			<td>
				PICTURE
			</td>
			<td>
				${friendInstance.firstName} ${friendInstance.lastName} 
			</td>
			<td>
				<g:form controller="user">
					<g:hiddenField name="emailFriend" value="${friendInstance.email}" />
    				<g:actionSubmit value="Delete" action="deleteFriend" onclick="return confirm('Delete ${friendInstance.firstName} ?');"/>
    			</g:form>
			</td>
		</tr>
	</g:each>
</table>
</body>
</html>