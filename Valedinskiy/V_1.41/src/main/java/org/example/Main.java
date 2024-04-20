package org.example;

import java.util.Arrays;

/**
 * 1.41. Каждый элемент массива (кроме первого и последнего заменить на полусумму
 * соседних элементов
 */

public class Main {

    static double[] array = new double[]{1, 6, 9, -2, 15, 0, 168, -9};

    public static void main(String[] args) {
        System.out.println("Исходный массив: " + Arrays.toString(array));
        halfSum(array);
        System.out.println("Переделанный массив: " + Arrays.toString(array));
    }

    private static void halfSum(double[] array) {
        double[] tmp = new double[array.length - 2];
        for (int i = 0; i < array.length - 2; i++) {
            tmp[i] = (array[i] + array[i + 2]) / 2;
        }
        for (int i = 0; i < array.length - 2; i++) {
            array[i + 1] = tmp[i];
        }
    }
}