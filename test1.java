import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

    class StudentRegistrationSystemTest {

        @Test
        void testStudentRegistrationSystem() {
            // Redirect System.in and System.out for testing
            String input = "1\nfir \n1234\nfir@example.com\n1\n1,2\n2\nJane\n4567\njane@example.com\n2\n3\n";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Execute the main method (simulate user input)
            StudentRegistrationSystem.main(new String[]{});

            // Reset System.in and System.out
            System.setIn(System.in);
            System.setOut(System.out);

            // Verify the output
            String expectedOutput = "1. Register Student\n" +
                    "2. Display Registered Students\n" +
                    "3. Exit\n" +
                    "Enter your choice: " +
                    "Enter student name: " +
                    "Enter student ID: " +
                    "Enter student email: " +
                    "Choose department (1. Software Engineering, 2. Computer Science): " +
                    "Choose courses (separate with commas):" +
                    "1. Networking\n" +
                    "2. Statistics\n" +
                    "3. Data Structure\n" +
                    "4. Computer Programming\n" +
                    "1. Register Student\n" +
                    "2. Display Registered Students\n" +
                    "3. Exit\n" +
                    "Enter your choice: " +
                    "Enter student name: " +
                    "Enter student ID: " +
                    "Enter student email: " +
                    "Choose department (1. Software Engineering, 2. Computer Science): " +
                    "Choose courses (separate with commas):" +
                    "1. Math\n" +
                    "2. Databases\n" +
                    "3. Getting Started with the Computer Science Career Path\n" +
                    "2. Display Registered Students\n" +
                    "Registered Students:\n" +
                    "Name: fir\n" +
                    "ID: 1234\n" +
                    "Email: fir@example.com\n" +
                    "Department: Software Engineering\n" +
                    "Courses: [Networking, Statistics]\n" +
                    "\n" +
                    "Name: Jane\n" +
                    "ID: 4567\n" +
                    "Email: jane@example.com\n" +
                    "Department: Computer Science\n" +
                    "Courses: [Getting Started with the Computer Science Career Path]\n" +
                    "\n" +
                    "1. Register Student\n" +
                    "2. Display Registered Students\n" +
                    "3. Exit\n" +
                    "Enter your choice: " +
                    "Exiting...\n";

            assertEquals(expectedOutput, outputStream.toString());
        }
    }


