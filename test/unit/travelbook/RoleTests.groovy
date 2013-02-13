package travelbook;

//import grails.test.mixin.*
//import org.junit.*


class RoleTests {
	
	void testConstraint(){
		
		def role = new Role()
		assert !role.validate()
		assert "nullable" == role.errors["authority"].code
		
		role = new Role(authority:"user")
		assert role.validate()
		
	}
}
