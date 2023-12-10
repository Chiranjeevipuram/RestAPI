package Day6;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class JSONSchemaValidator {

	@Test
	void jsonschemavalidation() {
		
		given()
		.when()
		.get("http://localhost:3000/students")
		.then()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("StudentJSONSchema.json"))
		;
		
		
	}
	
}
