package ru.safiullina;

public class Main {
    public static void main(String[] args) {

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        System.out.println("У " + mom + " есть сын, " + son);

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setName("Anna").setSurname("Wolf").setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setName("Anna").setSurname("Wolf").build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        son.happyBirthday();
        System.out.println(son);

        if(mom.hasAddress()){
            System.out.println(mom.getCity());
        }

        if(mom.hasAge()){
            System.out.println(mom.getAge());
        }

    }

}
