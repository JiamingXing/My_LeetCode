package javafundmental;

public class Employee {
	private static final double DEFAULT_SALARY = 5000;
	private final String name;
	private final double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary + DEFAULT_SALARY;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
//	public void setName(String name) {
//		this.name = name;
//	}
}
