package Day2;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io. *;
import java.util.*;
import org.json.*;

import org.json.JSONObject;
import org.testng.annotations.Test;
import org.json.JSONException;


public class DifferentWaysToRequestBody {
//HashMap
//POJO
//org.json	
//External json file
	
	
//	@Test(priority=1)
void CreateUser() {
	
	HashMap data= new HashMap();
	data.put("name","Harshith");
	data.put("Class","6th");
	data.put("Location","USA");
	
	String coursearyy[]= {"maths","Hindhi"};
	data.put("courses",coursearyy);
	
	given()
	.contentType("application/json")
	.body(data)
	
	.when()
	.post("http://localhost:3000/Students")
	
	
	.then()
	.body("name",startsWith("Harshith"))
	.body("Class",equalTo("6th"))
	.body("Location",equalTo("USA"))
	.body("courses[0]",equalTo("maths"))
	.body("courses[1]",equalTo("Hindhi"))
	.header("Content-Type","application/json; charset=utf-8")
	.log().all();
	
	}
	

	
//	@Test()
	void RequestPayloadUsingOrgjson()
	{		
		JSONObject data=new JSONObject();
		data.put("name","John");
		data.put("Class", "5th");
		data.put("Location","UK");
		
		String course[]= {"c","c#"};
		data.put("courses",course);
		
		 given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/Students")
		.then()
//		.statusCode(200)
		.body("name",startsWith("John"))
		.body("Class",equalTo("5th"))
		.body("Location",equalTo("UK"))
		.body("courses[0]",equalTo("c"))
		.body("courses[1]",equalTo("c#"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
		 
	}
	
//	@Test
	void RequestPayloadUsingPOJOclass() {
		Pojoclass data=new Pojoclass();
		data.setname("john");
		data.setClasss("");
		data.setLocation("HYD");
		String course[]= {"c","cypress"};
		
		data.setCourse(course);
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("http://localhost:3000/Students")
		.then()
		.statusCode(201)
		.body("name",startsWith("john"))
		.body("Class",equalTo(null))
		.body("Location",equalTo("HYD"))
		.body("courses[0]",equalTo("c"))
		.body("courses[1]",equalTo("cypress"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
	}
	
	@Test
	void RequestPayloadUsingExternalJsonFile() throws FileNotFoundException
	{
		
		// Automating of json file stored in file external by passing file path
		
		File f=new File(".\\body.json");
		
		FileReader fr=new FileReader(f);
		
		JSONTokener ftk=new JSONTokener(fr);
		
		JSONObject data=new JSONObject(ftk);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/Students")
		.then()
		.statusCode(201)
		.body("name",equalTo("Pranaya"))
		.body("Class",equalTo("Inter"))
		.body("Location",equalTo("USA"))
		.body("courses[0]",equalTo("DigitalMarketing"))
		.body("courses[1]",equalTo("Java"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
	}
		
	
//@Test(priority=2)
	
	void Deleteuser2() {
		given()
		.when()
		.delete("http://localhost:3000/Students/11")
		.then()
		.statusCode(200);
	}
}
