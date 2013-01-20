package travelbook



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Travel)
class TravelTests {
	
	void testConstraint(){
		
		def today = new Date()
		def tomorrow = today.next()
		def yesterday = today.previous()
		
		def user = new User(username:"Deuxieme", password:"oulala123", lastName:"Campos", firstName:"Ludovic",email:"lolitude@hotmail.fr",
						gender:"M", dateOfBirth:yesterday)

		def travel = new Travel(member:user)
		assert !travel.validate()
		assert "nullable" == travel.errors["destination"].code
		assert "nullable" == travel.errors["dateDebut"].code
		assert "nullable" == travel.errors["dateFin"].code
		
		travel = new Travel(destination:"Rio", dateDebut:tomorrow, dateFin:today, member:user)
		assert !travel.validate()
		
		travel = new Travel(destination:"Rio", dateDebut:today, dateFin:tomorrow, member:user)
		assert travel.validate()
		
	}
	
    void testSomething() {
       //fail "Implement me"
    }
}
