package synchronisation.synchronisedMethod;

public class Adder implements Runnable{
    private Count count;

    public  Adder(Count count){
        this.count=count;
    }
    @Override
    public void run()  {
        for (int i=1;i<=100;i++){
            count.incrementValue(i);
            //System.out.println("Adder value: "+count.getValue());
            /*
            *   it not atomic operation
            *   count+=i
            *   x = read(count)
            *   x= x +i;
            *   store count = x
            *
            *   similarly for subtraction
            */
        }
    }
}
