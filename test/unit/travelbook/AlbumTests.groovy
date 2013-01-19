package travelbook



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Album)
class AlbumTests {
	
	void test() {
		
	}
	
	/*
	void testConstraint(){
		
		def today = new Date()
		
		def existingAlbum = new Album(name:"premier", description:"ceci_est_une_description", dateCreation:today, dateModification:today)
		
		mockForConstraintsTests(Album, [existingAlbum])
		
		def album = new Album()
		assert !album.validate()
		assert "nullable" == album.errors["name"]
		
		album = new Album(name:"premier", description:"une_autre_definition", dateCreation:today, dateModification:today)
		assert !album.validate()
		assert "unique" == album.errors["name"]
		println(album.errors)
		
		
		album = new Album(name:"deuxieme",dateCreation:today, dateModification:today)
		assert album.validate()
	}
	
    void testSomething() {
       //fail "Implement me"
    }
    
    */
}
