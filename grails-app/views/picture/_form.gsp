<%@ page import="travelbook.Picture" %>



<div class="fieldcontain ${hasErrors(bean: pictureInstance, field: 'image', 'error')} required">
	<label for="image">
		<g:message code="picture.image.label" default="Image" />
		<span class="required-indicator">*</span>
	</label>
	<input type="file" id="image" name="image" />
</div>

<div class="fieldcontain ${hasErrors(bean: pictureInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="picture.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${pictureInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pictureInstance, field: 'album', 'error')} required">
	<label for="album">
		<g:message code="picture.album.label" default="Album" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="album" name="album.id" from="${travelbook.Album.list()}" optionKey="id" required="" value="${pictureInstance?.album?.id}" class="many-to-one"/>
</div>

