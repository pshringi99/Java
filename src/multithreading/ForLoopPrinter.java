package multithreading;

public class ForLoopPrinter implements Runnable{
    private  int number;

    public ForLoopPrinter(int number){
        this.number=number;
    }

    @Override
    public void run() {
        System.out.println("Number is: "+number);
    }
}
