package travelbook

class Member {
	
	String _nickname
	String _email
	String _gender
	Date _dateOfBirth
	
	static hasMany = [amis : Member, travels: Travel]
	
    static constraints = {
    }
}
