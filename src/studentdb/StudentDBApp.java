package studentdb;

import java.util.Scanner;

public class StudentDBApp {

    public static void main(String[] args) throws InterruptedException {

        boolean studentAppOn = true;
        // ask how many students to create
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("########################");
            System.out.println("##      MAIN MENU     ##");
            System.out.println("########################");
            System.out.println("##  1. ENROLL STUDENT ##");
            System.out.println("##  2. SHOW STUDENTS  ##");
            System.out.println("##  2. SHOW STD INFO  ##");
            System.out.println("########################");
            System.out.print("Select An Option (Q to Quit): ");
            String menuAnswer = input.nextLine().toUpperCase();
            switch (menuAnswer) {
                case "1":
                    new Student();
                    break;
                case "2":
                    System.out.println("Show students in DB here.");
                    break;
                case "3":
                    System.out.println("Show selected student info here.");
                    break;
                case "Q":
                    System.out.println("Thank you for using the university student system.\nGood bye.");
                    studentAppOn = false;
                default:
                    System.out.println("Invalid input, please try again.");

            }
        } while (studentAppOn);
        // create students
    }
}
