
<%@ page import="travelbook.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-user" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list user">
			
				<g:if test="${userInstance?.username}">
				<li class="fieldcontain">
					<span id="username-label" class="property-label"><g:message code="user.username.label" default="Username" /></span>
					
						<span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${userInstance}" field="username"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="user.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${userInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.enabled}">
				<li class="fieldcontain">
					<span id="enabled-label" class="property-label"><g:message code="user.enabled.label" default="Enabled" /></span>
					
						<span class="property-value" aria-labelledby="enabled-label"><g:formatBoolean boolean="${userInstance?.enabled}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.accountExpired}">
				<li class="fieldcontain">
					<span id="accountExpired-label" class="property-label"><g:message code="user.accountExpired.label" default="Account Expired" /></span>
					
						<span class="property-value" aria-labelledby="accountExpired-label"><g:formatBoolean boolean="${userInstance?.accountExpired}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.accountLocked}">
				<li class="fieldcontain">
					<span id="accountLocked-label" class="property-label"><g:message code="user.accountLocked.label" default="Account Locked" /></span>
					
						<span class="property-value" aria-labelledby="accountLocked-label"><g:formatBoolean boolean="${userInstance?.accountLocked}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.passwordExpired}">
				<li class="fieldcontain">
					<span id="passwordExpired-label" class="property-label"><g:message code="user.passwordExpired.label" default="Password Expired" /></span>
					
						<span class="property-value" aria-labelledby="passwordExpired-label"><g:formatBoolean boolean="${userInstance?.passwordExpired}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?._fisrtname}">
				<li class="fieldcontain">
					<span id="_fisrtname-label" class="property-label"><g:message code="user._fisrtname.label" default="Fisrtname" /></span>
					
						<span class="property-value" aria-labelledby="_fisrtname-label"><g:fieldValue bean="${userInstance}" field="_fisrtname"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?._email}">
				<li class="fieldcontain">
					<span id="_email-label" class="property-label"><g:message code="user._email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="_email-label"><g:fieldValue bean="${userInstance}" field="_email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?._gender}">
				<li class="fieldcontain">
					<span id="_gender-label" class="property-label"><g:message code="user._gender.label" default="Gender" /></span>
					
						<span class="property-value" aria-labelledby="_gender-label"><g:fieldValue bean="${userInstance}" field="_gender"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?._dateOfBirth}">
				<li class="fieldcontain">
					<span id="_dateOfBirth-label" class="property-label"><g:message code="user._dateOfBirth.label" default="Date Of Birth" /></span>
					
						<span class="property-value" aria-labelledby="_dateOfBirth-label"><g:formatDate date="${userInstance?._dateOfBirth}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?._name}">
				<li class="fieldcontain">
					<span id="_name-label" class="property-label"><g:message code="user._name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="_name-label"><g:fieldValue bean="${userInstance}" field="_name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.friends}">
				<li class="fieldcontain">
					<span id="friends-label" class="property-label"><g:message code="user.friends.label" default="Friends" /></span>
					
						<g:each in="${userInstance.friends}" var="f">
						<span class="property-value" aria-labelledby="friends-label"><g:link controller="user" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.travels}">
				<li class="fieldcontain">
					<span id="travels-label" class="property-label"><g:message code="user.travels.label" default="Travels" /></span>
					
						<g:each in="${userInstance.travels}" var="t">
						<span class="property-value" aria-labelledby="travels-label"><g:link controller="travel" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${userInstance?.id}" />
					<g:link class="edit" action="edit" id="${userInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
