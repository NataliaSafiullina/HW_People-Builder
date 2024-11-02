package ru.safiullina;

/**
 * Класс PersonBuilder служит для конструирования объектов класса Person
 */
public class PersonBuilder {

    protected String name;
    protected String surname;
    protected int age;
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
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.city = address;
        return this;
    }

    public Person build() {
        String error = "Запись не создана. ";

        // Построим строку сообщения исключения, если есть ошибки в заполнении объекта
        String stringException = ((name == null) ? " Не задано имя. " : "") +
                ((surname == null) ? " Не задана фамилия. " : "");

        // Если не заданы имя или фамилия, выбросим исключение
        if (!stringException.isEmpty()) {
            throw new IllegalStateException(error + stringException);
        }

        // Проверим корректность возраста
        if (age <= 0) {
            throw new IllegalArgumentException(error + "Возраст отрицательное число или 0");
        }

        // Создаем и возвращаем объект Person
        return new Person(name,
                surname,
                age,
                city);
    }
}
