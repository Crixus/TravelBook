package travelbook

class Picture {

	String path;
	String name;
	
	static belongsTo = [album: Album]
	
    static constraints = {
		path blank:false
		name blank:false
    }
}
