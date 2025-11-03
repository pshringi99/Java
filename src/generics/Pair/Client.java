package generics.Pair;

public class Client {
    static void main(String[] args) {
//        Pair p = new Pair("Hello",100);
//        p.setFirst(55); // allowed: but we really wanted string in first position
//
//        String s = (String)p.getFirst();// ClassCastExecption at runtime:
//
        PairGenerics<String,Integer> p = new PairGenerics<>("Pradhyuman",100);// compile type safety
//        p.setFirst(22); this is compile type error
        p.setFirst("Alok");

        //What if i dont specify the type, same as pair class without compile type safety- Raw types
        PairGenerics p1 = new PairGenerics("bob",40);
        p1.setFirst(22);
        // This disables the checks and not recommmended because looses type safety

    }
}
/*
    There is no compile time safety.
    Generics provide flexibility and compile time safety.
    Why raw types are still supported? Backward compatibility.
 */