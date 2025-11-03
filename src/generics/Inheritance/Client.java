package generics.Inheritance;

import java.util.ArrayList;
import java.util.List;

public class Client {
    static void main() {
        List<Dog> dogs = new ArrayList<>();
//        dogs.add(1);// will not accept
        dogs.add(new Dog());

        //List<Animal> animals = dogs;//compile time error
        /*
        List<Animal> != List<Dog>
        list of animal is not a parent class of list of dogs
         */
        List<Animal> animals1 = new ArrayList<>();
        animals1.add(new Dog());// Dog IS-A animal.

        printAnimals(animals1);// correct
        printAnimals(dogs); //--Legal due to wildcard

        List<LivingBeings> livingBeings = new ArrayList<>();
//        printAnimals(livingBeings);

        List<Cat> cats= new ArrayList<>();
        printAnimals(cats);

        List<Tiger> tigers= new ArrayList<>();
        printAnimals(tigers);

        addDog(new ArrayList<Animal>());
        addDog(new ArrayList<Dog>());
    }

    // I want to be able to pass a List<Dogs> , List<Cats>
    // I should not be able to pass a List<Iphone>
    // I should not be able to pass a List<LivingBeings>
    /*
    ? extends is a wildcard that allows you to read from a collection from unknown subtypes
     */
    public static void  printAnimals(List<? extends Animal> animals){
        for(Animal a:animals){
            System.out.println(a);
        }
//        animals.add(new Dog()); it is ambigious
    }

    /*
    safely insert for specific types
     */
    public static void addDog(List<? super Dog> list){//List<Animal> list, List<LivingBeings>list
        list.add(new Dog());
        list.add(new Labrador());
        //list.add(new Animal()); -- cannot be passed since it make ambigious
    }
}
