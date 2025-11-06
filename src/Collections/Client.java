package Collections;

import java.util.*;

public class Client {
    static void main() {
        /*
        Interfaces: Collections,List,Set,Queue
        Concrete classes: ArrayList, LinkedList, Hashset, PriorityQueue
         */
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Generics");
        System.out.println(list.get(0));

        ArrayList<String> arrayList = new ArrayList<>();

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.addFirst(0);

        /*
        Vector is synchronized(thread-sage), but it is now often replaced by concurrent collection classes
        Prefer Arraylist unless you need thread-safety
         */
        Stack<Integer>st = new Stack<>();
        Queue<Integer> queue= new LinkedList<>();
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(10);
        System.out.println(pq.poll());//10 min-heap

        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("Hello");
        set.add("Hi");
        set.add("Bye");
        System.out.println("----Hash Set----");
        System.out.println(set.size());//1
        for(String ele:set){
            System.out.println(ele);
        }

        //LinkedHashSet maintains the insertion order
        Set<Integer> hashSet = new LinkedHashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);

        System.out.println("---Linked HashSet----");
        for(int ele:hashSet){
            System.out.println(ele);
        }

        //TreeSet - sorted order
        Map<String,Integer>map= new HashMap<>();
        map.put("Pradhyuman",25);
        System.out.println(map.get("Pradhyuman"));

        //HashMap: maintains no orders
        //LinkedHashMap: insertion order is maintained
        //TreeMap: sorted by keys
    }
}
