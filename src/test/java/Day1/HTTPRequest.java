package Day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequest {
 String id;
	@Test(priority=1)
	public void getusers() {
		
		when()
		.get("https://reqres.in/api/users?page=2")
	   
		.then()
		.statusCode(200)
		.log().all();
	}
	
 
	@Test(priority=2, dependsOnMethods= {"getusers"} )
	void CreateUser() {
		HashMap data=new HashMap();
		data.put("name", "morpheus");
		data.put("job", "leader");
		
	id=	given()
		.contentType("application/json")
		.body(data)		
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getString("id");		
		
	}
	
	@Test(priority=3, dependsOnMethods= {"CreateUser"})
	void Updateuser() {
		HashMap data=new HashMap();
		data.put("name", "morpheus");
		data.put("job","Teamlead");
		
		 given()
		 .contentType("application/json")
		.body(data)
		
		.when()
		.put("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Test(priority=4,dependsOnMethods= {"Updateuser"})
	
	void RemoveUser() {
	 when()
	 .delete("https://reqres.in/api/users/"+id)
	 .then()
	 .statusCode(204)
	 .log().all();
		
	}
	
	
}
