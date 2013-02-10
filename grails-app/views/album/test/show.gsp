
<%@ page import="travelbook.Album" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'album.label', default: 'Album')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-album" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-album" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list album">
			
				<g:if test="${albumInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="album.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${albumInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${albumInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="album.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${albumInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${albumInstance?.dateCreation}">
				<li class="fieldcontain">
					<span id="dateCreation-label" class="property-label"><g:message code="album.dateCreation.label" default="Date Creation" /></span>
					
						<span class="property-value" aria-labelledby="dateCreation-label"><g:formatDate date="${albumInstance?.dateCreation}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${albumInstance?.dateModification}">
				<li class="fieldcontain">
					<span id="dateModification-label" class="property-label"><g:message code="album.dateModification.label" default="Date Modification" /></span>
					
						<span class="property-value" aria-labelledby="dateModification-label"><g:formatDate date="${albumInstance?.dateModification}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${albumInstance?.pictures}">
				<li class="fieldcontain">
					<span id="pictures-label" class="property-label"><g:message code="album.pictures.label" default="Pictures" /></span>
					
						<g:each in="${albumInstance.pictures}" var="p">
						<span class="property-value" aria-labelledby="pictures-label"><g:link controller="picture" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${albumInstance?.travel}">
				<li class="fieldcontain">
					<span id="travel-label" class="property-label"><g:message code="album.travel.label" default="Travel" /></span>
					
						<span class="property-value" aria-labelledby="travel-label"><g:link controller="travel" action="show" id="${albumInstance?.travel?.id}">${albumInstance?.travel?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${albumInstance?.id}" />
					<g:link class="edit" action="edit" id="${albumInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
