package multithreading;


import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String args[]) {
        System.out.println("current thread name: "+ Thread.currentThread().getName());

        // we need  to create the thread , other wise hello world printer will run in the main thread
        //when we start the thread , it invoke the run method of Helloworldprinter
        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
        //Thread t = new Thread(helloWorldPrinter);
        //t.start();
//        while(true){// will run infinity and consume all the resources of cpu
            //HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
            //Thread t = new Thread(helloWorldPrinter);
            //t.start();
//        }

        //Better way:
        //Using Executor Service - basically using Thread pools.
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        for(int i=0;i<15;i++){
//            executorService.submit(helloWorldPrinter);
//        }
        //t1 and main thread will execute independently, any of thread can be completed , done and hello world from new thread can be printed in any order
//        System.out.println("Done!!");
//        executorService.shutdown();
        for(int i=1;i<=100;i++){
            ForLoopPrinter forLoopPrinter = new ForLoopPrinter(i);
            executorService.submit(forLoopPrinter);
        }
        executorService.shutdown();
    }
}
