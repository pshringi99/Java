package synchronisation.synchronisedMethod;

public class Count {
    private int value = 0;

    public synchronized void incrementValue(int offset){
        this.value +=offset;
    }
    public int getValue(){
        return value;
    }
    public synchronized void decrementValue(int offset){
        this.value -=offset;
    }
}
