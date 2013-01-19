package travelbook



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Picture)
class PictureTests {
	
	void test() {
		
	}
	
	/*
		void testConstraint(){
		
			def picture = new Picture()
			assert !picture.validate()
			assert "nullable" == picture.errors["path"].code
			assert "nullable" == picture.errors["name"].code
			
			picture = new Picture(path:"ici", name: "toto")
			assert picture.validate()
			println(picture.errors)
			
	}
		
    void testSomething() {
       //fail "Implement me"
    }
    
    */
}
