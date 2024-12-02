package Test;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // Метод для генерації масиву з випадкових чисел
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(201) - 100; // Генеруємо в діапазоні [-100;100]
        }
        return array;
    }

    // Метод для обчислення добутку додатних елементів масиву
    public static int productOfPositiveElements(int[] array) throws IllegalArgumentException {
        int product = 1;
        boolean hasPositive = false;
        for (int num : array) {
            if (num > 0) {
                product *= num;
                hasPositive = true;
            }
        }
        if (!hasPositive) {
            throw new IllegalArgumentException("У масиві немає додатних елементів");
        }
        return product;
    }

    // Метод для обчислення суми елементів до останнього додатного елемента
    public static int sumBeforeLastPositive(int[] array) throws IllegalArgumentException {
        int lastPositiveIndex = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > 0) {
                lastPositiveIndex = i;
                break;
            }
        }
        if (lastPositiveIndex == -1) {
            throw new IllegalArgumentException("У масиві немає додатних елементів");
        }
        int sum = 0;
        for (int i = 0; i < lastPositiveIndex; i++) {
            sum += array[i];
        }
        return sum;
    }

    // Головний метод для запуску програми
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        // Цикл, який дозволяє повторювати операції
        while (continueProgram) {
            // Питання користувачу про розмір масиву
            System.out.print("Введіть розмір масиву: ");
            int size = scanner.nextInt();

            // Генерація масиву з введеним розміром
            int[] array = generateRandomArray(size);
            System.out.println("Згенерований масив: " + Arrays.toString(array));

            // Виконання обчислень
            try {
                int product = productOfPositiveElements(array);
                System.out.println("Добуток додатних елементів: " + product);
            } catch (IllegalArgumentException e) {
                System.out.println("Помилка: " + e.getMessage());
            }

            try {
                int sum = sumBeforeLastPositive(array);
                System.out.println("Сума елементів до останнього додатного: " + sum);
            } catch (IllegalArgumentException e) {
                System.out.println("Помилка: " + e.getMessage());
            }

            // Питання, чи хоче користувач повторити
            System.out.print("\nБажаєте виконати ще одну операцію? (так/ні): ");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("ні")) {
                continueProgram = false;
                System.out.println("Дякуємо за використання програми!");
            }
        }

        scanner.close(); // Закриття сканера
    }
}
