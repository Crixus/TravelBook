<%@ page import="travelbook.Travel" %>



<div class="fieldcontain ${hasErrors(bean: travelInstance, field: 'destination', 'error')} required">
	<label for="destination">
		<g:message code="travel.destination.label" default="Destination" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="destination" required="" value="${travelInstance?.destination}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: travelInstance, field: 'dateDebut', 'error')} required">
	<label for="dateDebut">
		<g:message code="travel.dateDebut.label" default="Date Debut" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateDebut" precision="day"  value="${travelInstance?.dateDebut}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: travelInstance, field: 'dateFin', 'error')} required">
	<label for="dateFin">
		<g:message code="travel.dateFin.label" default="Date Fin" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateFin" precision="day"  value="${travelInstance?.dateFin}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: travelInstance, field: 'albums', 'error')} ">
	<label for="albums">
		<g:message code="travel.albums.label" default="Albums" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${travelInstance?.albums?}" var="a">
    <li><g:link controller="album" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="album" action="create" params="['travel.id': travelInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'album.label', default: 'Album')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: travelInstance, field: 'member', 'error')} required">
	<label for="member">
		<g:message code="travel.member.label" default="Member" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="member" name="member.id" from="${travelbook.User.list()}" optionKey="id" required="" value="${travelInstance?.member?.id}" class="many-to-one"/>
</div>

