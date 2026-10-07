import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n=================================");
            System.out.println("      STUDENT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("\nThank you for using Student Management System! 🎓");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }

    public static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Student Marks: ");
        double marks = sc.nextDouble();

        Student student = new Student(id, name, age, marks);

        students.add(student);

        System.out.println("✅ Student added successfully!");
    }

    public static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("\n📭 No students found.");
            return;
        }

        System.out.println("\n========== STUDENT LIST ==========");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    public static void searchStudent() {

        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.println("\n🎯 Student Found!");
                student.displayStudent();
                return;
            }
        }

        System.out.println("❌ Student not found!");
    }

    public static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (Student student : students) {

            if (student.getId() == id) {

                students.remove(student);

                System.out.println("🗑️ Student deleted successfully!");
                return;
            }
        }

        System.out.println("❌ Student not found!");
    }
}
