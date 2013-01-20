package travelbook

class Album {

	String name;
	String description;
	Date dateCreation;
	Date dateModification;
	
	Travel travel
	
	static belongsTo = [travel : Travel]
	static hasMany = [pictures: Picture]
	
    static constraints = {
		name (blank: false, unique: true)
		description (blank: true, nullable: true)
    }
}
