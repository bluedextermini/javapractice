package com.dev.practice.prototype;

import com.sun.xml.internal.ws.developer.Serialization;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

public class Employee implements Serializable {

    String name;
    Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }


    public Employee(Employee e){
        this.name=e.name;
        this.address=new Address(e.address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

class PrototypeApplication{
    public static void main(String[] args) {
        Employee e1=new Employee("neelesh", new Address("pune", "kharadi"));
        Employee e2= new Employee(e1);
        e2.getAddress().setCity("Raipur");

        Employee e3= SerializationUtils.roundtrip(e1);
        e3.getAddress().setCity("Hyderabad");
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

    }
}
class Address implements Serializable{
    String city, address;

    public Address(Address add) {
        this.city=add.city;
        this.address=add.address;
    }

    public Address(String city, String address) {
        this.city = city;
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
