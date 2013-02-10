package travelbook

class Album {

	String name
	String description
	Date dateCreation
	Date dateModification

	static belongsTo = [travel : Travel]
	static hasMany = [pictures: Picture]

	static constraints = {
		name (blank: false, size: 3..16)
		description (blank: true, nullable: true)
	}
}
