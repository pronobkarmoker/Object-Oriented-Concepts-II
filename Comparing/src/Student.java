public class Student implements java.lang.Comparable<Student> {
    int roll;
    int marks;

    public Student(int roll, int marks) {
        this.roll = roll;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student o) {
        int diff = ((int)this.marks - o.marks);
        return diff;
    }
}
