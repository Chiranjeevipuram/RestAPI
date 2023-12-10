package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class QuaryPathParam {

//	https://reqres.in/api/users?page=2&id=9
//	https://reqres.in//api/ -> Domain
//	users -> path parameter  //create variable //before ? called as path param
//	page=2&id=9 -> Quary parameter //passing quary para directly using query para
	
//	@Test
	void Paramet() {
	given()
	.pathParam("Mypath", "users")
	.queryParam("page",2)
	.queryParam("id",9)
	
	.when()
	.get("https://reqres.in/api/{Mypath}")
	
	.then()
	.statusCode(200)
	.log()
	.all();
	
	}
	
	@Test
	void CoockiesAp() {
		given()
		.when()
		.get("https://www.google.com/")
.then()
.cookie("AEC","AUEFqZeQEdyroZ_KwGOmG3xMeuP7MgFYsPd11L54fu5SEJTDuPdgoGa1Lw")

.log()
.all();
}
	
}
