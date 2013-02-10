<%@ page import="travelbook.Album" %>



<div class="fieldcontain ${hasErrors(bean: albumInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="album.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${albumInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: albumInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="album.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${albumInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: albumInstance, field: 'dateCreation', 'error')} required">
	<label for="dateCreation">
		<g:message code="album.dateCreation.label" default="Date Creation" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateCreation" precision="day"  value="${albumInstance?.dateCreation}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: albumInstance, field: 'dateModification', 'error')} required">
	<label for="dateModification">
		<g:message code="album.dateModification.label" default="Date Modification" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateModification" precision="day"  value="${albumInstance?.dateModification}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: albumInstance, field: 'pictures', 'error')} ">
	<label for="pictures">
		<g:message code="album.pictures.label" default="Pictures" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${albumInstance?.pictures?}" var="p">
    <li><g:link controller="picture" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="picture" action="create" params="['album.id': albumInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'picture.label', default: 'Picture')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: albumInstance, field: 'travel', 'error')} required">
	<label for="travel">
		<g:message code="album.travel.label" default="Travel" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="travel" name="travel.id" from="${travelbook.Travel.list()}" optionKey="id" required="" value="${albumInstance?.travel?.id}" class="many-to-one"/>
</div>

