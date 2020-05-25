package com.stream.parallel;
import java.io.Serializable;
import java.math.BigDecimal;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private BigDecimal salary;

   public Employee() {
	   
   }

public Employee(String generateRandomName, int generateRandomAge, BigDecimal generateRandomSalary) {
	name = generateRandomName;
	age = generateRandomAge;
	salary = generateRandomSalary;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public BigDecimal getSalary() {
	return salary;
}

public void setSalary(BigDecimal salary) {
	this.salary = salary;
}
   

}
