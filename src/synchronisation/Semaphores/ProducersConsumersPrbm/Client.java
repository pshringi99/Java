package synchronisation.Semaphores.ProducersConsumersPrbm;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Client {
    static void main() {
        Queue<Object> store = new ConcurrentLinkedDeque<>();
        Producers p1 = new Producers(store,6,"P1");
        Producers p2 = new Producers(store,6,"P2");
        Producers p3 = new Producers(store,6,"P3");

        Consumers c1 = new Consumers(store,6,"C1");
        Consumers c2 = new Consumers(store,6,"C2");
        Consumers c3 = new Consumers(store,6,"C3");
        Consumers c4 = new Consumers(store,6,"C4");
        Consumers c5 = new Consumers(store,6,"C5");

        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(p2);
        t2.start();
        Thread t3 = new Thread(p3);
        t3.start();

        Thread t4 = new Thread(c1);
        t4.start();
        Thread t5 = new Thread(c2);
        t5.start();
        Thread t6 = new Thread(c3);
        t6.start();
        Thread t7 = new Thread(c4);
        t7.start();
        Thread t8 = new Thread(c5);
        t8.start();

    }
}
