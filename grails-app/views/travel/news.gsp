<%@ page import="travelbook.User"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>The last travels</title>
	</head>
	<body>
<h2>Travels</h2>
<table>
	<g:each in="${travelsList}" status="i" var="travelInstance">
		<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
			<td>
				${travelInstance.destination} 
			</td>
		</tr>
	</g:each>
</table>
</body>
</html>