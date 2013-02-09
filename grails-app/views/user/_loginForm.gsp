<h2>Se Connecter :</h2>
<form method="POST"	action="${resource(file: 'j_spring_security_check')}">
	<div class="champs">
		<label for="j_username">Username :</label>
		<input type="email" name="j_username" required />
	</div>
	<div class="champs">
		<label for="j_password">Password :</label>
		<input type="password" name="j_password" required />
	</div>
	<div class="fieldcontain">
		<input type="submit" class="login" name="login" value="Login" />
	</div>
</form>
