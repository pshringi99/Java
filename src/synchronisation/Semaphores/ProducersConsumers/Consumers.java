package synchronisation.Semaphores.ProducersConsumers;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumers implements Runnable{
    private Queue<Object>  store;
    private int maxSize;
    private String name;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Consumers(Queue<Object> store,int maxSize,String name,Semaphore producerSemaphore,Semaphore consumerSemaphore){
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }
    @Override
    public void run() {
        while (true){
            try {
                consumerSemaphore.acquire();
                System.out.println(this.name + " removing an element: "+store.size());
                store.remove();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                producerSemaphore.release();

            }
        }
    }
}
