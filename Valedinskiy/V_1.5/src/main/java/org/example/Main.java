package org.example;

/**
 * 1.5 Определите количество чисел в последовательности, которые больше предшествующего числа
 */

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 5, 0, 12, -15, 23, 40, -2, 0, 16, -3};
        int sum =0;
        for (int i = 1; i < array.length; i++) {
            if (array[i]>array[i-1]) sum++;
        }
        System.out.println("Итого чисел больше предыдущего: " + sum);
    }
}