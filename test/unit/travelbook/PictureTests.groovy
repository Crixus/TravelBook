package travelbook



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Picture)
class PictureTests {
	void testConstraint(){
			
			def today = new Date()
			def tomorrow = today.next()
			def yesterday = today.previous()
			byte[] image
			
			image = [0,1,0,1,0,1]
			
			def user = new User(username:"Deuxieme", password:"oulala123", lastName:"Campos", firstName:"Ludovic",email:"lolitude@hotmail.fr",
				gender:"M", dateOfBirth:yesterday)
			
			def travel = new Travel(destination:"Rio", dateDebut:today, dateFin:tomorrow, member:user)
			
			def album = new Album(name:"deuxieme",dateCreation:today, dateModification:today, travel:travel)
			
			def picture = new Picture(album:album)
			assert !picture.validate()
			assert "nullable" == picture.errors["image"].code
			assert "nullable" == picture.errors["name"].code
			
			picture = new Picture(image:image, name: "toto", album:album)
			assert picture.validate()
			
	}
		
    void testSomething() {
       //fail "Implement me"
    }
}
