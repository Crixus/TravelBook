package travelbook

import grails.plugins.springsecurity.SpringSecurityService
import org.springframework.dao.DataIntegrityViolationException

class UserController {


	def springSecurityService
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		def userInstance = springSecurityService.currentUser
		[usersList: User.list(params), usersTotal: User.count(), userInstance: userInstance]
	}

	def create() {
		[userInstance: new User(params)]
	}

	def save() {
		def userInstance = new User(params)
		if (!userInstance.save(flush: true)) {
			render(view: "create", model: [userInstance: userInstance])
			return
		}
 
		flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
		redirect(action: "show", id: userInstance.id)
	}

	def getcurrentuser() {
		def userInstance = springSecurityService.currentUser
		[userInstance: userInstance]

	}

	def friends() {
		def userInstance = springSecurityService.currentUser
		def userInstanceFriends = userInstance.getFriends()
		[userInstance: userInstance, userInstanceFriends: userInstanceFriends]
	}


	def redirectLogged( ) {
		User userInstance = springSecurityService.currentUser
		print (userInstance.id)
		redirect(action: "profile" , id:userInstance.id)
	}

	def profile(Long id) {
		def userInstance = springSecurityService.currentUser
		def userProfile = User.findById(id);
		def userProfileFriends = userProfile.getFriends()	
		def userProfileTravels = userProfile.getTravels()	
		def nameProfilePicture = userProfile.urlProfilePicture()
		[userInstance: userInstance, userProfile: userProfile, userProfileFriends: userProfileFriends, userProfileTravels: userProfileTravels, nameProfilePicture: nameProfilePicture]
	}

	def signin() {
		User userInstance = new User()
		userInstance.lastName = params["lastName"]
		userInstance.firstName = params["firstName"]
		userInstance.gender = params["gender"]
		userInstance.email = params["email"]
		userInstance.password = params["password"]
		userInstance.dateOfBirth = params["dateOfBirth"]
		userInstance.friends = null
		userInstance.travels = null
		userInstance.username = params["email"]

		if (!userInstance.save(flush: true)) {
			render(view: "create", model: [userInstance: userInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
		redirect(action: "show", id: userInstance.id)
	}

	def show(Long id) {
		def userInstance = User.get(id)
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
			redirect(action: "list")
			return
		}

		[userInstance: userInstance]
	}

	def edit(Long id) {
		def userInstance = User.get(id)
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
			redirect(action: "list")
			return
		}

		[userInstance: userInstance]
	}

	def update(Long id, Long version) {
		def userInstance = User.get(id)
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (userInstance.version > version) {
				userInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[message(code: 'user.label', default: 'User')] as Object[],
						"Another user has updated this User while you were editing")
				render(view: "edit", model: [userInstance: userInstance])
				return
			}
		}

		userInstance.properties = params

		if (!userInstance.save(flush: true)) {
			render(view: "edit", model: [userInstance: userInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
		redirect(action: "show", id: userInstance.id)
	}

	def delete(Long id) {
		def userInstance = User.get(id)
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
			redirect(action: "list")
			return
		}

		try {
			userInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
			redirect(action: "show", id: id)
		}
	}

	
	
	def deleteFriend(Long id) {
		User userInstanceFriend = User.get(id)
		User userInstance = springSecurityService.currentUser
		if (userInstance.isFriendWith(userInstanceFriend)){
			userInstance.friends.remove(userInstanceFriend)
			userInstance.save(flush:true)
			redirect(action: "profile", id: userInstance.id)
		}else {
			redirect(action: "friends")
		}
	}

	def addFriend(Long id) {

		User userInstanceFriend = User.get(id)
		User userInstance = springSecurityService.currentUser
		if (userInstance.isFriendWith(userInstanceFriend)){
			userInstance.friends.remove(userInstanceFriend)
			userInstance.save(flush:true)
			redirect(action: "profile", id: userInstance.id)
			return
		}
		redirect(action: "friends")
	}

	def deleteFriendFromList(Long id) {
		User userInstanceFriend = User.get(id)
		User userInstance = springSecurityService.currentUser
		if (userInstance.isFriendWith(userInstanceFriend)){
			userInstance.friends.remove(userInstanceFriend)
			userInstance.save(flush:true)
			redirect(action: "profile", id: userInstance.id)
			return
		}
		redirect(action: "list")
	}

	def addFriendFromList(Long id) {

		User userInstanceFriend = User.get(id)
		User userInstance = springSecurityService.currentUser
		if (userInstance.isFriendWith(userInstanceFriend)){
			userInstance.friends.remove(userInstanceFriend)
			userInstance.save(flush:true)
			redirect(action: "profile", id: userInstance.id)
			return
		}
		redirect(action: "list")
	}

}
