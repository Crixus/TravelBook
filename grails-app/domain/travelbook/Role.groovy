package travelbook

class Role {

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false
	}
}
