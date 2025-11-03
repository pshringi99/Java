package synchronisation.Semaphores.ProducersConsumersPrbm;

import java.util.Queue;

public class Consumers implements Runnable{
    private Queue<Object>  store;
    private int maxSize;
    private String name;

    public Consumers(Queue<Object> store,int maxSize,String name){
        this.store=store;
        this.maxSize=maxSize;
        this.name=name;
    }
    @Override
    public void run() {
        while (true){
            synchronized (store){// critical section
                if(!store.isEmpty()){
                    System.out.println(this.name + " removing an element: "+store.size());
                    store.remove();
                }
            }
        }
    }
}
