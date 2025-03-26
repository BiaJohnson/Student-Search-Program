/**
 * Custom exception for when a student is not found in the database.
 */
public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}