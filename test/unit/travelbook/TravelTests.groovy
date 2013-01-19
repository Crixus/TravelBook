package travelbook



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Travel)
class TravelTests {
	
	void test() {
		
	}
	
	/*
	void testConstraint(){
		
		def today = new Date()
		def tomorrow = today.next()
		
		def user = new User()
		user.addToTravels(new Travel(destination:"Rio", dateDebut:today, dateFin:tomorrow))
//		def travel = user.getTravel()
		def travel = new Travel()
		assert !travel.validate()
		assert "nullable" == travel.errors["destination"].code
		assert "nullable" == travel.errors["dateDebut"].code
		assert "nullable" == travel.errors["dateFin"].code
		
		travel = new Travel(destination:"Rio", dateDebut:tomorrow, dateFin:today)
		assert !travel.validate()
		
		travel = new Travel(destination:"Rio", dateDebut:today, dateFin:tomorrow)
		assert travel.validate()
	}
	
    void testSomething() {
       //fail "Implement me"
    }
    
    */
}
