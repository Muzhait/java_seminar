package seminar6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
        public static void main(String[] args) {
        Set<NoteBook> notebooks = new HashSet<>();
        NoteBook notebook1 = new NoteBook("HP", 8, 512, "Windows", "Black");
        NoteBook notebook2 = new NoteBook("Asus", 16, 1024, "MacOS", "Silver");
        NoteBook notebook3 = new NoteBook("Sony", 8, 256, "Linux", "White");
        NoteBook notebook4 = new NoteBook("Заря", 16, 512, "Windows", "Black");
        NoteBook notebook5 = new NoteBook("Космос 12", 8, 512, "Windows", "Silver");
        notebooks.add(notebook1);
        notebooks.add(notebook2);
        notebooks.add(notebook3);
        notebooks.add(notebook4);
        notebooks.add(notebook5);
        Map<String, Object> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Приветствие!");
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Введите минимальное значение ОЗУ:");
                int minRam = scanner.nextInt();
                filters.put("ram", minRam);
                break;
            case 2:
                System.out.println("Введите минимальный объем ЖД:");
                int minStorage = scanner.nextInt();
                filters.put("storage", minStorage);
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                String os = scanner.nextLine();
                filters.put("os", os);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.nextLine();
                filters.put("color", color);
                break;
            default:
                System.out.println("Некорректный выбор.");
                return;
        }
        Set<NoteBook> filteredNotebooks = filterNotebooks(notebooks, filters);
        System.out.println("Подходящие ноутбуки:");
        for (NoteBook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }
    public static Set<NoteBook> filterNotebooks(Set<NoteBook> notebooks, Map<String, Object> filters) {
        Set<NoteBook> filteredNotebooks = new HashSet<>();
        for (NoteBook notebook : notebooks) {
            boolean isMatch = true;
            for (String key : filters.keySet()) {
                if (key.equals("ram")) {
                    int minRam = (int) filters.get(key);
                    if (notebook.getRam() < minRam) {
                        isMatch = false;
                        break;
                    }
                } else if (key.equals("storage")) {
                    int minStorage = (int) filters.get(key);
                    if (notebook.getStorage() < minStorage) {
                        isMatch = false;
                        break;
                    }
                } else if (key.equals("os")) {
                    String os = (String) filters.get(key);
                    if (!notebook.getOs().equals(os)) {
                        isMatch = false;
                        break;
                    }
                } else if (key.equals("color")) {
                    String color = (String) filters.get(key);
                    if (!notebook.getColor().equals(color)) {
                        isMatch = false;
                        break;
                    }
                }
            }
            if (isMatch) {
                filteredNotebooks.add(notebook);
            }
        }
        return filteredNotebooks;
    }
}
