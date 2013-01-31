<h1>S'inscrire :</h1>
<g:form action="signin" controller="user" enctype="multipart/form-data">
	<div
		class="fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} required">
		<label for="email"> <g:message code="user.email.label"
				default="Email" /> <span class="required-indicator">*</span>
		</label>
		<g:field type="email" name="email" required=""
			value="${userInstance?.email}" />
	</div>

	<div
		class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
		<label for="password"> <g:message code="user.password.label"
				default="Password" /> <span class="required-indicator">*</span>
		</label>
		<g:textField name="password" required=""
			value="${userInstance?.password}" />
	</div>

	<div
		class="fieldcontain ${hasErrors(bean: userInstance, field: 'lastName', 'error')} required">
		<label for="lastName"> <g:message code="user.lastName.label"
				default="Last Name" /> <span class="required-indicator">*</span>
		</label>
		<g:textField name="lastName" maxlength="16" required=""
			value="${userInstance?.lastName}" />
	</div>

	<div
		class="fieldcontain ${hasErrors(bean: userInstance, field: 'firstName', 'error')} required">
		<label for="firstName"> <g:message code="user.firstName.label"
				default="First Name" /> <span class="required-indicator">*</span>
		</label>
		<g:textField name="firstName" maxlength="16" required=""
			value="${userInstance?.firstName}" />
	</div>

	<div
		class="fieldcontain ${hasErrors(bean: userInstance, field: 'gender', 'error')} ">
		<label for="gender"> <g:message code="user.gender.label"
				default="Gender" />
		</label>
		<g:select name="gender"
			from="${userInstance.constraints.gender.inList}"
			value="${userInstance?.gender}" valueMessagePrefix="user.gender"
			noSelection="['': '']" />
	</div>

	<div
		class="fieldcontain ${hasErrors(bean: userInstance, field: 'dateOfBirth', 'error')} required">
		<label for="dateOfBirth"> <g:message
				code="user.dateOfBirth.label" default="Date Of Birth" /> <span
			class="required-indicator">*</span>
		</label>
		<g:datePicker name="dateOfBirth" precision="day"
			value="${userInstance?.dateOfBirth}" />
	</div>

	<div class="fieldcontain">
		<g:submitButton name="create" class="save"
			value="${message(code: 'default.button.create.label', default: 'Create')}" />
	</div>
</g:form>