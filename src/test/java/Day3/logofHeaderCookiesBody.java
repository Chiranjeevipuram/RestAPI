package Day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class logofHeaderCookiesBody {

	@Test
	void logging() {
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.log().body();   //capture and print  response body
//	    .log().cookies();  //capture and print cookies
//		.log().headers();  //capture headers
	
	}
}
