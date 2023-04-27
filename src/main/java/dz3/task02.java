package dz3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
2. Каталог товаров книжного магазина сохранен в виде двумерного списка
List<ArrayList<String>> так, что на 0й позиции каждого внутреннего списка
содержится название жанра, а на остальных позициях - названия книг.
Напишите метод для заполнения данной структуры(можно через консоль).
        Пример:
        "Классика", "Преступление и наказание", "Война и мир", "Анна Каренина".
        "Научная фантастика", "Солярис", "Ночной дозор", "Братья Стругацкие".
        "Детектив", "Десять негритят".
        "Фантастика", "Хроники Нарнии", "Гарри Поттер и философский камень", "Грозовой перевал".
*/
public class task02 {
    public static void main(String[] args) {
        ex02();
    }

    private static void ex02() {
        Scanner scanner = new Scanner(System.in);

        List<ArrayList<String>> catalog = new ArrayList<>();

        while (true) {
            ArrayList<String> genre = new ArrayList<>();
            System.out.println("Введите название жанра или '-', чтобы закончить:");
            String genreName = scanner.nextLine();
            if (genreName.equals("-")) {
                break;
            }
            genre.add(genreName);

            while (true) {
                System.out.println("Введите название книги или '-', чтобы закончить:");
                String bookName = scanner.nextLine();
                if (bookName.equals("-")) {
                    break;
                }
                genre.add(bookName);
            }

            catalog.add(genre);
        }

        for (ArrayList<String> genre : catalog) {
            System.out.print("\"" + genre.get(0) + "\", ");
            for (int i = 1; i < genre.size() - 1; i++) {
                System.out.print("\"" + genre.get(i) + "\", ");
            }
            System.out.println("\"" + genre.get(genre.size() - 1) + "\".");
        }
    }
}
