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

public class APIChainUpdateUser {

	@Test
	void uodateuser(ITestContext context) {
		String BearerToken="c1cbb7974687ed202a2378edc918c9c1741d5cab82ae6538e95f0a3f13ed745e";
		int id=(Integer) context.getAttribute("user_ID");
		Faker fackdata=new Faker();
		
		JSONObject obj=new JSONObject();
		
		obj.put("name",fackdata.name().fullName());
		obj.put("email",fackdata.internet().emailAddress());
		obj.put("status","active");
		
		given()
		.contentType("application/json")
		.headers("Authorization", "Bearer "+BearerToken)
		.pathParams("id",id)
		.body(obj.toString())
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(201)
		.log()
		.all();
	}
}
