package lambdasAndStreams.lambdaComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
                new Student(1, 27, "Pradhyuman", 99),
                new Student(2, 22, "Shubham", 89),
                new Student(3, 56, "Devendra", 67)
        ));
        Collections.sort(students);
        System.out.println(students);

        Comparator<Student> comparatorByName=(o1,o2)->{
            if(o1.getName().equals(o2.getName())){
                return o1.compareTo(o2);// if tie, sort by their natural ordering.
            }
            else if(o1.getName().compareTo(o2.getName())<0) return -1;
            return 1;
        };
        students.sort(comparatorByName);
        System.out.println(students);


    }
}
