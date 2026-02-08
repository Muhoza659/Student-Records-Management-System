import java.io.*;
import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    public void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            if (!br.ready()) {
                System.out.println("File is empty.");
                return;
            }

            while ((line = br.readLine()) != null) {
                try {
                    String[] data = line.split(",");
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    double score = Double.parseDouble(data[3].trim());

                    students.add(new Student(id, name, age, score));
                } catch (Exception e) {
                    System.out.println("Invalid record skipped: " + line);
                }
            }

            System.out.println("Loaded " + students.size() + " students from the file.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    public void displayStudents() {
        System.out.println("--- Student List ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }


    public void highestScore() {
        Student top = students.get(0);
        for (Student s : students) {
            if (s.score > top.score) {
                top = s;
            }
        }
        System.out.println("Top student: " + top.name + " (" + top.score + ")");
    }


    public void lowestScore() {
        Student low = students.get(0);
        for (Student s : students) {
            if (s.score < low.score) {
                low = s;
            }
        }
        System.out.println("Lowest student: " + low.name + " (" + low.score + ")");
    }


    public void averageScore() {
        double sum = 0;
        for (Student s : students) {
            sum += s.score;
        }
        System.out.println("Average score: " + (sum / students.size()));
    }


    public void passedStudents() {
        System.out.println("Students who passed:");
        boolean found = false;
        for (Student s : students) {
            if (s.score >= 60) {
                System.out.println(s.name);
                found = true;
            }
        }
        if (!found) {
            System.out.println("None");
        }
    }

    public void failedStudents() {
        System.out.println("Students who failed:");
        boolean found = false;
        for (Student s : students) {
            if (s.score < 60) {
                System.out.println(s.name);
                found = true;
            }
        }
        if (!found) {
            System.out.println("None");
        }
    }


    public void addStudent(Student s) {
        students.add(s);
    }

    public void updateScore(int id, double newScore) {
        for (Student s : students) {
            if (s.studentId == id) {
                s.score = newScore;
                System.out.println("Score updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Student s : students) {
                pw.println(s.studentId + "," + s.name + "," + s.age + "," + s.score);
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }
}
