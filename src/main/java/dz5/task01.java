package dz5;

import java.util.HashMap;

/*
1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек
может иметь несколько телефонов.
        Пусть дан список сотрудников:
        Иван Иванов
        Светлана Петрова
        Кристина Белова
        Анна Мусина
        Анна Крутова
        Иван Юрин
        Петр Лыков
        Павел Чернов
        Петр Чернышов
        Мария Федорова
        Марина Светлова
        Мария Савина
        Мария Рыкова
        Марина Лугова
        Анна Владимирова
        Иван Мечников
        Петр Петин
        Иван Ежов
        2. Написать программу, которая найдёт и выведет повторяющиеся имена с
        количеством повторений. Отсортировать по убыванию популярности.
 */
public class task01 {
    public static void main(String[] args) {
        ex01();
    }

    private static void ex01() {
        HashMap<String, String[]> phoneBook = new HashMap<>();
        phoneBook.put("Иван Иванов", new String[]{"123-45-67", "890-12-34"});
        phoneBook.put("Светлана Петрова", new String[]{"345-67-89", "987-65-43"});
        phoneBook.put("Кристина Белова", new String[]{"654-32-10", "321-09-87"});
        phoneBook.put("Анна Мусина", new String[]{"876-54-32", "234-56-78"});
        phoneBook.put("Анна Крутова", new String[]{"789-01-23"});
        phoneBook.put("Иван Юрин", new String[]{"999-99-99"});
        phoneBook.put("Петр Лыков", new String[]{"111-11-11", "222-22-22", "222" +
                "22-23"});
        phoneBook.put("Павел Чернов", new String[]{"333-33-33"});
        phoneBook.put("Петр Чернышов", new String[]{"444-44-44", "555-55-55"});
        phoneBook.put("Мария Федорова", new String[]{"666-66-66", "777-77-77"});
        phoneBook.put("Марина Светлова", new String[]{"888-88-88"});
        phoneBook.put("Мария Савина", new String[]{"123-45-67"});
        phoneBook.put("Мария Рыкова", new String[]{"345-67-89"});
        phoneBook.put("Марина Лугова", new String[]{"444-44-44", "987-65-43"});
        phoneBook.put("Анна Владимирова", new String[]{"999-99-99"});
        phoneBook.put("Иван Мечников", new String[]{"111-11-11"});
        phoneBook.put("Петр Петин", new String[]{"333-33-33", "555-55-55"});
        phoneBook.put("Иван Ежов", new String[]{"777-77-77"});


        HashMap<String, Integer> nameCount = new HashMap<>();
        for (String name : phoneBook.keySet()) {
            String[] phones = phoneBook.get(name);
            if (phones != null) {
                for (String phone : phones) {
                    nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
                }
            }
        }

        nameCount.entrySet().stream()
                .sorted(HashMap.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> {
                    if (entry.getValue() > 1) {
                        System.out.println(entry.getKey() + " - " + entry.getValue() + " numbers");
                    }
                });
    }
}
