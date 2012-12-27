<%@ page import="travelbook.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="user.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${userInstance?.username}" placeholder= "${message(code: 'user.username.label', default: 'Username')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${userInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: '_fisrtname', 'error')} required">
	<label for="_fisrtname">
		<g:message code="user._fisrtname.label" default="Fisrtname" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="_fisrtname" maxlength="16" required="" value="${userInstance?._fisrtname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: '_email', 'error')} required">
	<label for="_email">
		<g:message code="user._email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="_email" required="" value="${userInstance?._email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: '_gender', 'error')} ">
	<label for="_gender">
		<g:message code="user._gender.label" default="Gender" />
		
	</label>
	<g:select name="_gender" from="${userInstance.constraints._gender.inList}" value="${userInstance?._gender}" valueMessagePrefix="user._gender" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: '_dateOfBirth', 'error')} required">
	<label for="_dateOfBirth">
		<g:message code="user._dateOfBirth.label" default="Date Of Birth" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="_dateOfBirth" precision="day"  value="${userInstance?._dateOfBirth}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: '_name', 'error')} ">
	<label for="_name">
		<g:message code="user._name.label" default="Name" />
		
	</label>
	<g:textField name="_name" value="${userInstance?._name}"/>
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

