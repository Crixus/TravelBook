<%@ page import="travelbook.User"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
<h2>Friends</h2>
<p>Friend of ${userInstance ? userInstance.lastName : "ADAMA OU EST LE USER INSTANCE !!!"}</p>
<table>
	<g:each in="${userInstanceFriends}" status="i" var="friendInstance">
		<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
			<td>
				${fieldValue(bean: friendInstance, field: "email")}
			</td>
		</tr>
	</g:each>
</table>
</body>
</html>