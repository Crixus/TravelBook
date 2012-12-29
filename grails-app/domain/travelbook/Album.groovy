package travelbook

class Album {

	String name;
	String description;
	Date dateCreation;
	Date dateModification;
	
	static belongsTo = [travel : Travel]
	static hasMany = [pictures: Picture]
	
    static constraints = {
    }
}
