package dz6;

import java.util.*;

/*
Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
        Создать множество ноутбуков.
        Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и
        выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
        Введите цифру, соответствующую необходимому критерию:
        1 - ОЗУ - ram
        2 - Объём ЖД - total storage
        3 - Операционная система - os
        4 - Цвет …
        Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно
        также в Map.
        Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
        Формат сдачи: файл с расширением java или ссылка на гит с подписанными ФИ и номером группы.

 */
public class Main {
    public static void main(String[] args) {
        Notebook notebook = new Notebook("Lenovo g500", 4, 500, "Windows 7 Professional", "black");
        Notebook notebook1 = new Notebook("Apple MacBook Pro 15 Late 2016", 16, 512, "macOS", "grey");
        Notebook notebook2 = new Notebook("Apple MacBook Pro 13 Late 2011", 4, 256, "macOS", "grey");
        Notebook notebook3 = new Notebook("Apple MacBook Pro 13 Late 2011", 4, 256, "macOS", "grey");
        Notebook notebook4 = new Notebook("Xiaomi RedmiBook 14", 8, 512, "Windows 10 Home", "grey");

        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(notebook);
        notebooks.add(notebook1);
        notebooks.add(notebook2);
        notebooks.add(notebook3);
        notebooks.add(notebook4);

        System.out.println(notebooks);

        System.out.println("Доступные критерии поиска: ");
        System.out.println("1 - ram ");
        System.out.println("2 - total storage ");
        System.out.println("3 - os");
        System.out.println("4 - color ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер критерия: ");
        int criterionNum = scanner.nextInt();
        String criterion = "";
        if (criterionNum == 1) {
            criterion = "ram";
        } else if (criterionNum == 2) {
            criterion = "total storage";
        } else if (criterionNum == 3) {
            criterion = "os";
        } else if (criterionNum == 4) {
            criterion = "color";
        } else {
            System.out.println("Введите корректный номер критерия!");
        }

        System.out.println(String.format("Введите минимальное значение для критерия %s: ", criterion));
        int criterionValue = scanner.nextInt();
        Map<String, Object> filter = new HashMap<>();
        filter.put(criterion, criterionValue);

        Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, filter);

        if (filteredNotebooks.isEmpty()) {
            System.out.println("Ноутбуков, удовлетворяющих заданным условиям, не найдено.");
        } else {
            System.out.println("Список ноутбуков, отвечающих критериям поиска: ");
            for (Notebook n : filteredNotebooks) {
                System.out.println(n);
            }
        }
    }
    public static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, Object> filter) {
        Set<Notebook> result = new HashSet<>();

        for (Notebook notebook : notebooks) {
            boolean isMatch = true;

            for (Map.Entry<String, Object> entry : filter.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                if (key.equals("ram")) {
                    if (notebook.ram < (int) value) {
                        isMatch = false;
                    }
                } else if (key.equals("total storage")) {
                    if (notebook.totalStorage < (int) value) {
                        isMatch = false;
                    }
                } else if (key.equals("os")) {
                    if (!notebook.os.equals(value)) {
                        isMatch = false;
                    }
                } else if (key.equals("color")) {
                    if (!notebook.color.equals(value)) {
                        isMatch = false;
                    }
                } else {
                    System.out.println("Критерий не найден.");
                }
            }
            if (isMatch) {
                result.add(notebook);
            }
        }
        return result;
    }
}
