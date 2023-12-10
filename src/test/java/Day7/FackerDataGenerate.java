package Day7;

import com.github.javafaker.*;

public class FackerDataGenerate {
	Faker faker = new Faker();

	String name = faker.name().fullName(); // Miss Samanta Schmidt
	String firstName = faker.name().firstName(); // Emory
	String lastName = faker.name().lastName(); // Barton

	String streetAddress = faker.address().streetAddress(); 
}
