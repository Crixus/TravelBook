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
				lastName:"fotso",
				firstName: "toto",
				gender: "M",
				password: "toto!");
			
			if (!toto.save()){
				log.error "Could not save user!!"
				log.error "${toto.errors}"
			  }
			
			User jeremy = new User(
				username: "jeremy@gmail.com",
				email: "jeremy@gmail.com",
				dateOfBirth: new Date()-220,
				lastName:"jerem",
				firstName: "jeremy",
				gender: "M",
				password: "jerem!");
			
			if (!jeremy.save()){
				log.error "Could not save user!!"
				log.error "${jeremy.errors}"
			  }
			
			User anna = new User(
				username: "anna@gmail.com",
				email: "anna@gmail.com",
				dateOfBirth: new Date()-240 ,
				lastName:"anna",
				firstName: "anna",
				gender: "F",
				password: "anna!");
			
			if (!anna.save()){
				log.error "Could not save user!!"
				log.error "${anna.errors}"
			}
			
			User adama = new User(
				username: "adama@gmail.com",
				email: "adama@gmail.com",
				dateOfBirth: new Date()-118,
				lastName:"adama",
				firstName: "adama",
				gender: "M",
				password: "adama!");
			
			if (!adama.save()){
				log.error "Could not save user!!"
				log.error "${adama.errors}"
			  }
			
			User Matt = new User(
				username: "Matt@gmail.com",
				email: "Matt@gmail.com",
				dateOfBirth: new Date()-240 ,
				lastName:"Matt",
				firstName: "Matt",
				gender: "M",
				password: "Matt!");
			
			if (!Matt.save()){
				log.error "Could not save user!!"
				log.error "${Matt.errors}"
			}
			
			User Julie = new User(
				username: "Julie@gmail.com",
				email: "Julie@gmail.com",
				dateOfBirth: new Date()-240 ,
				lastName:"Julie",
				firstName: "Julie",
				gender: "F",
				password: "Julie!");
			
			if (!Julie.save()){
				log.error "Could not save user!!"
				log.error "${Julie.errors}"
			}
			
			User Camille = new User(
				username: "Camille@gmail.com",
				email: "Camille@gmail.com",
				dateOfBirth: new Date()-240 ,
				lastName:"Camille",
				firstName: "Camille",
				gender: "F",
				password: "Camille!");
			
			if (!Camille.save()){
				log.error "Could not save user!!"
				log.error "${Camille.errors}"
			}
			
			
		adama.addToFriends(anna)
		adama.addToFriends(jeremy)
		adama.addToFriends(toto)
		adama.addToFriends(Camille)
		adama.addToFriends(Matt)
		adama.addToFriends(Julie)

		anna.addToFriends(toto)	
		
		print adama.friends
		
		//Donn�es gestion voyage
			 
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
		
		//Donn�es gestion Album
		
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