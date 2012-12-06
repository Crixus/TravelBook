package travelbook

class User {
	
	String _nickname
	Date _dateOfBirth
	
	String _email
	String _password // md5 Encrypted
	
	static hasMany = [photos: Photo]
	
    static constraints = {
    }
}
