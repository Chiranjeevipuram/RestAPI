package Day2;

public class Pojoclass {
	String name;
	String Classs;
	String Location;
	String course[]= {"c","python"};
	
	
	public String getname(){
		return name;
	}
	public void setname(String name1){
		this.name=name1;
	}

	public String getClasss() {
		return Classs;
	}

	public void setClasss(String class1) {
		this.Classs = class1;
	}
	
	public String getLocation() {
		return Location;
	}
	
	public void setLocation(String location) {
		Location = location;
	}
	
	public String[] getCourse() {
		return course;
	}
	
	public void setCourse(String[] course) {
		this.course = course;
	}
	
	
	
}
