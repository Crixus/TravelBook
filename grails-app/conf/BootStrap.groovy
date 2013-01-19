import java.util.Date;

import travelbook.User

class BootStrap {

	def init = { servletContext ->
		User toto = new User(
				username: "toto@gmail.com",
				email: "toto@gmail.com",
				dateOfBirth: new Date(),
				name:"fosto",
				fisrtname: "toto",
				gender: "M",
				password: "toto!");
	}
	def destroy = {
	}
}
