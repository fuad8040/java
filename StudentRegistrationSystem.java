import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Student {
    protected String name;
    protected String id;
    protected String email;

    public Student(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public abstract void displayInfo();
}

class SoftwareEngineeringStudent extends Student {
    private ArrayList<String> courses;

    public SoftwareEngineeringStudent(String name, String id, String email) {
        super(name, id, email);
        this.courses = new ArrayList<>();
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Department: Software Engineering");
        System.out.println("Courses: " + courses);
    }
}

class ComputerScienceStudent extends Student {
    private ArrayList<String> courses;

    public ComputerScienceStudent(String name, String id, String email) {
        super(name, id, email);
        this.courses = new ArrayList<>();
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Department: Computer Science");
        System.out.println("Courses: " + courses);
    }
}

public class StudentRegistrationSystem {
    public static void main(String[] args) {
        ArrayList<Student> registeredStudents = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register Student");
            System.out.println("2. Display Registered Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter student ID: ");
                        String id = scanner.nextLine();

                        System.out.print("Enter student email: ");
                        String email = scanner.nextLine();

                        System.out.print("Choose department (1. Software Engineering, 2. Computer Science): ");
                        int departmentChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        if (departmentChoice == 1) {
                            SoftwareEngineeringStudent seStudent = new SoftwareEngineeringStudent(name, id, email);

                            System.out.println("Choose courses (separate with commas):");
                            System.out.println("1. Networking");
                            System.out.println("2. Statistics");
                            System.out.println("3. Data Structure");
                            System.out.println("4. Computer Programming");

                            String[] courseChoices = scanner.nextLine().split(",");
                            for (String courseChoice : courseChoices) {
                                switch (courseChoice.trim()) {
                                    case "1":
                                        seStudent.addCourse("Networking");
                                        break;
                                    case "2":
                                        seStudent.addCourse("Statistics");
                                        break;
                                    case "3":
                                        seStudent.addCourse("Data Structure");
                                        break;
                                    case "4":
                                        seStudent.addCourse("Computer Programming");
                                        break;
                                }
                            }

                            registeredStudents.add(seStudent);
                        } else if (departmentChoice == 2) {
                            ComputerScienceStudent csStudent = new ComputerScienceStudent(name, id, email);

                            System.out.println("Choose courses (separate with commas):");
                            System.out.println("1. Math");
                            System.out.println("2. Databases");
                            System.out.println("3. Getting Started with the Computer Science Career Path");

                            String[] courseChoices = scanner.nextLine().split(",");
                            for (String courseChoice : courseChoices) {
                                switch (courseChoice.trim()) {
                                    case "1":
                                        csStudent.addCourse("Math");
                                        break;
                                    case "2":
                                        csStudent.addCourse("Databases");
                                        break;
                                    case "3":
                                        csStudent.addCourse("Getting Started with the Computer Science Career Path");
                                        break;
                                }
                            }

                            registeredStudents.add(csStudent);
                        } else {
                            System.out.println("Invalid department choice!");
                        }

                        break;
                    case 2:
                        System.out.println("Registered Students:");
                        for (Student student : registeredStudents) {
                            student.displayInfo();
                            System.out.println();
                        }
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
}

