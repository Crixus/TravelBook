package travelbook

class Travel {

	String destination;
	Date dateDebut;
	Date dateFin;

	static belongsTo = [member : User]

	static constraints = {
		destination (blank: false, size: 3..16)
		dateDebut (blank:false)
		dateFin (blank:false, validator:{val, obj -> val?.after(obj.dateDebut)})
	}
	
	def urlMainPicture(){
		def idMember = member.getId()
		
		def main = "t_"+idMember+"_"+this.getId()+"_1"+".jpg"
		def urlMain = "web-app/images/picts/"+ main
		
		print destination + " " + urlMain
		
		def reader = new File(urlMain)
		return (reader.exists()) ? main : "p_default.jpg";
	}
}
