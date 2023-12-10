package Day5;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io. *;
import java.util.*;
import org.json.*;
import org.testng.annotations.Test;

public class DownloadFile{

	@Test(priority=1)
	void downloadFile() {
	
	given()
	
	.when()
	.get("http://localhost:8080/downloadFile/text1.txt.txt")
	.then()
	.statusCode(200)
	.log().all();
	
	
	}
	
	@Test(priority=2)
	void downloadFile2() {
	
	given()
	
	.when()
	.get("http://localhost:8080/downloadFile/text2.txt.txt")
	.then()
	.statusCode(200)
	.log().all();
	
	
	}
}
