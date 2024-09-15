package com.altafjava;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
Write a function that takes a list of employees and returns a map where the keys are departments, and the values are lists of employees sorted by
 their age in descending order.
public class Employee {
    String name;
    int age;
    double salary;
    String department;}
List<Employee> employee = Arrays.asList(
                new Employee("Alice", 28, 60000, "HR"),
                new Employee("Bob", 35, 75000, "Engineering"),
                new Employee("Charlie", 32, 90000, "Engineering"),
                new Employee("David", 40, 80000, "HR"),
                new Employee("Eva", 28, 70000, "Finance"),
                new Employee("Frank", 45, 95000, "Finance")
        );
has context menu
*/
public class Demo {


	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("Alice", 28, 60000, "HR"),
				new Employee("Bob", 35, 75000, "Engineering"),
			    new Employee("Charlie", 32, 90000, "Engineering"),
			    new Employee("David", 40, 80000, "HR"),
			    new Employee("Eva", 28, 70000, "Finance"),
			    new Employee("Frank", 45, 95000, "Finance"));
		
			Map<String, List<Employee>> map = employees.stream().sorted((e1,e2)->(e2.age-e1.age)).collect(Collectors.groupingBy(e->e.department));
			System.out.println(map);
		}
//	returns a map where the keys are departments, and the values are lists of employees sorted by their age in descending order
		
	}
class Employee {
	String name;
    int age;
    double salary;
    String department;
    public Employee(String string, int i, int j, String string2) {
    	name=string;
    	age=i;
    	salary=j;
    	department=string2;
	}
	@Override
	public String toString() {
		return "E[name=" + name + ", age=" + age + ", salary=" + salary + ", department=" + department + "]";
	}
    
}