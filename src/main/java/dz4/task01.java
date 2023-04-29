package dz4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*1. Реализовать консольное приложение, которое:
        Принимает от пользователя и “запоминает” строки.
        Если введено print, выводит строки так, чтобы последняя введенная была
        первой в списке, а первая - последней.
        Если введено revert, удаляет предыдущую введенную строку из памяти.

 */
public class task01 {
    public static void main(String[] args) {
        ex1();
    }

    private static void ex1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строки. print - развернуть , revert - удалить предыдущую строку, stop -выйти : ");
        Deque<String> deque = new ArrayDeque<>();

        while (true) {
            String input = scanner.nextLine();

            if ("print".equals(input)) {
                for (String s: deque) {
                    System.out.println(s);
                }
            } else if ("revert".equals(input)) {
                deque.removeFirst();
                for (String s: deque) {
                    System.out.println(s);
                }
            } else if ("stop".equals(input)) {
                break;
            } else {
                deque.addFirst(input);
            }
        }
    }
}

