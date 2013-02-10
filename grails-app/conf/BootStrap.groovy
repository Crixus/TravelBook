import java.text.SimpleDateFormat
import java.util.Date;

import travelbook.Album
import travelbook.Travel
import travelbook.User

class BootStrap {

	def init = { servletContext ->
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

		
		User Frank = new User(
			username: "frank@gmail.com",
			email: "frank@gmail.com",
			dateOfBirth: Date.parse("yyyy-M-d", "1975-07-16"),
			lastName:"frank",
			firstName: "fotso",
			gender: "M",
			password: "pass");

	if (!Frank.save()){
		log.error "Could not save user!!"
		log.error "${Marouan.errors}"
	}
	
	User Ludovic = new User(
		username: "ludo@gmail.com",
		email: "ludo@gmail.com",
		dateOfBirth: Date.parse("yyyy-M-d", "1985-02-17"),
		lastName:"ludo",
		firstName: "PtitLu",
		gender: "M",
		password: "pass");

if (!Ludovic.save()){
	log.error "Could not save user!!"
	log.error "${Marouan.errors}"
}
		
		
		
		adama.addToFriends(anna)
		adama.addToFriends(jeremy)
		adama.addToFriends(toto)
		adama.addToFriends(Marouan)
		adama.addToFriends(Ludovic)
		adama.addToFriends(Frank)

		anna.addToFriends(toto)
		anna.addToFriends(jeremy)
		anna.addToFriends(Marouan)
		anna.addToFriends(Ludovic)
		anna.addToFriends(Frank)
		
		Marouan.addToFriends(anna)
		Marouan.addToFriends(jeremy)
		Marouan.addToFriends(Ludovic)
		Marouan.addToFriends(Frank)
		
		Ludovic.addToFriends(anna)
		Ludovic.addToFriends(Marouan)
		Ludovic.addToFriends(Frank)
		
		Frank.addToFriends(anna)
		Frank.addToFriends(Marouan)
		Frank.addToFriends(Ludovic)
		Frank.addToFriends(adama)
		
		
		
		toto.addToFriends(adama)
		toto.addToFriends(anna)
		



		
		

		Travel Paris = new Travel (destination: 'Paris', dateDebut:new Date()-86, dateFin: new Date(), member:adama)
		Travel Toulouse = new Travel (destination: 'Toulouse', dateDebut:new Date()-86, dateFin: new Date(), member:adama)
		Travel Nantes = new Travel (destination: 'Nantes', dateDebut:new Date()-86, dateFin: new Date(), member:anna)
		Travel Lyon = new Travel (destination: 'Lyon', dateDebut:new Date()-86, dateFin: new Date(), member:jeremy)

		Paris.save();
		Toulouse.save();
		Nantes.save();
		Lyon.save();

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