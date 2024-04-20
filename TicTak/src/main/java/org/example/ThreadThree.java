package org.example;

public class ThreadThree extends Thread {
    private Monitor monitor = new Monitor();

    ThreadThree(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < TicTak.num; i++) {
                synchronized (monitor) {
                    if (monitor.t3 == false) {
                        System.out.println(3);
                        monitor.t3 = true;
                        monitor.t1 = false;
                    }
                    monitor.notifyAll();
                    while ((i < TicTak.num - 1) & monitor.t3) monitor.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
