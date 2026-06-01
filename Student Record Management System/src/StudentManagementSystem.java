import java.util.ArrayList;
import java.util.Scanner;


class Student {

    int id;
    String name;
    double marks;

    // Constructor
    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }


    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("-----");
    }
}

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n STUDENT MANAGEMENT SYSTEM ");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {


                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Student Marks: ");
                    double marks = sc.nextDouble();

                    students.add(new Student(id, name, marks));

                    System.out.println("Student Added Successfully!");
                    break;


                case 2:

                    if (students.isEmpty()) {

                        System.out.println("No Student Records Found!");

                    } else {

                        System.out.println("\n--- Student Records ---");

                        for (Student s : students) {
                            s.display();
                        }
                    }

                    break;


                case 3:

                    System.out.print("Enter Student ID to Update: ");
                    int updateId = sc.nextInt();

                    boolean foundUpdate = false;

                    for (Student s : students) {

                        if (s.id == updateId) {

                            sc.nextLine();

                            System.out.print("Enter New Name: ");
                            s.name = sc.nextLine();

                            System.out.print("Enter New Marks: ");
                            s.marks = sc.nextDouble();

                            System.out.println("Student Updated Successfully!");

                            foundUpdate = true;
                            break;
                        }
                    }

                    if (!foundUpdate) {
                        System.out.println("Student Not Found!");
                    }

                    break;


                case 4:

                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();

                    boolean foundDelete = false;

                    for (Student s : students) {

                        if (s.id == deleteId) {

                            students.remove(s);

                            System.out.println("Student Deleted Successfully!");

                            foundDelete = true;
                            break;
                        }
                    }

                    if (!foundDelete) {
                        System.out.println("Student Not Found!");
                    }

                    break;


                case 5:

                    System.out.println("Program Closed.");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}