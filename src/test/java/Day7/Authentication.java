package Day7;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentication {

//	@Test
	void Basic() {
			
	given()
	.auth()
	.basic("postman","password")
	.when()
	.get("https://postman-echo.com/basic-auth")
	.then()
	.statusCode(200)
	.body("authenticated",equalTo(true));
	
}
//	@Test(priority=1)
	void DigestAuthentication() {
		given()
		.auth()
		.digest("postman","password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true));
		
	}
	
//	@Test(priority=2)
	void premptiveAuth() {
		given()
		.auth()
		.preemptive()
		.basic("postman","password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true));
		
	}
	
	@Test
	void BearerToken() {
		String bearerToken="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";
		
		given()
		.headers("Authorization","bearerToken")
		.when()
		.get("https://github.com/settings/tokens")
		.then()
		.statusCode(200)
		.header("Server",equalTo("GitHub.com"));
	}
	
	void OAuth1()
	{
		given()
		.auth()
		.oauth("consumerkey","consumersecret","accesstoken","tokensecreat")
		.when()
		.get("url")
		.then();
	}
	
	}
