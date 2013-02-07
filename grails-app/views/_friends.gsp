<%@ page import="travelbook.User"%>
<h2>Friends</h2>
<p>Friend of ${userInstance ? userInstance.lastName : "ADAMA OU EST LE USER INSTANCE !!!"}</p>
<table>
	<g:each in="${userInstanceFriends}" status="i" var="friendInstance">
		<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
			<td>
				${fieldValue(bean: friendInstance, field: "email")}
			</td>
		</tr>
	</g:each>
</table>