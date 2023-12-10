package Day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class getHeaders {

	@Test
	void getheader() {
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.header("Content-Type","text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding","gzip");
	}
	
	@Test
	void GetHeaders() {
		Response ResponseBody=given()
		.when()
		.get("https://www.google.com/");
		
	    String ContentHead=ResponseBody.getHeader("Content-Type");  
		System.out.println(ContentHead); //getting header with passing header value
		
		Headers myheader=ResponseBody.getHeaders();

		for(Header hd:myheader) {
			System.out.println(hd.getName()+"   "+hd.getValue());
		}
		
	}
	
	
}
