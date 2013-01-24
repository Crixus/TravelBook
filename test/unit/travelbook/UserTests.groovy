package travelbook;
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserTests implements IDomainClassDefaultTest{
	
	void testConstraint(){
		
		def today = new Date()
		def yesterday = today.previous()
		def tomorrow = today.next()
		
		def existingUser = new User(username:"Premier", password:"oulala123", lastName:"Campos", firstName:"Ludovic",email:"lolitude7@hotmail.fr",
									gender:"M", dateOfBirth:yesterday)
		assert existingUser.validate()
		
		mockForConstraintsTests(User, [existingUser])
		
		def user = new User()
		assert !user.validate()
		assert "nullable" == user.errors["username"]
		assert "nullable" == user.errors["password"]
		assert "nullable" == user.errors["lastName"]
		assert "nullable" == user.errors["firstName"]
		assert "nullable" == user.errors["email"]
		assert "nullable" == user.errors["gender"]
		
		user = new User(username:"Premier", password:"oulala123", lastName:"Campos", firstName:"Ludovic",email:"lolitude7@hotmail.fr",
						gender:"M", dateOfBirth:yesterday)
		assert !user.validate()
		assert "unique" == user.errors["username"]
		assert "unique" == user.errors["email"]
		
		user = new User(username:"Deuxieme", password:"oulala123", lastName:"C", firstName:"L",email:"lolitude7hotmail.fr",
						gender:"M", dateOfBirth:tomorrow)
		assert !user.validate()
		assert "size" == user.errors["lastName"]
		assert "size" == user.errors["firstName"]
		assert "email" == user.errors["email"]
		assert "max" == user.errors["dateOfBirth"]
		println(user.errors)
		
		user = new User(username:"Deuxieme", password:"oulala123", lastName:"Campos", firstName:"Ludovic",email:"lolitude@hotmail.fr",
						gender:"M", dateOfBirth:yesterday)
		assert user.validate()
	}

	@Override
	public void testInstance() {

		def today = new Date()
		def yesterday = today.previous()
		def tomorrow = today.next()
		
		def user = new User(username:"Premier", password:"oulala123", lastName:"Campos", firstName:"Ludovic",email:"lolitude7@hotmail.fr",
									gender:"M", dateOfBirth:yesterday)
		assert user != null
		
		user.setUsername("toto")
		user.setPassword("toto")
		user.setLastName("toto")
		user.setFirstName("toto")
		user.setEmail("toto@hotmail.fr")
		user.setGender("F")
		user.setDateOfBirth(yesterday.previous())
		
		assert user.getUsername()   == "toto"
		assert user.getPassword()   == "toto"
		assert user.getLastName()   == "toto"
		assert user.getFirstName()  == "toto"
		assert user.getEmail()      == "toto@hotmail.fr"
		assert user.getGender()     == "F"
		assert user.getDateOfBirth()== yesterday.previous()
	}
}
