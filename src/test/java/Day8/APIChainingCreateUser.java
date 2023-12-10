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

public class APIChainingCreateUser {

	@Test
	void createuser(ITestContext context) {
	Faker fackdata =new Faker();
	
   JSONObject Jsondata =new JSONObject();
	Jsondata.put("name",fackdata.name().fullName());
	Jsondata.put("email",fackdata.internet().emailAddress());
	Jsondata.put("gender","male");
	Jsondata.put("status","Inactive");
	
	String BearerToken="c1cbb7974687ed202a2378edc918c9c1741d5cab82ae6538e95f0a3f13ed745e";
	
	Response res=
			given()
	.headers("Authorization","Bearer "+BearerToken)
	.contentType("application/json")
	.body(Jsondata.toString())
	.when()
	.post("https://gorest.co.in/public/v2/users");	
	
	int ID = res.jsonPath().getInt("id");
   
	System.out.println(ID);

	context.setAttribute("user_ID",ID);
   
	
	
	}
	
}
