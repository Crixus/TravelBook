
<%@ page import="travelbook.Travel" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'travel.label', default: 'Travel')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="page">
			<h2>Travels list</h2>
			<table class="travels">
				<g:each in="${travelInstanceList}" status="i" var="travelInstance">
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
	</body>
</html>
