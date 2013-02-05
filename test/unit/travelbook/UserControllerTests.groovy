package travelbook

import java.util.Date;

import org.junit.*
import grails.test.mixin.*

@TestFor(UserController)
@Mock([User])
class UserControllerTests {

	def populateValidParams(params) {
		assertNotNull(params)

		params["username"]= "cedric@gmail.com"
		params["password"] = "cedric!"
		params["lastName"] = "cedric"
		params["firstName"] = "cedric"
		params["email"]= "cedric@gmail.com"
		params["gender"] = "M"
		params["dateOfBirth"] = new Date("1988/07/17")
	}

	void testIndex() {
		controller.index()
		assertEquals("/user/list", response.redirectedUrl)
	}

	
	void testList() {
		def model
		model = controller.list()
		assertEquals(model.userInstanceList.size(), 0)
		assertEquals(model.userInstanceTotal, 0)
		
		params.max = 1000
		model = controller.list()
		assertEquals(model.userInstanceList.size(), 0)
		assertEquals(model.userInstanceTotal, 0)
	}

	void testCreate() {
		def model = controller.create()

		assertNotNull(model.userInstance)
	}

	
	void testSave() {
		params.flush = true
		
		// Test invalid
		controller.save()

		assertNotNull(model.userInstance)
		assertEquals(view, '/user/create')

		response.reset()

		// Test valid
		populateValidParams(params)
		controller.save()

		assertEquals(response.redirectedUrl, '/user/show/1')
		assertNotNull(controller.flash.message)
		assertEquals(User.count(), 1)
	}
	
	void testShow() {
		controller.show()

		assertNotNull(flash.message)
		assertEquals(response.redirectedUrl, '/user/list')

		populateValidParams(params)
		def user = new User(params)

		assertNotNull(user.save())

		params.id = user.id

		def model = controller.show()

		assertEquals(model.userInstance, user)
	}

	void testEdit() {
		controller.edit()

		assertNotNull(flash.message)
		assertEquals(response.redirectedUrl, '/user/list')

		populateValidParams(params)
		def user = new User(params)

		assertNotNull(user.save())

		params.id = user.id

		def model = controller.edit()

		assertEquals(model.userInstance, user)
	}

	void testUpdate() {
		controller.update()

		assertNotNull(flash.message)
		assertEquals(response.redirectedUrl, '/user/list')

		response.reset()

		populateValidParams(params)
		def user = new User(params)

		assertNotNull(user.save())

		// test invalid parameters in update
		params.id = user.id
		
		params.email = "invalid-mail.com"

		controller.update()

		assertEquals(view, "/user/edit")
		assertNotNull(model.userInstance)

		user.clearErrors()

		populateValidParams(params)
		controller.update()

		assert response.redirectedUrl == "/user/show/$user.id"
		assertNotNull(flash.message)

		//test outdated version number
		response.reset()
		user.clearErrors()

		populateValidParams(params)
		params.id = user.id
		params.version = -1
		controller.update()

		assert view == "/user/edit"
		assertNotNull(model.userInstance)
		assert model.userInstance.errors.getFieldError('version')
		assertNotNull(flash.message)
	}

	void testDelete() {
		controller.delete()
		assertNotNull(flash.message)
		assertEquals(response.redirectedUrl, '/user/list')

		response.reset()

		populateValidParams(params)
		def user = new User(params)

		assertNotNull(user.save())
		assertEquals(User.count(), 1)

		params.id = user.id

		controller.delete()

		assertEquals(User.count(), 0)
		assertNull(User.get(user.id))
		assertEquals(response.redirectedUrl, '/user/list')
	}
}
