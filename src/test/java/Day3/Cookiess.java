package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookiess {
//    @Test
	void ResCookie() {
	
// Response var=given()
	given()
	.when()
	.get("https://www.google.com/")
	.then()
	.statusCode(200)
	.cookie("AEC","AUEFqZeQEdyroZ_KwGOmG3xMeuP7MgFYsPd11L54fu5SEJTDuPdgoGa1Lw"); // Cookie value gets changes constantly for every req.  
	}
    
	@Test
    void CaptureSingleCookiess() {
    Response var=given()
    	.when()
    	.get("https://www.google.com/");
    
   String cookie1= var.cookie("1P_JAR"); //return cookie values with cookie name( 1p_JAR)
   String cookie2=var.cookie("NID");
   System.out.println(cookie1);
   System.out.println(cookie2);
    }
    
	@Test
	void CaputureResCookies() {
		
		Response ResponseBody=given()
		.when()
		.get("https://www.google.com/");
		
		Map<String,String> cookiesinfo=ResponseBody.getCookies();  //return cookies info (key n value in map collection)
		
		for(String e:cookiesinfo.keySet()) {                      // cookiesinfo.keySet() return cookies key list
			System.out.println(e+"  "+ResponseBody.cookie(e));    // ResponseBody.cookie(e) return cookie key values
		  // OR   System.out.println(cookiesinfo.get(e));         // cookiesinfo.get(e) java method used to get values using key
		}
	}
	
	
	
}
