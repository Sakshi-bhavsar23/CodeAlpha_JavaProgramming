import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    String getGrade() {
        if (marks >= 90)
            return "A+";
        else if (marks >= 80)
            return "A";
        else if (marks >= 70)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 50)
            return "D";
        else
            return "F";
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("==================================");
        System.out.println("       STUDENT GRADE TRACKER");
        System.out.println("==================================");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Input student details
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks (0-100): ");
            double marks = sc.nextDouble();
            sc.nextLine();

            students.add(new Student(name, marks));
        }

        // Calculate statistics
        double total = 0;
        double highest = students.get(0).marks;
        double lowest = students.get(0).marks;

        String highestStudent = students.get(0).name;
        String lowestStudent = students.get(0).name;

        for (Student student : students) {

            total += student.marks;

            if (student.marks > highest) {
                highest = student.marks;
                highestStudent = student.name;
            }

            if (student.marks < lowest) {
                lowest = student.marks;
                lowestStudent = student.name;
            }
        }

        double average = total / students.size();

        // Summary report
        System.out.println("\n==================================");
        System.out.println("         STUDENT SUMMARY");
        System.out.println("==================================");

        System.out.printf("%-20s %-10s %-10s%n",
                "Name", "Marks", "Grade");

        System.out.println("----------------------------------");

        for (Student student : students) {
            System.out.printf("%-20s %-10.2f %-10s%n",
                    student.name,
                    student.marks,
                    student.getGrade());
        }

        System.out.println("----------------------------------");

        System.out.printf("Average Marks : %.2f%n", average);
        System.out.printf("Highest Marks : %.2f (%s)%n",
                highest, highestStudent);
        System.out.printf("Lowest Marks  : %.2f (%s)%n",
                lowest, lowestStudent);

        System.out.println("==================================");

        sc.close();
    }
}