package travelbook

import static grails.test.MockUtils.*
//import grails.test.mixin.TestFor

import spock.lang.Specification



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
