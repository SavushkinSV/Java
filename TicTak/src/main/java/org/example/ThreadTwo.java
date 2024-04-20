package org.example;

public class ThreadTwo implements Runnable {
    private Thread thread;
    private Monitor monitor;

    public Thread getThread() {
        return thread;
    }

    public ThreadTwo(Monitor monitor) {
        this.monitor = monitor;
        thread = new Thread(this);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
            for (int i = 0; i < TicTak.num; i++) {
                synchronized (monitor) {
                    if (monitor.t2 == false) {
                        System.out.print(2 + " - ");
                        monitor.t2 = true;
                        monitor.t3 = false;
                    }
                    monitor.notifyAll();
                    while ((i < TicTak.num - 1) & monitor.t2) monitor.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
