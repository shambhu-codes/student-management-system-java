import java.util.*;

public class StudentManagement {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n====>(Student Management System)<====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

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
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    // method for adding new students
    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Student s : studentList) {
            if (s.getId() == id) {
                System.out.println("Student with this ID already exists.");
                return;
            }
        }

        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        studentList.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    // method for view all the students
    public static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("\n--- Student Records ---");
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    // method for update the existing students data like id,name and marks
    public static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();

        for (Student s : studentList) {
            if (s.getId() == id) {
                sc.nextLine(); // consume newline
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                System.out.print("Enter new marks: ");
                double newMarks = sc.nextDouble();

                s.setName(newName);
                s.setMarks(newMarks);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    // method for delete the existing students details
    public static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Sorry, student with this ID does not exist.");
    }
}
