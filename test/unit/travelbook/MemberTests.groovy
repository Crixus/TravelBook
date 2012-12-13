package travelbook



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Member)
class MemberTests {
	// Codemarc

    void test_instance() {
		String nickname = "ABocoum"
		String email = "abocoum@gmail.com"
		String gender = "Male"
		Date dateOfBirth = new Date().parse("d/M/yyyy", "23/04/1990")
		
		Member test = new Member(nickname, email, gender, dateOfBirth)
		
		// Test on nickname
		if (test.get_nickname() != nickname) {
			fail "The nickname is incorrect : " + nickname + " != " + test.get_nickname();
		}
		
		// Test on email
		if (test.get_email() != email) {
			fail "The email is incorrect : " + email + " != " + test.get_email();
		}
		
		// Test on gender
		if (test.get_gender() != gender) {
			fail "The gender is incorrect : " + gender + " != " + test.get_gender();
		}
		
		// Test on dateOfBirth
		if (test.get_dateOfBirth() != dateOfBirth) {
			fail "The dateOfBirth is incorrect : " + dateOfBirth + " != " + test.get_dateOfBirth();
		}
    }
}
