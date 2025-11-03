package synchronisation.synchronisedMethod;

public class Client {
    static void main() throws InterruptedException {
        Count count = new Count();
        System.out.println(count.getValue());

        /*
        *   1. Add nums from 1 to 100 to count.value
        *   2. Subtract nums from 1 to 100 from count.value
        *
        *   Thread 1: +1, +2, +3, +4 .... +100
        *   Thread 2: -1, -2, -3, -4 .... -100
        *
        *   final value = 0;
        */

        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);

        t1.start();// creating a new thread
        t2.start();

        System.out.println("DEBUG");
        t1.join();// waiting the thread to terminate
        t2.join();

        System.out.println(count.getValue());

    }
}
