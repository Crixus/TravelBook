<%@ page import="travelbook.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="user.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${userInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${userInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="user.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" maxlength="16" required="" value="${userInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="user.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" maxlength="16" required="" value="${userInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="user.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${userInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'gender', 'error')} ">
	<label for="gender">
		<g:message code="user.gender.label" default="Gender" />
		
	</label>
	<g:select name="gender" from="${userInstance.constraints.gender.inList}" value="${userInstance?.gender}" valueMessagePrefix="user.gender" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'dateOfBirth', 'error')} required">
	<label for="dateOfBirth">
		<g:message code="user.dateOfBirth.label" default="Date Of Birth" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateOfBirth" precision="day"  value="${userInstance?.dateOfBirth}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'friends', 'error')} ">
	<label for="friends">
		<g:message code="user.friends.label" default="Friends" />
		
	</label>
	<g:select name="friends" from="${travelbook.User.list()}" multiple="multiple" optionKey="id" size="5" value="${userInstance?.friends*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'travels', 'error')} ">
	<label for="travels">
		<g:message code="user.travels.label" default="Travels" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.travels?}" var="t">
    <li><g:link controller="travel" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="travel" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'travel.label', default: 'Travel')])}</g:link>
</li>
</ul>

</div>

