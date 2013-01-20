package travelbook

class Picture {

	String path;
	String name;
	
	Album album
	
	static belongsTo = [album: Album]
	
    static constraints = {
		path blank:false
		name blank:false
    }
}
