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
	
	String lastName
	String firstName
	String email
	String gender
	Date dateOfBirth
	
	static hasMany = [friends : User, travels: Travel]

	static constraints = {
		username blank: false, unique: true
		password blank: false
		//hide some attribute not need to register
		enabled display: false
		accountExpired display: false
		accountLocked display: false
		passwordExpired display: false
		
		lastName (size: 3..16, blank: false, nullable: false)
		firstName (size: 3..16, blank: false, nullable: false)
		email (email: true, blank: false, unique: true, nullable: false)
		gender (inList: ["M", "F"], nullable: false)
		dateOfBirth max: new Date()
	}
	
	
	User(){
		  enabled = true
		  accountExpired = false
		  accountLocked =false
		  passwordExpired =false	
	}
	
	User(String lastName, String firstName, String email, String gender, Date dateOfBirth) {
		lastName = lastName
		firstName = firstName
		email = email
		gender = gender
		dateOfBirth = dateOfBirth
		username=email
		
		enabled = true
		accountExpired = false
		accountLocked =false
		passwordExpired =false
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
