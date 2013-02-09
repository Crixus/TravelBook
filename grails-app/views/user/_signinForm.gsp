<h2>S'inscrire :</h2>
<g:form action="signin" controller="user" enctype="multipart/form-data">
	<div class="champs">
		<label for="email">Email</label>
		<g:field type="email" name="email" required=""
			value="${userInstance?.email}" />
	</div>

	<div class="champs">
		<label for="password">Password</label>
		<g:textField name="password" required=""
			value="${userInstance?.password}" />
	</div>

	<div class="champs">
		<label for="lastName">Last Name :
		</label>
		<g:textField name="lastName" maxlength="16" required=""
			value="${userInstance?.lastName}" />
	</div>

	<div class="champs">
		<label for="firstName">First Name</label>
		<g:textField name="firstName" maxlength="16" required=""
			value="${userInstance?.firstName}" />
	</div>

	<div class="champs">
		<label for="gender">Gender</label>
		<g:select name="gender"
			from="${userInstance.constraints.gender.inList}"
			value="${userInstance?.gender}" valueMessagePrefix="user.gender"
			noSelection="['': '']" />
	</div>

	<div class="champs">
		<label for="dateOfBirth">Date Of Birth :</label>
		<g:datePicker name="dateOfBirth" precision="day"
			value="${userInstance?.dateOfBirth}" />
	</div>

	<div class="fieldcontain">
		<g:submitButton name="create" class="signin"
			value="Signin" />
	</div>
</g:form>
