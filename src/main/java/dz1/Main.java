package dz1;

import java.util.Scanner;
import java.util.Random;
import java.util.Calendar;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        ex1();
//        ex2();
        //ex3();
        // ex4();
        ex5();
    }

    //1. Написать метод, принимающий на вход два аргумента:
//    len и initialValue, и возвращающий одномерный массив типа int длиной
//        len, каждая ячейка которого равна initialValue;
    private static void ex1() {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("len = ");
        int len = Integer.parseInt(iScanner.nextLine());
        System.out.printf("initialValue = ");
        int initialValue = Integer.parseInt(iScanner.nextLine());
        int[] arr = new int[len];
        for (int i : arr) {
            i = initialValue;
            System.out.print(i + " ");
        }
    }

    //2. Задать одномерный массив и найти
//    в нем минимальный и максимальный элементы ;
    private static void ex2() {
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = random.nextInt(1, 20);
        }
        int maxValueIndex = 0;
        int minValueIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[maxValueIndex] < arr[i]) {
                maxValueIndex = i;
            } else if (arr[minValueIndex] > arr[i]) {
                minValueIndex = i;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.printf("Max = %d, Min = %d", arr[maxValueIndex], arr[minValueIndex]);
    }

    /*3. Создать квадратный двумерный целочисленный массив
     (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
     заполнить его диагональные элементы единицами (можно только одну
     из диагоналей, если обе сложно). Определить элементы одной из
     диагоналей можно по следующему принципу: индексы таких элементов
     равны, то есть [0][0], [1][1], [2][2], …, [n][n];
    */
    private static void ex3() {
        int[] matrix[] = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0, x = matrix[i].length - 1; j < matrix[i].length; j++, x--) {
                if (i == j || i == x) {
                    System.out.printf(" %d ", matrix[i][j] = 1);
                } else {
                    System.out.printf(" 0 ");
                }
            }
            System.out.println();
        }
    }
    /*4. В консоли запросить имя пользователя. В зависимости от текущего времени,
    вывести приветствие вида:
            "Доброе утро, <Имя>!", если время от 05:00 до 11:59
            "Добрый день, <Имя>!", если время от 12:00 до 17:59;
"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
"Доброй ночи, <Имя>!", если время от 23:00 до 4:59*/

    private static void ex4() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Введите Ваше имя: ");
        String name = myScanner.nextLine();
        if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= 5
                && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 12) {
            System.out.println("Доброе утро, " + name + "!");
        } else if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= 12
                && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 18) {
            System.out.println("Добрый день, " + name + "!");
        } else if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= 18
                && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 23) {
            System.out.println("Добрый вечер, " + name + "!");
        } else if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= 23
                && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 5) {
            System.out.println("Доброй ночи, " + name + "!");
        }

    }

    /*  5.** Написать метод, которому на вход подается одномерный массив и число n
    (может быть положительным, или отрицательным), при этом метод должен сместить
    все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения
    задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при
    n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) ->
     [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.*/
    private static void ex5() {
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = random.nextInt(1, 20);
        }
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("n = ");
        int n = Integer.parseInt(iScanner.nextLine());
        for (int i : arr) {
            System.out.print(i + " ");
        }
        int temp;
        int len = arr.length - 1;
        if (n < 0) {
            for (int i = 0; i < -n; i++) {
                temp = arr[0];
                System.arraycopy(arr, 1, arr, 0, len);
                arr[len] = temp;
            }
        } else {
            for (int i = 0; i < n; i++) {
                temp = arr[len];
                System.arraycopy(arr, 0, arr, 1, len);
                arr[0] = temp;
            }
        }
        System.out.println("\n" + "Массив после сдвига: " + Arrays.toString(arr));
    }
}
