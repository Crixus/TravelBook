package travelbook



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Album)
class AlbumTests {
	
	void testConstraint(){
		
		def today = new Date()
		def tomorrow = today.next()
		def yesterday = today.previous()
		
		def user = new User(username:"Deuxieme", password:"oulala123", lastName:"Campos", firstName:"Ludovic",email:"lolitude@hotmail.fr",
			gender:"M", dateOfBirth:yesterday)
		
		def travel = new Travel(destination:"Rio", dateDebut:today, dateFin:tomorrow, member:user)
		
		def existingAlbum = new Album(name:"premier", description:"ceci_est_une_description", dateCreation:today, dateModification:today, travel:travel)
		
		mockForConstraintsTests(Album, [existingAlbum])
		
		def album = new Album(travel:travel)
		assert !album.validate()
		assert "nullable" == album.errors["name"]
		
		album = new Album(name:"premier", description:"une_autre_definition", dateCreation:today, dateModification:today, travel:travel)
		assert !album.validate()
		assert "unique" == album.errors["name"]
		
		album = new Album(name:"deuxieme",dateCreation:today, dateModification:today, travel:travel)
		assert album.validate()
	}
	
    void testSomething() {
       //fail "Implement me"
    }
}
