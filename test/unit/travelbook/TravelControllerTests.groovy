package travelbook

@TestFor(TravelController)
@Mock(Travel)
 
class TravelControllerTests {

	User user = new User(
	username: "toto@gmail.com",
	email: "toto@gmail.com",
	dateOfBirth: new Date()-120,
	lastName:"McLane",
	firstName: "Toto",
	gender: "M",
	password: "pass")

	def populateValidParams(params) {
		assert params != null

		params["destination"] = "Marakech"
		params["dateDebut"] = Date.parse("yyyy-M-d", "2013-01-01")
		params["dateFin"] = Date.parse("yyyy-M-d", "2013-01-10")
		params["member"] = user;
	}

	void testIndex() {
		controller.index()
		assert "/travel/list" == response.redirectedUrl
	}

	void testCreate() {
		def model = controller.create()

		assert model.travelInstance != null
	}

	void testSave() {
		controller.save()

		assert model.travelInstance != null
		assert view == '/travel/create'

		response.reset()

		populateValidParams(params)
		controller.save()

		assert response.redirectedUrl == '/travel/show/1'
		assert controller.flash.message != null
		assert Travel.count() == 1
	}

	void testShow() {
		controller.show()

		assert flash.message != null
		assert response.redirectedUrl == '/travel/list'

		populateValidParams(params)
		def travel = new Travel(params)

		assert travel.save() != null

		params.id = travel.id

		def model = controller.show()

		assert model.travelInstance == travel
	}

	void testEdit() {
		controller.edit()

		assert flash.message != null
		assert response.redirectedUrl == '/travel/list'

		populateValidParams(params)
		def travel = new Travel(params)

		assert travel.save() != null

		params.id = travel.id

		def model = controller.edit()

		assert model.travelInstance == travel
	}

	void testUpdate() {
		controller.update()

		assert flash.message != null
		assert response.redirectedUrl == '/travel/list'

		response.reset()

		populateValidParams(params)
		def travel = new Travel(params)

		assert travel.save() != null

		// test invalid parameters in update
		params.id = travel.id
		params.destination = "d"
		//TODO: add invalid values to params object

		controller.update()

		assert view == "/travel/edit"
		assert model.travelInstance != null

		travel.clearErrors()

		populateValidParams(params)
		controller.update()

		assert response.redirectedUrl == "/travel/show/$travel.id"
		assert flash.message != null

		//test outdated version number
		response.reset()
		travel.clearErrors()

		populateValidParams(params)
		params.id = travel.id
		params.version = -1
		controller.update()

		assert view == "/travel/edit"
		assert model.travelInstance != null
		assert model.travelInstance.errors.getFieldError('version')
		assert flash.message != null
	}

	void testDelete() {
		controller.delete()
		assert flash.message != null
		assert response.redirectedUrl == '/travel/list'

		response.reset()

		populateValidParams(params)
		def travel = new Travel(params)

		assert travel.save() != null
		assert Travel.count() == 1

		params.id = travel.id

		controller.delete()

		assert Travel.count() == 0
		assert Travel.get(travel.id) == null
		assert response.redirectedUrl == '/travel/list'
	}
}
