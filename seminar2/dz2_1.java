// Дана строка sql-запроса "select * from students WHERE ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Пример данной строки {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class dz2_1 {
    public static void main(String[] args) {
        String sql = "select * from students WHERE ";
        String json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        Map<String, String> filters = new HashMap<>();
        json = json.replaceAll("\\{|\\}", "");
        String[] pairs = json.split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            filters.put(keyValue[0].replaceAll("\"", ""), keyValue[1].replaceAll("\"", ""));
        }

        StringBuilder whereClause = new StringBuilder();
        for (Map.Entry<String, String> entry : filters.entrySet()) {
            if (!entry.getValue().equals("null")) {
                whereClause.append(entry.getKey()).append("=").append(entry.getValue()).append(" AND ");
            }
        }
        whereClause.delete(whereClause.length() - 5, whereClause.length()); 

        System.out.println(sql + whereClause);
    }
}
