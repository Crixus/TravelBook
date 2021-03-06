package travelbook

import grails.plugins.springsecurity.SpringSecurityService
import grails.test.mixin.*
@TestFor(UserController)

@Mock([User , SpringSecurityService])
class UserControllerTests {

	def populateValidParams(params) {
		assert params != null

		params["username"]= "cedric@gmail.com"
		params["password"] = "cedric!"
		params["lastName"] = "cedric"
		params["firstName"] = "cedric"
		params["email"]= "cedric@gmail.com"
		params["gender"] = "M"
		params["dateOfBirth"] = new Date("1988/07/17")
	}

	def populateValidParamsForsign(params) {
		assert params != null

		params["username"]= "nicolas@gmail.com"
		params["password"] = "nicolas!"
		params["lastName"] = "nicolas"
		params["firstName"] = "nicolas"
		params["email"]= "nicolas@gmail.com"
		params["gender"] = "M"
		params["dateOfBirth"] = new Date("1988/07/17")
	}

	void testIndex() {
		controller.index()

		assert "/user/list" == response.redirectedUrl
	}


	void testList() {
		def model = controller.list()
		
		assert model.usersList.size() == 0
		assert model.usersTotal == 0
		assert model.userInstance == null
	}
	
	void testCreate() {
		def model = controller.create()
		
		assert model.userInstance != null
	}

	void testSignin() {
		params.flush = true

		// Test invalid
		controller.signin()


		assert model.userInstance != null
		assert view == '/user/create'

		response.reset()

		// Test valid
		populateValidParamsForsign(params)
		controller.signin()


		assert response.redirectedUrl == '/user/show/1'
		assert controller.flash.message != null
		assert User.count() == 1
	}
	
	
	  

	void testSave() {
		params.flush = true

		// Test invalid
		controller.save()

		assert model.userInstance != null
		assert view == '/user/create'

		response.reset()

		// Test valid
		populateValidParams(params)
		controller.save()


		assert response.redirectedUrl == '/user/show/1'
		assert controller.flash.message != null
		assert User.count() == 1
	}

	void testShow() {
		controller.show()

		assert flash.message != null
		assert response.redirectedUrl == '/user/list'

		populateValidParams(params)
		def user = new User(params)

		assert user.save() != null

		params.id = user.id

		def model = controller.show()

		assert model.userInstance == user
	}

	void testgetcurrentuser() {
		def model = controller. getcurrentuser()

		assert model.userInstance == null
	}

	void testEdit() {
		controller.edit()

		assert flash.message != null
		assert response.redirectedUrl == '/user/list'

		populateValidParams(params)
		def user = new User(params)

		assert user.save() != null

		params.id = user.id

		def model = controller.edit()

		assert model.userInstance == user
	}

	
//	void testDeleteFriend() {
//		controller.deleteFriend()
//		
//		assert flash.message != null
//		assert response.redirectedUrl == '/user/friends'
// 
//		response.reset()
//
//		populateValidParams(params)
//		def user = new User(params)
//		
//		populateValidParamsForsign(params)
//		def userfriend = new User(params)
//		
//		user.addToFriends(userfriend)
//		assert user.save() != null
//		assert User.count() == 1
//
//		
//		params.id = user.id
//
//		controller.deleteFriend()
// 
//
//		assert User.count() == 0
//		assert User.get(user.id) == null
//		assert response.redirectedUrl == '/user/list'
//	}
	
	void testUpdate() {
		controller.update()

		assert flash.message != null
		assert response.redirectedUrl == '/user/list'

		response.reset()

		populateValidParams(params)
		def user = new User(params)

		assert user.save() != null

		// test invalid parameters in update
		params.id = user.id

		params.email = "invalid-mail.com"

		controller.update()

		assert view == "/user/edit"
		assert model.userInstance != null


		user.clearErrors()

		populateValidParams(params)
		controller.update()

		assert response.redirectedUrl == "/user/show/$user.id"
		assert flash.message != null

		//test outdated version number
		response.reset()
		user.clearErrors()

		populateValidParams(params)
		params.id = user.id
		params.version = -1
		controller.update()

		assert view == "/user/edit"
		assert model.userInstance != null
		assert model.userInstance.errors.getFieldError('version')
		assert flash.message != null
	}

	void testDelete() {
		controller.delete()
		assert flash.message != null
		assert response.redirectedUrl == '/user/list'

		response.reset()

		populateValidParams(params)
		def user = new User(params)

		assert user.save() != null
		assert User.count() == 1

		params.id = user.id

		controller.delete()

		assert User.count() == 0
		assert User.get(user.id) == null
		assert response.redirectedUrl == '/user/list'
	}


}
