package generics;

public class Client {
    static void main() {
        Box<Integer,Integer> box = new Box<>();
        box.doSomething(12);

//        Integer[] arr = new Integer[]{1,2,3};
//        Box.doSomething1(arr);
    }
}
