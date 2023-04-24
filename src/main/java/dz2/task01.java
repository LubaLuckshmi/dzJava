package dz2;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*1. Дана строка sql-запроса "select * from students where ".
Сформируйте часть WHERE этого запроса, используя StringBuilder.
Данные для фильтрации приведены ниже в виде json-строки.
        Если значение null, то параметр не должен попадать в запрос.
        Пример 1:
        Параметры для фильтрации: {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"}
        Результат: SELECT * FROM USER WHERE name = 'Ivanov' and country = 'Russia' and city = 'Moscow';
        Пример 2:
        Параметры для фильтрации: {"name:null", "country:null", "city:null", "age:null"}
        Результат: SELECT * FROM USER;
 */


public class task01 {
    public static void main(String[] args) {
        String queryParamsJson = "\"name:Ivanov\", \"country:Russia\", \"city:null\", \"age:null\"";
        String[] queryParams = queryParamsJson.split(",");
        System.out.println(Arrays.toString(queryParams));

        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM USER WHERE ");
        for (int i = 0; i < queryParams.length; i++) {
            String value = queryParams[i];
            String[] pair = value.split(":");
            if (!pair[1].equals("null")) {
                queryBuilder.append(pair[0]).append("='").append(pair[1]).append("'");
                if (i != queryParams.length - 1) {
                    queryBuilder.append(" and ");
                }
            }
        }
        System.out.println(queryBuilder.toString());
    }
}