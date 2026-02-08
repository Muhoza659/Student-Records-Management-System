public class Student {
    int studentId;
    String name;
    int age;
    double score;

    public Student(int studentId, String name, int age, double score) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String toString() {
        return studentId + " " + name + " " + age + " " + score;
    }
    public String toFileFormat()  {
        return studentId + "," + name + "," + age + "," + score;
    }
}
