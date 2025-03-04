import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    // Student class to represent a student
    static class Student {
        private String name;
        private int rollNumber;
        private int age;
        private String grade;

        // Constructor
        public Student(String name, int rollNumber, int age, String grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.age = age;
            this.grade = grade;
        }

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRollNumber() {
            return rollNumber;
        }

        public void setRollNumber(int rollNumber) {
            this.rollNumber = rollNumber;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        // Method to display student details
        public void displayStudentDetails() {
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Age: " + age);
            System.out.println("Grade: " + grade);
        }
    }

    // Main class to manage the student system
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Method to add a new student
    public static void addStudent() {
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter grade: ");
        String grade = scanner.nextLine();

        // Create new student object and add it to the list
        Student student = new Student(name, rollNumber, age, grade);
        students.add(student);
        System.out.println("Student added successfully!\n");
    }

    // Method to view all students
    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.\n");
        } else {
            System.out.println("----- List of Students -----");
            for (Student student : students) {
                student.displayStudentDetails();
                System.out.println("----------------------------");
            }
        }
    }

    // Method to update student details
    public static void updateStudent() {
        System.out.println("Enter roll number of the student to update: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean found = false;
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                found = true;
                System.out.println("Enter new name: ");
                student.setName(scanner.nextLine());
                System.out.println("Enter new age: ");
                student.setAge(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.println("Enter new grade: ");
                student.setGrade(scanner.nextLine());
                System.out.println("Student details updated successfully!\n");
                break;
            }
        }
        if (!found) {
            System.out.println("Student with roll number " + rollNumber + " not found.\n");
        }
    }

    // Method to delete a student
    public static void deleteStudent() {
        System.out.println("Enter roll number of the student to delete: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean found = false;
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                found = true;
                students.remove(student);
                System.out.println("Student deleted successfully!\n");
                break;
            }
        }
        if (!found) {
            System.out.println("Student with roll number " + rollNumber + " not found.\n");
        }
    }

    // Main menu
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("------ Student Management System ------");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        } while (choice != 5);
    }
}
