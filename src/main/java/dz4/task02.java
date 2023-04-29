package dz4;

import java.util.LinkedList;
import java.util.Random;

/*2. Пусть дан LinkedList с несколькими элементами.
Реализуйте метод, который вернет “перевернутый” список.*/
public class task02 {
    public static void main(String[] args) {
        ex2();
    }

    private static void ex2() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            linkedList.add(random.nextInt(0,20));
        }
        System.out.println(linkedList);

        LinkedList<Integer> reverseList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            int el = linkedList.removeLast();
            reverseList.add(el);
        }
        System.out.println(reverseList);
    }
}
