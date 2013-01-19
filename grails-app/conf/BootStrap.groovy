import java.util.Date;

import travelbook.User

class BootStrap {

	def init = { servletContext ->
		User defaut = new User(
				username: "default@travelbook.com",
				email: "default@travelbook.com",
				dateOfBirth: new Date().previous(),
				lastName:"Fotso",
				firstName: "Christobal",
				gender: "M",
				password: "password")
		if (!defaut.save(flush: true)) {
			defaut.errors.each {
				println it
			}
		}
		
		
	}
	def destroy = {
	}
}
