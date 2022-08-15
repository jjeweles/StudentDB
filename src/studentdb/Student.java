package studentdb;

import java.util.Objects;
import java.util.Scanner;

public class Student {
    private final String firstName;
    private final String lastName;
    private int gradeLevel;
    private String courses = "";
    private String studentId;
    private int tuitionBalance = 0;
    private static int id = 1000;

    // constructor for student
    public Student() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter student's first name: ");
        this.firstName = input.nextLine();
        System.out.print("Enter student's last name: ");
        this.lastName = input.nextLine();
        System.out.print("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student's grade level: ");
        try {
            this.gradeLevel = input.nextInt();
        } catch(Exception e) {
            System.out.println("Invalid input, please try again.");
            System.out.print("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student's grade level: ");
        }

        setStudentId();

        enrollStudent();

        viewBalance();

        payTuition();

        showStudentInfo();
    }

    // generate an ID
    private void setStudentId(){
        // increment id
        id++;
        // grade level + static id
        this.studentId = gradeLevel + "" + id;
    }

    // enroll student in courses
    public void enrollStudent() {
        boolean continueEnrolling = true;
        do {
            System.out.print("Enter course to enroll (F to finish): ");
            Scanner input = new Scanner(System.in);
            String course = input.nextLine().toUpperCase();
            if (!Objects.equals(course, "F")) {
                courses = courses + "\n" + course;
                int courseCost = 600;
                tuitionBalance += courseCost;
            } else {
                continueEnrolling = false;
            }
        } while (continueEnrolling);
        System.out.println("\nENROLLED IN: " + courses);
    }

    // view balance and pay tuition
    public void viewBalance() {
        System.out.println("TUITION BALANCE: $" + tuitionBalance);
    }

    public void payTuition() {
        System.out.print("\nHow much would you like to pay? \n$");
        Scanner input = new Scanner(System.in);
        int amountToPay = input.nextInt();
        tuitionBalance -= amountToPay;
        System.out.println("Thank you for your payment of $" + amountToPay);
        viewBalance();
    }

    // show student status
    public void showStudentInfo() throws InterruptedException {
        System.out.println("\nName: " + this.firstName + " " + this.lastName);
        System.out.println("Grade Level: " + this.gradeLevel);
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Courses: " + this.courses);
        System.out.println("Tuition Balance: " + this.tuitionBalance + "\n");
        Thread.sleep(2000);
    }

}
