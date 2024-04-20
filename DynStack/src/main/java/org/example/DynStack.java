package org.example;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class DynStack {
    private int stck[];
    private int tos;

    public DynStack(int size) {
        stck = new int[size];
        tos = -1;
    }

    public void push(int item) {
        if (tos == stck.length - 1) {
            System.out.println("Увеличиваем стек в 2 раза");
            int tmp[] = new int[stck.length * 2];
            for (int i = 0; i < stck.length; i++) {
                tmp[i] = stck[i];
            }
            stck = tmp;
            stck[++tos] = item;
            System.out.println("+ загружено значение: " + item);
        } else {
            stck[++tos] = item;
            System.out.println("+ загружено значение: " + item);
        }
    }

    public int pop() {
        if (tos < 0) {
            System.out.println("Стек не заполнен");
            return 0;
        } else {
            System.out.println("- выгружено значение: " + stck[tos]);
            int item = stck[tos];
            stck[tos--] = 0;
            return item;
        }
    }

    public void printStack() {
        System.out.println("Содержимое стека:");
        for (int i : stck) {
            System.out.println(i + ": " + stck[i]);
        }
    }

    public void peek() {
        System.out.println("Головной элемент: " + stck[tos]);
    }
}
