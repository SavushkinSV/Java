package org.example;

public class TicTak {
    static int num = 20;

    public static void main(String[] args) {

        Monitor mon = new Monitor();

        mon.t1 = false;
        mon.t2 = true;
        mon.t3 = true;

        ThreadOne thr1 = new ThreadOne(mon);
        ThreadTwo thr2 = new ThreadTwo(mon);
        ThreadThree thr3 = new ThreadThree(mon);

        thr1.start();
        thr2.getThread().start();
        thr3.start();

        try {
            thr1.join();
            thr2.getThread().join();
            thr3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Monitor {
    boolean t1;
    boolean t2;
    boolean t3;
}