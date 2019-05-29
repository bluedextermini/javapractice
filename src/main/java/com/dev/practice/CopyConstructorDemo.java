package com.dev.practice;

import org.apache.commons.lang3.SerializationUtils;

import java.io.BufferedReader;

class Address
{
    public String streetAddress, city, country;

    public Address(String streetAddress, String city, String country)
    {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
    }

    public Address(Address other)
    {
        this(other.streetAddress, other.city, other.country);
    }

    @Override
    public String toString()
    {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}


class Employee
{
    public String name;
    public Address address;

    public Employee(String name, Address address)
    {
        this.name = name;
        this.address = address;
    }

    public Employee(Employee other)
    {
        name = other.name;
        address = new Address(other.address);
    }

}

class CopyConstructorDemo
{


    public static void main(String[] args)
    {
        Employee john = new Employee("John",
                new Address("123 London Road", "London", "UK"));

        //Employee chris = john;
        Employee chris = new Employee(john);

        chris.address.city = "Pune";
        System.out.println(john);
        System.out.println(chris);




    }
}


