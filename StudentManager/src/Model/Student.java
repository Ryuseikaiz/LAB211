package Model;

public class Student implements Comparable<Student> {
    private String name;
    private String classes;
    private float mark;

    public Student() {
    }

    public Student(String name, float mark, String classes) {
        this.name = name;
        this.classes = classes;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", classes=" + classes + ", mark=" + mark + '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.getName());
    }
    

}
