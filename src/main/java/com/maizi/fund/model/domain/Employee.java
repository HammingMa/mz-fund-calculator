package com.maizi.fund.model.domain;


import java.util.Objects;

/**
 * @author cs
 * @version 1.0
 * @date 2019/10/11 11:02 上午
 */
public class Employee {
    private String firstName;

    private String lastName;

    private Integer age;

    private String sex;

    private Float income;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Float getIncome() {
        return income;
    }

    public void setIncome(Float income) {
        this.income = income;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(age, employee.age) &&
                Objects.equals(sex, employee.sex) &&
                Objects.equals(income, employee.income);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, sex, income);
    }


    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", income=" + income +
                '}';
    }
}