package lambdasAndStreams.lambdaComparator;

public class Student implements Comparable<Student>{
    private int id;
    private  int age;
    private String name;
    private int marks;

    public Student(int id,int age,String name,int marks){
        this.id=id;
        this.age=age;
        this.name=name;
        this.marks=marks;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public int getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}
