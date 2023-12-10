package Day5;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


public class ParsingXMLResponse {
	
//	http://restapi.adequateshop.com/api/Traveler?page=6
 
//	approach 1
//	@Test()
	public void ParseXMLBody() {
		
given()
 .contentType(ContentType.JSON)
 .pathParams("mypath","Traveler")
 .queryParams("page",6)
.when()
.get("http://restapi.adequateshop.com/api/{mypath}")
.then()
.statusCode(200)
.body("TravelerinformationResponse.travelers.Travelerinformation[0].email",equalTo("kar111en@mail.ru"))
.body("TravelerinformationResponse.totalrecord", equalTo("16041"))
.body("TravelerinformationResponse.travelers.Travelerinformation[2].name",equalTo("Developer"));
;
	}
	
//	@Test(priority=1)
public void ParseXMLObj() {

	Response res= given()
	 .contentType(ContentType.JSON)
	.when()
	.pathParams("mypath","Traveler")
	.queryParams("page",6)
	.get("http://restapi.adequateshop.com/api/{mypath}");
	
	
	Assert.assertEquals(res.statusCode(), 200);
	Assert.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8");
	
	String ActualAdrs=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[1].adderes").toString();
	Assert.assertEquals(ActualAdrs, "USA");
	
	String ActualPage=res.xmlPath().get("TravelerinformationResponse.page").toString();
	Assert.assertEquals(ActualPage,"ActualPage");
}  
@Test()
	public void ParseXMLobjAsString() {
		
		Response res= given()
				 .contentType(ContentType.JSON)
				.when()
				.pathParams("mypath","Traveler")
				.queryParams("page",6)
				.get("http://restapi.adequateshop.com/api/{mypath}");
		
		XmlPath obj=new XmlPath(res.asString());
		
//	System.out.println(" "+	obj.get("TravelerinformationResponse.travelers.Travelerinformation.name"));
	List<String> Travelernames	=obj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");	
 for(String e:Travelernames) {
	 System.out.println(e);
 }

}

}

