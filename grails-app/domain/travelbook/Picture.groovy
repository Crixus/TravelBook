package travelbook

class Picture {

	Byte[] image;
	String name;
	
	Album album
	
	static belongsTo = [album: Album]
	
    static constraints = {
		path blank:false
		name blank:false
    }
}
