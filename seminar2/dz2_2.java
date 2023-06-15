// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
// 1 3 4 2
// 1 3 2 4
// 1 2 3 4

import java.io.FileWriter;
import java.io.IOException;

public class dz2_2 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2};
        int n = arr.length;
        boolean swapped;
        String log = "";

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            log += arrayToString(arr) + "\n";
        } while (swapped);

        System.out.println("Sorted array: " + arrayToString(arr));
        writeLogToFile(log);
    }

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static void writeLogToFile(String log) {
        try {
            FileWriter writer = new FileWriter("log.txt");
            writer.write(log);
            writer.close();
            System.out.println("Log file written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the log file.");
            e.printStackTrace();
        }
    }
}
