package travelbook

class Travel {
	
	static belongsTo = [member : Member]
	static hasMany = [albums: Album]

    static constraints = {
    }
}
