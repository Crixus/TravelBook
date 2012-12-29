package travelbook

class Travel {
	
	String destination;
	Date dateDebut;
	Date dateFin;
	
	static belongsTo = [member : User]
	static hasMany = [albums: Album]
	
    static constraints = {
    }
}
