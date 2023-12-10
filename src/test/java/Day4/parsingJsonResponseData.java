package Day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
public class parsingJsonResponseData {
    @Test
	void captureResponse() {
    	
    // Approach -1
    	/* 	given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/books")
		.then()
		.statusCode(200)
		.header("Content-Type","application/json; charset=utf-8")
		.body("[1].title",equalTo("Sword of honor"));*/
    	
    	// Approach-2 - for single(or)Double responSe data preferred
    	
  /*	Response Responsedata =	given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/books");
		
		Assert.assertEquals(Responsedata.statusCode(),200);
		Assert.assertEquals(Responsedata.contentType(),"application/json; charset=utf-8");
		
		String RESTitle1 = Responsedata.jsonPath().get("[1].title").toString();
		System.out.println("Title of Response--"+RESTitle1);
		
	    Assert.assertEquals(RESTitle1,"Sword of honor"); */
    	
    // Approach-3 - for Validate multiple response data PRefered 
    	Boolean Bflag=false;
    	Response Responsedata =	given()
    			.contentType(ContentType.JSON)
    			.when()
    			.get("http://localhost:3000/store");
    	
    	/*
    		JSONObject jo=new JSONObject(Responsedata);
    	
    	 	for(int i=0;i<jo.getJSONArray("books").length();i++) {
    	String ReponseTitle=jo.getJSONArray("books").getJSONObject(i).get("title").toString();
//    	System.out.println(ReponseTitle);
    	
    	if(ReponseTitle.equals("Sword of honor")) {
    		Bflag=true;
    		break;
    	}
    	
    Assert.assertEquals(Bflag,"true"); 
    	
    	
    	}
*/    	
    	int TotalPrice=0;
    	JSONObject JO=new JSONObject(Responsedata);
    	for(int i=0;i<JO.getJSONArray("Books").length();i++) {
    	String JoS=JO.getJSONArray("Books").getJSONObject(i).get("price").toString();
       int Price = Integer.parseInt(JoS);
       TotalPrice=TotalPrice+Price;
       System.out.println();
       
    	}
	}
	
	
}
