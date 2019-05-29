package com.dev.practice.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee{

    int salary;
    String name;
    String dept;

    public Employee( String name, int salary) {
        this.salary = salary;
        this.name = name;
    }

    public Employee(String name,int salary,  String dept) {
        this.salary = salary;
        this.name = name;
        this.dept = dept;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }
}

public class StreamDemo {

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee("neelesh", 1000, "hsl"),
                new Employee("atmik", 20,"pcms"),
                new Employee("chetan", 1,"irish"),
                new Employee("saket", 23,"pcms"),
                new Employee("shashank", 245,"hsl"),
                new Employee("tiger", 567, "irish")
                );

/*
        Map<String, Employee> finalEmpMap= employeeList.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .filter(e-> e.getName().startsWith("s"))
                .collect(Collectors.toMap(e->e.getName(), e->e));
*/


        String str=employeeList.stream().map(e-> e.getName()).collect(Collectors.joining(","));

        System.out.println(str);

        Map<String, List<Employee>> employeeMap= employeeList.stream().parallel().
                collect(Collectors.groupingBy(e-> e.getDept()));
        //finalEmpMap.forEach((k,v)->System.out.print(k+"::"+v));
        employeeMap.forEach((k,v)-> System.out.println(k+"::::"+v));

    }
}
