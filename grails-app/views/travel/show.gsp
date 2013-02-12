
<%@ page import="travelbook.Travel" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'travel.label', default: 'Travel')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="page">
			<h2>
				${traveler.firstName}'s travel - ${travelInstance.destination}
			</h2>
			<table>
				<tr>
					<td>Member :</td><td>${traveler.firstName} ${traveler.lastName}</td>
				</tr>
				<tr>
					<td>Destination :</td><td>${travelInstance.destination}</td>
				</tr>
			</table>
			<h2>
				Pictures of this travel
			</h2>
			<table class="minis_pictures">
				<g:each in="${listOfPictures}" status="i" var="picture">
					<g:if test="${(i % 4) == 0}">
					     <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					</g:if>
					<td>
						<a rel="travel" class="fancybox" href="${resource(dir: 'images/picts/', file: picture)}">
							<img class="travel_picture" src="${resource(dir: 'images/picts/', file: picture)}" />
						</a>
					</td>
					<g:if test="${(i == 3) || i == (listOfPictures.size() - 1)}">
					     </tr>
					</g:if>
				</g:each>
			</table>
		</div>
	</body>
</html>
