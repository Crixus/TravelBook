package travelbook

class Travel {
	
	String _destination;
	Date _dateDebut;
	Date dateFin;
	
	static belongsTo = [member : User]
	static hasMany = [albums: Album]
	
    static constraints = {
    }
}
