package lambdasAndStreams.AdderSubtractor;

import java.util.stream.Stream;

public class Client {
    static void main() throws InterruptedException {
        Count count = new Count();
        System.out.println(count.value);


//        Adder adder = new Adder(count);
//        Subtractor subtractor = new Subtractor(count);

        //Lambda
        /*
            1. Create an anonymous class => adderLambdaAnonymous
            2. It will make the adderLambdaAnonymous class implement the runnable interface
            3. It will pass all the variable which are being shared with
            4. It will copy the code from lambda body to the method of adderLambdaAnonymous class that
            we implement

         */
//        Runnable adderLambda = ()->{
//            for (int i=1;i<=100;i++){
//                synchronized (count){
//                    count.value+=i;
//                }
//            }
//        };
//        Runnable subtractorLambda = ()->{
//            for(int i=1;i<=100;i++){
//                synchronized (count){
//                    count.value-=i;
//                }
//            }
//        };
//        Thread t1 = new Thread(adderLambda);
//        Thread t2 = new Thread(subtractorLambda);
        Thread t1 = new Thread(()->{
            for(int i=1;i<=100;i++){
                synchronized (count){
                    count.value-=i;
                }
            }
        });
        Thread t2 = new Thread(()->{
            for(int i=1;i<=100;i++){
                synchronized (count){
                    count.value-=i;
                }
            }
        });

        t1.start();// creating a new thread
        t2.start();

        System.out.println("DEBUG");
        t1.join();// waiting the thread to terminate
        t2.join();

        System.out.println(count.value);

    }
}
/**
 * synchronized keyword is in java for applying mutex lock
 */