package org.example;

import java.util.Arrays;

/**
 * 1.38. Пеереставьте элементы массива в обратном порядке
 */

public class Main {

    static int[] array = new int[]{1, 6, 9, -2, 15, 0, 168, -9, 12};

    public static void main(String[] args) {
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(array));
        reverseArray(array);

        System.out.println("Перевернутый массив:");
        System.out.println(Arrays.toString(array));
    }

    //Метод для перестановки элемента массива в обратном порядке
    private static void reverseArray(int[] array) {
        int tmp;
        for (int i = 0; i < array.length / 2; i++) {
            tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
    }
}