package ru.safiullina;

import java.util.OptionalInt;

/**
 * Класс PersonBuilder служит для конструирования объектов класса Person
 */
public class PersonBuilder {

    protected String name;
    protected String surname;
    protected OptionalInt age;
    protected String city;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.city = address;
        return this;
    }

    public Person build() throws IllegalArgumentException, IllegalStateException {

        // Построим строку сообщения исключения, если есть ошибки в заполнении объекта
        String stringException = ((name == null) ? " Не задано имя. " : "") +
                ((surname == null) ? " Не задана фамилия. " : "");

        // Если не заданы имя или фамилия, выбросим исключение
        if (!stringException.isEmpty()) {
            throw new IllegalStateException(stringException);
        }

        // Проверим корректность возраста
        if (age != null && age.isPresent() && age.getAsInt()< 0) {
            throw new IllegalArgumentException(" Возраст отрицательное число ");
        }

        // Создаем и возвращаем объект Person
        if (age != null && age.isPresent()) {
            return new Person(name,
                    surname,
                    age.getAsInt(),
                    city);
        }
        else {
            return new Person(name,
                    surname,
                    city);
        }

    }
}
