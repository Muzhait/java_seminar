package seminar1;
// Вывести все простые числа от 1 до 1000

public class dz2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && i != 1) {
                System.out.println(i + " - простое число");
            }
        }
    }
}
