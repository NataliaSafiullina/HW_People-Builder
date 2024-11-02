package ru.safiullina;

import java.util.Objects;
import java.util.OptionalInt;

/**
 * Класс Person, в котором будут храниться данные о человеке
 */
public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String city;

    // Конструкторы
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    // Setters
    public void setCity(String city) {
        this.city = city;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        return !city.isEmpty();
    }

    public void setAddress(String address) {
        city = address;
    }

    public void happyBirthday() {
        age += 1;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName()) && Objects.equals(getSurname(), person.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname());
    }

    // Метод для получения полу заполненного билдера для ребёнка в класс Person
    public PersonBuilder newChildBuilder() {
        // Создадим объект билдера
        PersonBuilder child = new PersonBuilder();
        // Переносим данные из родителя в ребёнка
        child.surname = this.surname;
        child.age = 1;
        child.city = this.city;
        return child;
    }
}
