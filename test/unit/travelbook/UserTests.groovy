package travelbook;
import grails.plugins.springsecurity.SpringSecurityService
import grails.test.mixin.*
import org.junit.*

@TestFor(User)
class UserTests {
	
	void testUrl(){
		
		User Camille = new User(
				username: "Camille@gmail.com",
				email: "Camille@gmail.com",
				dateOfBirth: new Date()-240 ,
				lastName:"Le Drean",
				firstName: "Camille",
				gender: "F",
				password: "pass");
					
		String path = Camille.urlProfilePicture()
		assertTrue(path == "p_default.jpg" || path == "p_1.jpg")
	}
	
	void testAge(){
		User Camille = new User(
			username: "Camille@gmail.com",
			email: "Camille@gmail.com",
			dateOfBirth: new Date()-240,
			lastName:"Le Drean",
			firstName: "Camille",
			gender: "F",
			password: "pass");
		assertTrue (Camille.getAge()==0)
	}
}
