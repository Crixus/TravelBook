package travelbook

class Member {
	
	String _nickname
	String _email
	String _gender
	Date _dateOfBirth
	
	static hasMany = [friends : Member, travels: Travel]
	
    static constraints = {
    }
}
