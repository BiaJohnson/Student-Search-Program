# Student Search Program

## Overview
This program allows users to search for students in a text file based on their name or ID. It ensures that only valid files are used and checks that the file format is correct before searching. Users can perform multiple searches, and if a file is missing or incorrectly formatted, they must enter a new one.

The program reads from a file where each line contains a student's name and ID, separated by a space.

## Project Structure

### Main.java
Handles user interaction and controls the flow of the program.
- Welcomes the user and asks for a file name.
- Validates the file using the Database class.
- If the file is missing or incorrectly formatted, it asks for another one.
- Once a valid file is provided, it offers search options:
    - Find a student ID by entering a name.
    - Find a student name by entering an ID.
    - Exit the program.
- Each search opens a fresh Scanner to ensure correct file reading.

### Database.java
Manages file validation and student search functionality.
- `validateFile` checks if the file exists and follows the correct format.
- `findID` searches for a student's ID based on their name and **receives a Scanner** as a parameter to read the file.
- `findName` searches for a student's name based on their ID and **receives a Scanner** as a parameter to read the file.
- Throws exceptions if a file is missing, incorrectly formatted, or if a student is not found.

### StudentNotFoundException.java
A custom exception that is thrown when a student name or ID is not found in the search.

### FileFormatException.java
A custom exception that is thrown if the file does not follow the correct format, such as having lines with an incorrect number of values.

## Example Output
The program displays an interactive menu where the user can search by name or ID. If the file is missing or formatted incorrectly, it asks for a new one.