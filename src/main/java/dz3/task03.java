package dz3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/*3. Доделать задание 2.2 участникам семинара -
Пройти по списку из предыдущего задания и удалить повторяющиеся элементы.
 */
public class task03 {
    public static void main(String[] args) {
        ex2();

    }

    private static void ex2() {
        String[] planetsNamesStringArray = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Neptune", "Uranus", "Pluto"};
        List<String> randomSolarSystem = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            randomSolarSystem.add(planetsNamesStringArray[random.nextInt(planetsNamesStringArray.length)]);
        }
        randomSolarSystem.sort(Comparator.naturalOrder());
        System.out.println(randomSolarSystem);

        for (int i = 0; i < randomSolarSystem.size() - 1; i++) {
            if (randomSolarSystem.get(i) == randomSolarSystem.get(i+1)) {
                randomSolarSystem.remove(i);
                i--;
            }

        }
        System.out.println(randomSolarSystem);
    }
}
