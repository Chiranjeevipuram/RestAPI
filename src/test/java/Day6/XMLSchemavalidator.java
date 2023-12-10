package Day6;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class XMLSchemavalidator {

@Test
void Xmlschemavalidation() {
	given()
	.when()
	.get("http://restapi.adequateshop.com/api/Traveler?page=1")
	.then()
	.body(RestAssuredMatchers.matchesXsdInClasspath("xmlschema.xsd"));
}
	
}
