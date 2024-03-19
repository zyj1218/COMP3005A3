import java.sql.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAvailable Commands(Number ONLY):");
            System.out.println("1. get - Retrieve all students");
            System.out.println("2. add - Add a new student");
            System.out.println("3. update - Update a student's email");
            System.out.println("4. delete - Delete a student");
            System.out.println("5. exit - Exit the application");
            System.out.print("Enter command: ");

            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    db.getAllStudents();
                    break;
                case "2":
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter enrollment date (YYYY-MM-DD): ");
                    String enrollmentDate = scanner.nextLine();
                    db.addStudent(firstName, lastName, email, Date.valueOf(enrollmentDate));
                    System.out.println("Student added successfully.");
                    break;
                case "3":
                    System.out.print("Enter student ID: ");
                    int idToUpdate = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    db.updateStudentEmail(idToUpdate, newEmail);
                    System.out.println("Student email updated successfully.");
                    break;
                case "4":
                    System.out.print("Enter student ID: ");
                    int idToDelete = Integer.parseInt(scanner.nextLine());
                    db.deleteStudent(idToDelete);
                    System.out.println("Student deleted successfully.");
                    break;
                case "5":
                    System.out.println("Exiting the application...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
