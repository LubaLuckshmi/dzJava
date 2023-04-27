package dz3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*1. Создать список типа ArrayList<String>.
Поместить в него как строки, так и целые числа.
Пройти по списку, найти и удалить целые числа.
        Пример: {"Яблоко", "11", "13", "Апельсин", "Дыня", "17"} -> {"Яблоко", "Апельсин", "Дыня"}
*/
public class task01 {
    public static void main(String[] args) {
        ex01();

    }

    private static void ex01() {
        List<String> list = new ArrayList<>(Arrays.asList("Яблоко", "11", "13", "Апельсин", "Дыня", "17"));
        list.removeIf(s -> s.matches("\\d+"));
        for (String el :
                list) {
            System.out.println(el);
        }
    }
}
