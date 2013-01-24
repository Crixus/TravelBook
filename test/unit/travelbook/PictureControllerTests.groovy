package travelbook



import org.junit.*
import grails.test.mixin.*
import javassist.bytecode.ByteArray

//@TestFor(PictureController)
@Mock(Picture)
class PictureControllerTests {

    def populateValidParams(params) {
        assert params != null
		
		def today = new Date()
		def tomorrow = today.next()
		def yesterday = today.previous()
		byte[] image
		image = [0,1,0,1,0,1]
		def user = new User(username:"Deuxieme", password:"oulala123", lastName:"Campos", firstName:"Ludovic",email:"lolitude@hotmail.fr",
			gender:"M", dateOfBirth:yesterday)		
		def travel = new Travel(destination:"Rio", dateDebut:today, dateFin:tomorrow, member:user)
		def album = new Album(name:"deuxieme",dateCreation:today, dateModification:today, travel:travel)
		
        params["name"] = 'toto'
		params["image"] = image
		params["album"] = album
		
    }

    void testIndex() {
        controller.index()
        assert "/picture/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.pictureInstanceList.size() == 0
        assert model.pictureInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.pictureInstance != null
    }

    void testSave() {
        controller.save()

        assert model.pictureInstance != null
        assert view == '/picture/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/picture/show/1'
        assert controller.flash.message != null
        assert Picture.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/picture/list'

        populateValidParams(params)
        def picture = new Picture(params)

        assert picture.save() != null

        params.id = picture.id

        def model = controller.show()

        assert model.pictureInstance == picture
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/picture/list'

        populateValidParams(params)
        def picture = new Picture(params)

        assert picture.save() != null

        params.id = picture.id

        def model = controller.edit()

        assert model.pictureInstance == picture
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/picture/list'

        response.reset()

        populateValidParams(params)
        def picture = new Picture(params)

        assert picture.save() != null

        // test invalid parameters in update
        params.id = picture.id
        //TODO: add invalid values to params object
		params.image = 'jkhkdj'
        controller.update()

        assert view == "/picture/edit"
        assert model.pictureInstance != null

        picture.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/picture/show/$picture.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        picture.clearErrors()

        populateValidParams(params)
        params.id = picture.id
        params.version = -1
        controller.update()

        assert view == "/picture/edit"
        assert model.pictureInstance != null
        assert model.pictureInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/picture/list'

        response.reset()

        populateValidParams(params)
        def picture = new Picture(params)

        assert picture.save() != null
        assert Picture.count() == 1

        params.id = picture.id

        controller.delete()

        assert Picture.count() == 0
        assert Picture.get(picture.id) == null
        assert response.redirectedUrl == '/picture/list'
    }
}
