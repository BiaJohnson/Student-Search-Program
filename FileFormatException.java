/**
 * Custom exception for when the input file is incorrectly formatted.
 */
public class FileFormatException extends Exception {
    public FileFormatException(String message) {
        super(message);
    }
}