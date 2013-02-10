<%@ page import="travelbook.User"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<title>
	${userInstance.lastName} ${userInstance.firstName}'s profile
</title>
</head>
<body>
	<div id="page">
		<h2>
			${userInstance.lastName}
			${userInstance.firstName}'s profile
		</h2>

		<img src="${resource(dir: 'images/picts/', file: nameProfilePicture)}" />

		<table>
			<tr>
				<td>Email :</td>
				<td>
					${userInstance.email}
				</td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td>
					${userInstance.gender}
				</td>
			</tr>
			<tr>
				<td>Age :</td>
				<td>
					${userInstance.getAge()} years old
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
