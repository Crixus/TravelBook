package travelbook

import java.util.Date;

import org.junit.*
import grails.test.mixin.*

@TestFor(UserController)
@Mock(User)
class UserControllerJunitTests {

	def springSecurityService
	
	def populateValidParams(params) {
		assert params != null
		// TODO: Populate valid properties like...
		//params = new User(username: "toto", email: "toto@gmail.com",dateOfBirth: new Date(),name:"fosto",fisrtname: "toto", gender: "M", password: "toto!");

		
		params["username"]="bocoum@gmail.com"
		params["email"]= "abocoum@hotmail.fr"
		params["dateOfBirth"] = new Date()-120
		params["lastName"] ="BOCOUM"
		params["fisrtname"] = "Adama"
		params["gender"] ="M"
		params["password"] = "toto!"

	}

	void testIndex() {
		controller.index()
		assert "/user/test/list" == response.redirectedUrl
	}

	void testList() {

		def model = controller.list()

		assert model.userInstanceList.size() == 0
		assert model.userInstanceTotal == 0
	}

	void testCreate() {
		def model = controller.create()

		assert model.userInstance != null
	}

	void testSave() {
		controller.save()

		assert model.userInstance != null
		assert view == '/user/test/create'

		response.reset()

		populateValidParams(params)
		controller.save()

		assert response.redirectedUrl == '/user/test/show/1'
		assert controller.flash.message != null
		assert User.count() == 1
	}

	void testShow() {
		controller.show()

		assert flash.message != null
		assert response.redirectedUrl == '/user/test/list'

		populateValidParams(params)
		def user = new User(params)

		assert user.save() != null

		params.id = user.id

		def model = controller.show()

		assert model.userInstance == user
	}

	void testEdit() {
		controller.edit()

		assert flash.message != null
		assert response.redirectedUrl == '/user/test/list'

		populateValidParams(params)
		def user = new User(params)

		assert user.save() != null

		params.id = user.id

		def model = controller.edit()

		assert model.userInstance == user
	}

	void testUpdate() {
		controller.update()

		assert flash.message != null
		assert response.redirectedUrl == '/user/test/list'

		response.reset()

		populateValidParams(params)
		def user = new User(params)

		assert user.save() != null

		// test invalid parameters in update
		params.id = user.id
		//TODO: add invalid values to params object

		controller.update()

		assert view == "/user/test/edit"
		assert model.userInstance != null

		user.clearErrors()

		populateValidParams(params)
		controller.update()

		assert response.redirectedUrl == "/user/test/show/$user.id"
		assert flash.message != null

		//test outdated version number
		response.reset()
		user.clearErrors()

		populateValidParams(params)
		params.id = user.id
		params.version = -1
		controller.update()

		assert view == "/user/test/edit"
		assert model.userInstance != null
		assert model.userInstance.errors.getFieldError('version')
		assert flash.message != null
	}

	void testDelete() {
		controller.delete()
		assert flash.message != null
		assert response.redirectedUrl == '/user/test/list'

		response.reset()

		populateValidParams(params)
		def user = new User(params)

		assert user.save() != null
		assert User.count() == 1

		params.id = user.id

		controller.delete()

		assert User.count() == 0
		assert User.get(user.id) == null
		assert response.redirectedUrl == '/user/test/list'
	}
}