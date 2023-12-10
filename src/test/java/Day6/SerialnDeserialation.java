package Day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerialnDeserialation {

//	POJO  --> JSON Serialization

	@Test
	void ConvertPojoToJSON() throws JsonProcessingException {
		
		Student StuPojo=new Student();
		StuPojo.setname("john");
		StuPojo.setLocation("Pune");
		StuPojo.setClasss("Gratuation");
		
		String course[]= {"c","c1"};
        StuPojo.setCourse(course);
        
        //Convert java object into JSON object
        ObjectMapper Mobj=new ObjectMapper();
        
String StuJSON= Mobj.writerWithDefaultPrettyPrinter().writeValueAsString(Mobj);

    System.out.println(StuJSON);
		
	}
	
	//JSON --> POJO
	@Test
	void ConvertJONtoPOJO() throws JsonMappingException, JsonProcessingException 
	{
		String data="{\r\n"
				+ "\"name\":\"india\",\r\n"
				+ "\"phone\":\"12345678\",\r\n"
				+ "\"courses\":[\r\n"
				+ "\"java\",\r\n"
				+ "\"selenium\"\r\n"
				+ "]\r\n"
				+ "}";


		ObjectMapper objM=new ObjectMapper();
		
		Student StuPOJO=objM.readValue(data,Student.class);
		
		System.out.println("Name"+StuPOJO.getname());
		System.out.println("Location "+StuPOJO.getLocation());
		System.out.println("Class"+StuPOJO.getClasss());
		System.out.println("Course1"+StuPOJO.getCourse()[0]);
		System.out.println("Course2"+StuPOJO.getCourse()[1]);
		
		
		
	}
	
	
	
}
