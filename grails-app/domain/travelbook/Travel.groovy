package travelbook

class Travel {
	
	String destination;
	Date dateDebut;
	Date dateFin;
	
	static belongsTo = [member : User]
	static hasMany = [albums: Album]
	
    static constraints = {
		destination (blank: false)
		dateDebut (blank:false)
		dateFin (blank:false, validator:{val, obj -> val?.after(obj.dateDebut)})
    }
}
