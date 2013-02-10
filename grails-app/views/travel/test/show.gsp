
<%@ page import="travelbook.Travel" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'travel.label', default: 'Travel')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-travel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-travel" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list travel">
			
				<g:if test="${travelInstance?.destination}">
				<li class="fieldcontain">
					<span id="destination-label" class="property-label"><g:message code="travel.destination.label" default="Destination" /></span>
					
						<span class="property-value" aria-labelledby="destination-label"><g:fieldValue bean="${travelInstance}" field="destination"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${travelInstance?.dateDebut}">
				<li class="fieldcontain">
					<span id="dateDebut-label" class="property-label"><g:message code="travel.dateDebut.label" default="Date Debut" /></span>
					
						<span class="property-value" aria-labelledby="dateDebut-label"><g:formatDate date="${travelInstance?.dateDebut}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${travelInstance?.dateFin}">
				<li class="fieldcontain">
					<span id="dateFin-label" class="property-label"><g:message code="travel.dateFin.label" default="Date Fin" /></span>
					
						<span class="property-value" aria-labelledby="dateFin-label"><g:formatDate date="${travelInstance?.dateFin}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${travelInstance?.albums}">
				<li class="fieldcontain">
					<span id="albums-label" class="property-label"><g:message code="travel.albums.label" default="Albums" /></span>
					
						<g:each in="${travelInstance.albums}" var="a">
						<span class="property-value" aria-labelledby="albums-label"><g:link controller="album" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${travelInstance?.member}">
				<li class="fieldcontain">
					<span id="member-label" class="property-label"><g:message code="travel.member.label" default="Member" /></span>
					
						<span class="property-value" aria-labelledby="member-label"><g:link controller="user" action="show" id="${travelInstance?.member?.id}">${travelInstance?.member?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${travelInstance?.id}" />
					<g:link class="edit" action="edit" id="${travelInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
