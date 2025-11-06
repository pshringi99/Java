package generics;

public class Box <T,V>{

    public void doSomething(T item){

    }

    //public static void doSomething1(T item){//T is defined at the time of instance whereas this is class
        //level method / static method, T cannot be interpreted at static level/ class level context
    //}

    public static <T,V> void doSomething1(T[] array, V v){
        for (T item:array){
            System.out.println(item);
            System.out.println(v);
        }
    }

    public static <T> void swap(T[] array,int i,int j){
        T temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }

//    public static <T> T max(T[] arr){
//        T max = arr[0];
//        for(T ele:arr){
//            if(ele.)
//        }
//    }
}

static class Car implements Comparable{

}
