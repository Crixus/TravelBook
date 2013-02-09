package travelbook

import java.util.Date
import grails.plugins.springsecurity.SpringSecurityService

class User {

	transient springSecurityService 

	String username
	String password
	
	String lastName
	String firstName
	String email
	String gender
	Date dateOfBirth
	
	boolean enabled = true
	boolean accountExpired = false
	boolean accountLocked = false
	boolean passwordExpired = false
	
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
		friends (nullable:true)
		travels(nullable:true)
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
		if(springSecurityService ){
			if (isDirty('password')) {
				encodePassword()
			}
		}
		
	}

	def urlProfilePicture(Long id){
		String filename = new String();
		String defaut = "/TravelBook/static/images/picts/p_default.jpg"
		filename = "/TravelBook/static/images/picts/p_"+id+".jpg"
		try
		{
		  BufferedReader reader = new BufferedReader(new FileReader(filename));
		}
		catch (Exception e)
		{
		  System.err.format("Exception occurred trying to read '%s'.", filename);
		  return "p_default.jpg"
		}
		return "p_"+id+".jpg"
	}
	
	def getAge(){
		
		 Calendar curr = Calendar.getInstance();
		 Calendar birth = Calendar.getInstance();
		 birth.setTime(this.dateOfBirth);
		 int yeardiff = curr.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
		 curr.add(Calendar.YEAR,-yeardiff);
		 if(birth.after(curr)){
			 yeardiff = yeardiff - 1;
		 }
		 return yeardiff;
	}
	protected void encodePassword() {
		if(springSecurityService ){
			password = springSecurityService.encodePassword(password)
		}
		 
		
	}
}
