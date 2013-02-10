package travelbook

//import static org.junit.Assert.*

//import grails.test.mixin.*
import grails.test.mixin.TestFor
//import grails.test.mixin.support.*
//import org.junit.*
import spock.lang.Specification
import static grails.test.MockUtils.*


/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
//@TestMixin(GrailsUnitTestMixin)

class UserControllerSpec extends Specification{
	
	def mockI18N = { controller ->
    controller.metaClass.message = { Map map ->
      return "I18N message ($map)"
    }
	}
	
  
 def 'index action'() {
		setup:
		mockLogging(UserController, true)
	
		when:
		controller.index()
	
		then:
		response.redirectedUrl =="/user/list"
	  }


	
	def 'show action: existing user'() {
		setup:
		mockLogging(UserController, true)
		mockDomain(User, [userInstance])
		mockI18N(UserController)
		controller.params.id = userInstance.id
	
		expect:
		controller.show() == [userInstance: userInstance]
	
	
		where:
		userInstance =  new User(
				username: "jeremy@gmail.com",
				email: "jeremy@gmail.com",
				dateOfBirth: new Date()-220,
				lastName:"jerem",
				firstName: "jeremy",
				gender: "M",
				password: "jerem!");
	
	  }
	
	
	  
	  def 'edit action: existing user'() {
		  setup:
		  mockLogging(UserController, true)
		  mockDomain(User, [userInstance])
		  mockI18N(UserController)
		  controller.params.id = userInstance.id
	  
		  expect:
		  controller.edit() == [userInstance: userInstance]
	  
	  
		  where:
		  userInstance = new User(
				username: "jeremy@gmail.com",
				email: "jeremy@gmail.com",
				dateOfBirth: new Date()-220,
				lastName:"jerem",
				firstName: "jeremy",
				gender: "M",
				password: "jerem!")
	  
		}
	  
		
		
	
	}
