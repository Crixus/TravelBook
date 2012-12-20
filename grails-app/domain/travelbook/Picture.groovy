package travelbook

class Picture {

	String _path;
	String _name;
	
	static belongsTo = [album: Album]
	
	
    static constraints = {
    }
}
