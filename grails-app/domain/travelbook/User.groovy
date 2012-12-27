package travelbook

import java.util.Date;

class User {

	transient springSecurityService

	String username
	String password
	boolean enabled = true
	boolean accountExpired = false
	boolean accountLocked =false
	boolean passwordExpired =false
	
	String _name
	String _fisrtname
	String _email
	String _gender
	Date _dateOfBirth
	
	static hasMany = [friends : User, travels: Travel]

	static constraints = {
		username blank: false, unique: true
		password blank: false
		//hide some attribute not need to register
		enabled display: false
		accountExpired display: false
		accountLocked display: false
		passwordExpired display: false
		
		
		_fisrtname (size: 3..16, blank: false, nullable: false)
		_email (email: true, blank: false, unique: true, nullable: false)
		_gender (inList: ["M", "F"], nullable: false)
	}
	
	
	User(){
		  enabled = true
		  accountExpired = false
		  accountLocked =false
		  passwordExpired =false	
	}
	
	User(String nickname, String email, String gender, Date dateOfBirth) {
		_nickname = nickname
		_email = email
		_gender = gender
		_dateOfBirth = dateOfBirth
		username=email
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
