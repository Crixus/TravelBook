package travelbook;
import grails.plugins.springsecurity.SpringSecurityService
import grails.test.mixin.*
import org.junit.*

@TestFor(User)
class UserTests {
	
	void testUrl(){
		def today = new Date()
		def yesterday = today.previous()
		def tomorrow = today.next()
		
		User Camille = new User(
				username: "Camille@gmail.com",
				email: "Camille@gmail.com",
				dateOfBirth: new Date()-240 ,
				lastName:"Le Drean",
				firstName: "Camille",
				gender: "F",
				password: "pass");
					
		String path = Camille.urlProfilePicture(1)
		assertTrue(path == "/TravelBook/static/images/profile/default.jpg" || path == "/TravelBook/static/images/profile/1.jpg")
	}
}
