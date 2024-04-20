package org.example;

/**
 * 1.37. Определите симметричны ли элементы массива
 */

public class Main {
    static boolean s;
    static int[] m1 = new int[]{5, 3, -2, -2, 3, 5};
    static int[] m2 = new int[]{0, 3, -2, 4, 2, -3, 5};

    public static void main(String[] args) {
        symmetricalArray(m1);
        symmetricalArray(m2);
    }

    //метод для определения симметричности
    static void symmetricalArray(int[] m) {
        s = false;
        for (int i = 0; i < m.length - 1; i++) {
            if (m[i] != m[m.length - i - 1]) {
                System.out.println("Массив не симметричен");
                break;
            }
            s = true;
        }
        if (s) {
            System.out.println("Массив симметричен");
        }
    }
}