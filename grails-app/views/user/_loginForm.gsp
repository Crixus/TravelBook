<h1>Se Connecter :</h1>
<form method="POST"	action="${resource(file: 'j_spring_security_check')}">
	<div class="fieldcontain required">
		<label for="j_username"> Username : <span
			class="required-indicator">*</span>
		</label>
		<g:textField required="" name="j_username" />
	</div>
	<div class="fieldcontain required">
		<label for="j_password"> Password : <span
			class="required-indicator">*</span>
		</label>
		<g:passwordField required="" name="j_password" />
	</div>
	<div class="fieldcontain">
		<%-- <input type='hidden' name='spring-security-redirect' value='${params['spring-security-redirect']}'/> --%>
		<g:submitButton name="login" value="Login" />
	</div>
</form>