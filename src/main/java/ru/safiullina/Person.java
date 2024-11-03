package ru.safiullina;

import java.util.Objects;
import java.util.OptionalInt;

/**
 * Класс Person, в котором будут храниться данные о человеке
 */
public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String city;

    // Конструкторы
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.city = city;
    }

    public Person(String name, String surname, String city) {
        this.name = name;
        this.surname = surname;
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

    public OptionalInt getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public boolean hasAge() {
        if (age != null && age.isPresent()) {
            return age.getAsInt() >= 0;
        }
        else {
            return false;
        }
    }

    public boolean hasAddress() {
        return !city.isEmpty();
    }

    public void happyBirthday() {
        if (hasAge()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + (!hasAge() ? " 'Возраст не известен'" : age.getAsInt()) +
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

    /**
     * Метод для получения полу заполненного билдера для ребёнка в класс Person
     * */
    public PersonBuilder newChildBuilder() {
        // Создадим объект билдера
        PersonBuilder child = new PersonBuilder();
        // Переносим данные из родителя в ребёнка
        child.surname = this.surname;
        child.age = OptionalInt.of(0);
        child.city = this.city;
        return child;
    }
}
