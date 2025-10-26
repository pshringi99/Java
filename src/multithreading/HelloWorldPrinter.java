package multithreading;

public class HelloWorldPrinter implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello world from new thread: "+Thread.currentThread().getName());
    }
}
