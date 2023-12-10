package Day8;

import com.github.javafaker.*;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class APIChainingGETUser {

	@Test
	void getuser(ITestContext context) {
		
		String BearerToken="c1cbb7974687ed202a2378edc918c9c1741d5cab82ae6538e95f0a3f13ed745e";
		
		int id=(Integer) context.getAttribute("user_ID");
		
		given()
		.contentType("application/json")
		.headers("Authorization","Bearer "+BearerToken)
		.pathParams("id",id)
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.log().all();
	}
}
