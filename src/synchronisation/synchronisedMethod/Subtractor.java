package synchronisation.synchronisedMethod;

public class Subtractor implements Runnable{
    private Count count;

    public Subtractor(Count count){
        this.count=count;
    }
    @Override
    public void run() {
        for(int i=1;i<=100;i++){
            count.decrementValue(i);
            //System.out.println("subtractor value: "+count.getValue());
        }
    }
}
