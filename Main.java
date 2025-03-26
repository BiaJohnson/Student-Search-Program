import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Handles user input, file validation, and search operations interactively.
 */
public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        String fileName;
        File file = null;

        System.out.println("Welcome to the Student Search Program!");

        // Keep asking for a valid file until one is provided
        while (true) {
            System.out.print("Enter the file name: ");
            fileName = inputScanner.next();
            file = new File(fileName);

            try {
                if (Database.validateFile(fileName)) {
                    break; // File is valid, exit loop
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (FileFormatException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter a correctly formatted file.");
            }
        }

        // Main search loop
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("0 - Search by Name (Find ID)");
            System.out.println("1 - Search by ID (Find Name)");
            System.out.println("2 - Exit");
            System.out.print("Your choice: ");

            if (!inputScanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter 0, 1, or 2.");
                inputScanner.next(); // Clear invalid input
                continue;
            }

            int searchOption = inputScanner.nextInt();
            inputScanner.nextLine(); // Consume newline

            try {
                if (searchOption == 0) {
                    System.out.print("Enter student name: ");
                    String studentName = inputScanner.nextLine().trim();

                    // Open a fresh Scanner for each search
                    Scanner fileScanner = new Scanner(file);
                    System.out.println("Student ID: " + Database.findID(studentName, fileScanner));
                    fileScanner.close();

                } else if (searchOption == 1) {
                    System.out.print("Enter student ID: ");
                    String studentID = inputScanner.nextLine().trim();

                    // Open a fresh Scanner for each search
                    Scanner fileScanner = new Scanner(file);
                    System.out.println("Student Name: " + Database.findName(studentID, fileScanner));
                    fileScanner.close();

                } else if (searchOption == 2) {
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                } else {
                    System.out.println("Invalid option! Please enter 0, 1, or 2.");
                }
            } catch (StudentNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (FileNotFoundException e) {
                System.out.println("Unexpected error: File not found.");
            }
        }

        inputScanner.close();
    }
}