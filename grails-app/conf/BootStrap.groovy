import java.text.SimpleDateFormat
import java.util.Date;

import travelbook.Album
import travelbook.Travel
import travelbook.User

class BootStrap {

	def init = { servletContext ->
		// rajout des donn�es pour les test concernant les utilisateurs
		User toto = new User(
				username: "toto@gmail.com",
				email: "toto@gmail.com",
				dateOfBirth: new Date()-120,
				lastName:"McLane",
				firstName: "Toto",
				gender: "M",
				password: "pass");

		if (!toto.save()){
			log.error "Could not save user!!"
			log.error "${toto.errors}"
		}

		User jeremy = new User(
				username: "jeremy.curny@gmail.com",
				email: "jeremy.curny@gmail.com",
				dateOfBirth: Date.parse("yyyy-M-d", "1988-07-17"),
				lastName:"Curny",
				firstName: "Jeremy",
				gender: "M",
				password: "pass");

		if (!jeremy.save()){
			log.error "Could not save user!!"
			log.error "${jeremy.errors}"
		}

		User anna = new User(
				username: "anna@gmail.com",
				email: "anna@gmail.com",
				dateOfBirth: new Date()-240 ,
				lastName:"Cejalvo",
				firstName: "Anna",
				gender: "F",
				password: "pass");

		if (!anna.save()){
			log.error "Could not save user!!"
			log.error "${anna.errors}"
		}
		
		User adama = new User(
				username: "adama@gmail.com",
				email: "adama@gmail.com",
				dateOfBirth: Date.parse("yyyy-M-d", "1990-04-23"),

				lastName:"Bocoum",
				firstName: "Adama",
				gender: "M",
				password: "pass");

		if (!adama.save()){
			log.error "Could not save user!!"
			log.error "${adama.errors}"
		}

		User Marouan = new User(
				username: "marouan@gmail.com",
				email: "marouan@gmail.com",
				dateOfBirth: Date.parse("yyyy-M-d", "1965-07-17"),
				lastName:"Chamss",
				firstName: "Marouan",
				gender: "M",
				password: "pass");

		if (!Marouan.save()){
			log.error "Could not save user!!"
			log.error "${Marouan.errors}"
		}

		adama.addToFriends(anna)
		adama.addToFriends(jeremy)
		adama.addToFriends(toto)

		anna.addToFriends(toto)
		anna.addToFriends(jeremy)

		def Paris = new Travel(member:adama)
		def Toulouse = new Travel(member:anna)
		def Nantes = new Travel(member:toto)
		def Lyon = new Travel(member:jeremy)
		def Cameroun = new Travel(member:toto)

		Paris = new Travel (destination: 'Paris', dateDebut:new Date()-86, dateFin: new Date()-80, anna:User)
		Toulouse = new Travel (destination: 'Toulouse', dateDebut:new Date()-86, dateFin: new Date()-75, adama: User)
		Nantes = new Travel (destination: 'Nantes', dateDebut:new Date()-86, dateFin: new Date()-80, anna:User)
		Lyon = new Travel (destination: 'Lyon', dateDebut:new Date()-86, dateFin: new Date()-75, adama: User)
		Cameroun = new Travel (destination: 'Cameroun', dateDebut:new Date()-86, dateFin: new Date()-75, adama: User)
		
		Paris.save();
		Toulouse.save();
		Nantes.save();
		Lyon.save();
		Cameroun.save();

		Album PhotoParis = new Album ( name: 'PhotoParis', description: 'photo du voyage de paris', dateCreation: '', dateModification: '')
		Album PhotoToulouse = new Album ( name: 'PhotoToulouse', description: 'photo du voyage de Toulouse', dateCreation: '', dateModification: '')
		Album PhotoNantes = new Album ( name: 'PhotoNantes', description: 'photo du voyage de Nantes', dateCreation: '', dateModification: '')
		Album PhotoLyon = new Album ( name: 'PhotoLyon', description: 'photo du voyage de Lyon', dateCreation: '', dateModification: '')
		Album PhotoCameroun = new Album ( name: 'PhotoCameroun', description: 'photo du voyage de Cameroun', dateCreation: '', dateModification: '')
		
		PhotoParis.save();
		PhotoToulouse.save();
		PhotoNantes.save();
		PhotoCameroun.save();
		PhotoLyon.save();

	}

	def destroy = {
	}
}