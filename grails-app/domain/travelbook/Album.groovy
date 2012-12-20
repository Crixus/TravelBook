package travelbook

class Album {

	String _name;
	String _description;
	Date _dateCreation;
	Date _dateModification;
	
	static belongsTo = [travel : Travel]
	static hasMany = [pictures: Picture]
	
    static constraints = {
    }
}
