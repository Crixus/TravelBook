package travelbook

import java.util.Date;

import org.junit.*
import grails.test.mixin.*

@TestFor(UserController)
@Mock([User])
class UserControllerTests {

	def springSecurityService
	
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
<<<<<<< .mine
		assert "/user/test/list" == response.redirectedUrl
=======
		assertEquals("/user/list", response.redirectedUrl)
>>>>>>> .theirs
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

<<<<<<< .mine
		assert model.userInstance != null
		assert view == '/user/test/create'
=======
		assertNotNull(model.userInstance)
		assertEquals(view, '/user/create')
>>>>>>> .theirs

		response.reset()

		// Test valid
		populateValidParams(params)
		controller.save()

<<<<<<< .mine
		assert response.redirectedUrl == '/user/test/show/1'
		assert controller.flash.message != null
		assert User.count() == 1
=======
		assertEquals(response.redirectedUrl, '/user/show/1')
		assertNotNull(controller.flash.message)
		assertEquals(User.count(), 1)
>>>>>>> .theirs
	}
	
	void testShow() {
		controller.show()

<<<<<<< .mine
		assert flash.message != null
		assert response.redirectedUrl == '/user/test/list'
=======
		assertNotNull(flash.message)
		assertEquals(response.redirectedUrl, '/user/list')
>>>>>>> .theirs

		populateValidParams(params)
		def user = new User(params)

		assertNotNull(user.save())

		params.id = user.id

		def model = controller.show()

		assertEquals(model.userInstance, user)
	}

	void testEdit() {
		controller.edit()

<<<<<<< .mine
		assert flash.message != null
		assert response.redirectedUrl == '/user/test/list'
=======
		assertNotNull(flash.message)
		assertEquals(response.redirectedUrl, '/user/list')
>>>>>>> .theirs

		populateValidParams(params)
		def user = new User(params)

		assertNotNull(user.save())

		params.id = user.id

		def model = controller.edit()

		assertEquals(model.userInstance, user)
	}

	void testUpdate() {
		controller.update()

<<<<<<< .mine
		assert flash.message != null
		assert response.redirectedUrl == '/user/test/list'
=======
		assertNotNull(flash.message)
		assertEquals(response.redirectedUrl, '/user/list')
>>>>>>> .theirs

		response.reset()

		populateValidParams(params)
		def user = new User(params)

		assertNotNull(user.save())

		// test invalid parameters in update
		params.id = user.id
		
		params.email = "invalid-mail.com"

		controller.update()

<<<<<<< .mine
		assert view == "/user/test/edit"
		assert model.userInstance != null
=======
		assertEquals(view, "/user/edit")
		assertNotNull(model.userInstance)
>>>>>>> .theirs

		user.clearErrors()

		populateValidParams(params)
		controller.update()

		assert response.redirectedUrl == "/user/test/show/$user.id"
		assertNotNull(flash.message)

		//test outdated version number
		response.reset()
		user.clearErrors()

		populateValidParams(params)
		params.id = user.id
		params.version = -1
		controller.update()

		assert view == "/user/test/edit"
		assertNotNull(model.userInstance)
		assert model.userInstance.errors.getFieldError('version')
		assertNotNull(flash.message)
	}

	void testDelete() {
		controller.delete()
<<<<<<< .mine
		assert flash.message != null
		assert response.redirectedUrl == '/user/test/list'
=======
		assertNotNull(flash.message)
		assertEquals(response.redirectedUrl, '/user/list')
>>>>>>> .theirs

		response.reset()

		populateValidParams(params)
		def user = new User(params)

		assertNotNull(user.save())
		assertEquals(User.count(), 1)

		params.id = user.id

		controller.delete()

<<<<<<< .mine
		assert User.count() == 0
		assert User.get(user.id) == null
		assert response.redirectedUrl == '/user/test/list'
=======
		assertEquals(User.count(), 0)
		assertNull(User.get(user.id))
		assertEquals(response.redirectedUrl, '/user/list')
>>>>>>> .theirs
	}
}
