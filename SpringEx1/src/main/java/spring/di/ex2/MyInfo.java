package spring.di.ex2;

public class MyInfo {

	String name;
	int age;
	String addr;
	
	private void myinfo(String name, int age, String addr) {
		
		this.name = name;
		this.age = age;
		this.addr = addr;

	}
		
	
	@Override
	public String toString() {
		return "MyInfo [name = "+name+", age = "+age+" , addr = "+addr+"]";
	}
}
