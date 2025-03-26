import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Manages student records, validates files, and provides search functions.
 */
public class Database {

    /**
     * Validates if a file exists and is correctly formatted.
     * @param fileName The name of the file to validate.
     * @return True if the file is valid, otherwise throws an exception.
     * @throws FileNotFoundException If the file does not exist.
     * @throws FileFormatException If the file format is incorrect.
     */
    public static boolean validateFile(String fileName) throws FileNotFoundException, FileFormatException {
        File file = new File(fileName);
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("File not found: " + fileName);
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String[] data = line.split(" ");
                if (data.length != 2) {
                    throw new FileFormatException("Invalid file format in " + fileName +
                            ". Each line must contain exactly two values (Name and ID). Found: " + line);
                }
            }
        }

        return true; // File is valid
    }

    /**
     * Searches for a student's ID using their name.
     * @param studentName The student's name.
     * @param scanner A Scanner object containing the text file's contents.
     * @return The student's ID.
     * @throws StudentNotFoundException If the student is not found.
     */
    public static String findID(String studentName, Scanner scanner) throws StudentNotFoundException {
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().trim().split(" ");
            if (data.length == 2 && data[0].equals(studentName)) {
                return data[1]; // Return the student ID
            }
        }
        throw new StudentNotFoundException("Student ID not found for " + studentName);
    }

    /**
     * Searches for a student's name using their ID.
     * @param studentID The student's ID.
     * @param scanner A Scanner object containing the text file's contents.
     * @return The student's name.
     * @throws StudentNotFoundException If the student is not found.
     */
    public static String findName(String studentID, Scanner scanner) throws StudentNotFoundException {
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().trim().split(" ");
            if (data.length == 2 && data[1].equals(studentID)) {
                return data[0]; // Return the student name
            }
        }
        throw new StudentNotFoundException("Student name not found for " + studentID);
    }
}