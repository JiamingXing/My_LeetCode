package javafundmental;

import java.util.Arrays;
import java.util.List;

public class Company {
	private final String name;
	
	private final List<Employee> employees;
	
	public Company(String name, Employee ... employees) {
		this.name = name;
		this.employees = Arrays.asList(employees);
	}
	
	public void addEmployee(String name, double salary) {
		Employee employee = new Employee(name, salary);
		this.employees.add(employee);
	}
	
	public String getCompanyName() {
		return this.name;
	}
}
