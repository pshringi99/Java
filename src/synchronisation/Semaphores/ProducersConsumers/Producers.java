package synchronisation.Semaphores.ProducersConsumers;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producers implements Runnable{
    private Queue<Object> store;
    private int maxSize;
    private String name;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Producers(Queue<Object> store,int maxSize,String name, Semaphore producerSemaphore,Semaphore consumerSemaphore){
        this.store=store;
        this.maxSize=maxSize;
        this.name=name;
        this.consumerSemaphore = consumerSemaphore;
        this.producerSemaphore = producerSemaphore;
    }
    @Override
    public void run() {
        while (true){
            try {
                producerSemaphore.acquire();
                System.out.println(this.name+ " Adding an element: "+store.size());
                store.add(new Object());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                consumerSemaphore.release();
            }
        }
    }
}
