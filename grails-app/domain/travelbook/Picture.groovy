package travelbook

class Picture {

	String path;
	String name;
	
	static belongsTo = [album: Album]
	
	
    static constraints = {
    }
}
