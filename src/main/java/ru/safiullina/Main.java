package ru.safiullina;

public class Main {
    public static void main(String[] args) {

        // Создадим Person со всеми заполненными полями
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(30)
                .setAddress("Сидней")
                .build();
        // Воспользуемся билдером для ребенка, который возвращает полу заполненный объект
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        // Не хватает обязательных полей имени и фамилии, ждем появления исключения
        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            System.out.println("Запись не создана: " + e.getMessage());
        }
        // Возраст недопустимый, ждем исключения
        try {

            new PersonBuilder().setName("Anna").setSurname("Wolf").setAge(-100).build();
        } catch (IllegalArgumentException e) {
            System.out.println("Запись не создана: " + e.getMessage());
        }

        // Мы можем создать объект без возраста
        try {
            Person personWithoutAge = new PersonBuilder()
                    .setName("Anna")
                    .setSurname("Wolf")
                    .build();
            System.out.println("Персона без возраста: " + personWithoutAge);
        } catch (IllegalArgumentException e) {
            System.out.println("Запись не создана: " + e.getMessage());
        }

        // Увеличение возраста
        son.happyBirthday();
        System.out.println("Увеличили возраст сына : " + son);

        // Получение адреса
        if (mom.hasAddress()) {
            System.out.println("Город проживания мамы: " + mom.getCity());
        }

        // Получить возраст, если он известен
        if (mom.hasAge()) {
            System.out.println("Возраст мамы: " + mom.getAge().getAsInt());
        }

        // Изменить город
        mom.setCity("Мельбурн");
        System.out.println("Новый город: " + mom.getCity());

    }

}
