package org.example;

public class ThreadOne extends Thread {
    private Monitor monitor = new Monitor();

    ThreadOne(Monitor monitor) {
        this.monitor = monitor;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < TicTak.num; i++) {
                synchronized (monitor) {
                    if (monitor.t1 == false) {
                        System.out.print(1 + " - ");
                        monitor.t1 = true;
                        monitor.t2 = false;
                    }
                    monitor.notifyAll();
                    while ((i < TicTak.num - 1) & monitor.t1) monitor.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
