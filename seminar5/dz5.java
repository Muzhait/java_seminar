// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

// Пример меню:
// 1) Добавить контакт
// 2) Вывести всех
// 3) Выход

package seminar5;

import java.util.*;

public class dz5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> phoneBook = new HashMap<>();
        while (true) {
            System.out.println("Меню:");
            System.out.println("1) Добавить контакт");
            System.out.println("2) Вывести всех");
            System.out.println("3) Выход");
            System.out.print("Выберите опцию: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                System.out.print("Введите имя контакта: ");
                String name = scanner.nextLine();
                System.out.print("Введите телефон контакта: ");
                String phone = scanner.nextLine();
                Set<String> phones = phoneBook.getOrDefault(name, new HashSet<>());
                phones.add(phone);
                phoneBook.put(name, phones);
                System.out.println("Контакт успешно добавлен!");
            } else if (option == 2) {
                List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
                Collections.sort(sortedEntries, (e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));
                System.out.println("Телефонная книга:");
                for (Map.Entry<String, Set<String>> entry : sortedEntries) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            } else if (option == 3) {
                break;
            } else {
                System.out.println("Некорректная опция. Попробуйте снова.");
            }
        }
    }
}
