package org.example;

public class DynamicStack {
    public static void main(String[] args) {
        DynStack stack = new DynStack(1);
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        stack.printStack();
        for (int i = 0; i < 5; i++)
            stack.pop();
        System.out.println("---");
        stack.peek();
        System.out.println("---");
        stack.printStack();
    }
}