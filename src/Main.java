public class Main {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();

        manager.loadFromFile("students.txt");

        manager.displayStudents();
        manager.averageScore();
        manager.highestScore();
        manager.lowestScore();
        manager.passedStudents();
        manager.failedStudents();

        manager.addStudent(new Student(111, "Sam", 23, 70));
        manager.updateScore(105, 95);

        manager.saveToFile("students.txt");
    }
}
