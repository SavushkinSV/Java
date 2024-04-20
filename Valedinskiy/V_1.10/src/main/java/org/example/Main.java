package org.example;

import java.util.Scanner;

/**
 * 1.10. Подсчитайте количество положительных, отрицательных и нулевых чисел
 * последовательности.
 */

public class Main {
    public static void main(String[] args) {
        int positive = 0, negative = 0, zero = 0;
        String s;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите последовательность из 10 чисел");
        for (int i = 0; i < 10; i++) {
            s = scanner.nextLine();
            if (Integer.parseInt(s) >= 0) {
                if (Integer.parseInt(s) > 0) {
                    positive++;
                } else {
                    zero++;
                }
            } else {
                negative++;
            }
        }
        scanner.close();

        System.out.println("В заданной последовательности:");
        System.out.println(positive + " положительных чисел");
        System.out.println(negative + " отрицательных чисел");
        System.out.println(zero + " нулевых чисел");
    }
}