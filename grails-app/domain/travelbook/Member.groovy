package travelbook

class Member {
	
	String _nickname
	String _email
	String _gender
	Date _dateOfBirth
	
	static hasMany = [friends : Member, travels: Travel]
	
    static constraints = {
		_nickname (size: 3..16, blank: false, nullable: false)
		_email (email: true, blank: false, unique: true, nullable: false)
		_gender (inList: ["Male", "Female"], nullable: false)
    }
	
	Member(String nickname, String email, String gender, Date dateOfBirth) {
		_nickname = nickname
		_email = email
		_gender = gender
		_dateOfBirth = dateOfBirth
	}
}
