package travelbook

class Album {

	static belongsTo = [travel : Travel]
	static hasMany = [pictures: Picture]
	
    static constraints = {
    }
}
