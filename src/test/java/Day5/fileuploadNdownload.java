package Day5;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io. *;
import java.util.*;
import org.json.*;
import org.testng.annotations.Test;

public class fileuploadNdownload {

	@Test()
	void singlefileupload() {
		
		// Scenario: requesting api post using form-data type 
		
		File myfile =new File("C:\\Users\\smc\\Desktop\\Pavan Automation\\text1.txt.txt");
		
		given()
		.multiPart("file",myfile)
		.contentType("multipart/form-data")
		.when()
		.post("http://localhost:8080/uploadFile")
		.then()
		.statusCode(200)
		.body("fileName", equalTo("text1.txt.txt"))
		.log().all();
	}
	
	@Test()
	void multifileupload() {
		File myfile1=new File("C:\\\\Users\\\\smc\\\\Desktop\\\\Pavan Automation\\\\text1.txt.txt");
		File myfile2=new File("C:\\\\Users\\\\smc\\\\Desktop\\\\Pavan Automation\\\\text2.txt.txt");
	
		given()
		.multiPart("files",myfile1)
		.multiPart("files",myfile2)
		.contentType("multipart/form-data")
		.when()
		.post("http://localhost:8080/uploadMultipleFiles")
		.then()
		.statusCode(200)
//		.body("fileName", equalTo("text1.txt"))
		.body("[0].fileName",equalTo("text1.txt.txt"))
		.body("[1].fileType",equalTo("application/octet-stream"))
		.log().all();
	}
	
//	Approach:1
	
	@Test()
	void multifileuploadArray() //Approach will not work for all api request
	{
		File myfile1=new File("C:\\\\Users\\\\smc\\\\Desktop\\\\Pavan Automation\\\\text1.txt.txt");
		File myfile2=new File("C:\\\\Users\\\\smc\\\\Desktop\\\\Pavan Automation\\\\text2.txt.txt");
	 
		File filearray[]= {myfile1,myfile2};

		given()
		.multiPart("files",filearray)
		.contentType("multipart/form-data")
		.when()
		.post("http://localhost:8080/uploadMultipleFiles")
		.then()
		.statusCode(200)
//		.body("fileName", equalTo("text1.txt"))
	
		.log().all();
	}
	
}
