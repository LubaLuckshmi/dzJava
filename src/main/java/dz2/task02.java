package dz2;

/*
  Напишите метод, который определит тип (расширение) файлов из текущей папки
       и выведет в консоль результат вида:
    1 Расширение файла: txt
    2 Расширение файла: pdf
    3 Расширение файла:
    4 Расширение файла: jpg
*/
import java.io.File;

public class task02 {
    public static void main(String[] args) {
        ex5("/Users/admin/Desktop/java project/дз/dz");

    }

    private static void ex5(String pathDir) {
        File dir = new File(pathDir);
        int fileCount = 0;
        for (File item : dir.listFiles()) {
            if (item.isDirectory()) {
                System.out.println(item.getName() + " \t folder");
            } else {
                String fileName = item.getName();
                if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
                    fileCount++;
                    System.out.println(fileCount + " Расширение файла: " + fileName.substring(fileName.lastIndexOf(".") + 1));
                } else {
                    System.out.println(fileCount + " Расширение файла: ");
                }
            }
        }
    }
}
