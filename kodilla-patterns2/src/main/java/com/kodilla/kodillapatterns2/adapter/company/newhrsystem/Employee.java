package com.kodilla.kodillapatterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;

public class Employee {
    final private String pseslId;
    final private String firstName;
    final private String lastName;
    final private BigDecimal baseSalary;

    public Employee(String pseslId, String firstName, String lastName, BigDecimal baseSalary) {
        this.pseslId = pseslId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.baseSalary = baseSalary;
    }

    public String getPseslId() {
        return pseslId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (getPseslId() != null ? !getPseslId().equals(employee.getPseslId()) : employee.getPseslId() != null)
            return false;
        if (getFirstName() != null ? !getFirstName().equals(employee.getFirstName()) : employee.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(employee.getLastName()) : employee.getLastName() != null)
            return false;
        return getBaseSalary() != null ? getBaseSalary().equals(employee.getBaseSalary()) : employee.getBaseSalary() == null;
    }

    @Override
    public int hashCode() {
        return getPseslId() != null ? getPseslId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "pseslId='" + pseslId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }
}
