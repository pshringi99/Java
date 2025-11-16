package lambdasAndStreams.Streams;

import lambdasAndStreams.lambdaComparator.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Client {
    static void main() {
        List<Integer> l1=new ArrayList<>(List.of(1,3,34,43,23,23,4,4,423));
        // filter the list of student with even ids
        List<Integer> l2=l1.stream().filter((x)->{return x%2==0;}).toList();
        System.out.println(l2);
        List<Integer> l3=l1.stream().filter((x)->x%2==0).map(x->x*x).distinct().toList();
        System.out.println(l3);

        Optional<Integer> optional = l1.stream().findAny();
        System.out.println(optional);// could have any integer or if stream is empty then null value
        if(optional.isPresent()){
            int val= optional.get();
            System.out.println(val);
        }
    }
}
