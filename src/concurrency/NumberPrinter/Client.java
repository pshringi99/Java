package concurrency.NumberPrinter;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws Exception {
        //create pool with 10 threads
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService =  Executors.newCachedThreadPool();
        for(int i=1;i<=100;i++){
            System.out.println("DEBUG");
            NumberPrinter task = new NumberPrinter(i);
            executorService.execute(task);//submitting the task to the pool
        }

        //It's crucial that we shutdown the executor service ,
        // otherwise the application will not terminate
        executorService.shutdown();
    }
}
/*
    Fix size thread pool:
    when to use this kind of thread pool: ideal for CPU bound task - task where the no of threads are close
    to number of CPU cores.
    i.e. printing number with fixed pool.

    Cached thread pool:
    creates new thread as they are needed - if no idle thread is available.
    when to use : excellent for short-lived I/O bound task.
    e.g. handling request in a web server where thread spends a lot of tine wait for the network or DB
    responses

    Note: A cached pool can grow without limit.
    If task are long-running, then you end up creating a lot of threads and running out of memory.
 */
