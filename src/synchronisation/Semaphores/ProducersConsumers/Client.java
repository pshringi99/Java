package synchronisation.Semaphores.ProducersConsumers;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class Client {
    static void main(String[] args) throws InterruptedException {
        Queue<Object> store = new ConcurrentLinkedDeque<>();
        int maxSize=6;
        Semaphore producerSemaphore = new Semaphore(maxSize);//full slots
        // initially producer will produce then only consumer should be able to consume
        Semaphore consumerSemaphore = new Semaphore(0);// empty slots
        
        Producers p1 = new Producers(store,maxSize,"P1",producerSemaphore,consumerSemaphore);
        Producers p2 = new Producers(store,maxSize,"P2",producerSemaphore,consumerSemaphore);
        Producers p3 = new Producers(store,maxSize,"P3",producerSemaphore,consumerSemaphore);

        Consumers c1 = new Consumers(store,maxSize,"C1",producerSemaphore,consumerSemaphore);
        Consumers c2 = new Consumers(store,maxSize,"C2",producerSemaphore,consumerSemaphore);
        Consumers c3 = new Consumers(store,maxSize,"C3",producerSemaphore,consumerSemaphore);
        Consumers c4 = new Consumers(store,maxSize,"C4",producerSemaphore,consumerSemaphore);
        Consumers c5 = new Consumers(store,maxSize,"C5",producerSemaphore,consumerSemaphore);

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

        System.out.println("END of main thread.");
    }
}
