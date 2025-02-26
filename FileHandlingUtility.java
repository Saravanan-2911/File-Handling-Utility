import java.io.*; // Importing necessary Java I/O classes
import java.util.Scanner; // Importing Scanner class for user input

class FileHandlingUtility {

    /**
     * Creates a new file if it does not exist.
     * @param fileName The name of the file to be created.
     */
    public static void createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + fileName);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    /**
     * Writes content to a file (overwrites existing content).
     * @param fileName The name of the file to write to.
     * @param content The content to be written.
     */
    public static void writeToFile(String fileName, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(content); // Writing content to file
            System.out.println("Content written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Reads content from a file and prints it to the console.
     * @param fileName The name of the file to read from.
     */
    public static void readFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Content of " + fileName + ":");
            while ((line = br.readLine()) != null) { // Reading file line by line
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    /**
     * Appends content to an existing file.
     * @param fileName The name of the file to modify.
     * @param content The content to append.
     */
    public static void modifyFile(String fileName, String content) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName, true))) {
            pw.println(content); // Appending content to file
            System.out.println("Content appended to " + fileName);
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    /**
     * Renames a file to a new name.
     * @param oldFileName The current file name.
     * @param newFileName The new file name.
     */
    public static void renameFile(String oldFileName, String newFileName) {
        File oldFile = new File(oldFileName);
        File newFile = new File(newFileName);
        if (oldFile.renameTo(newFile)) { // Renaming the file
            System.out.println("File renamed from " + oldFileName + " to " + newFileName);
        } else {
            System.out.println("Failed to rename file.");
        }
    }

    /**
     * Deletes a file.
     * @param fileName The name of the file to delete.
     */
    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) { // Deleting the file
            System.out.println("File deleted: " + fileName);
        } else {
            System.out.println("Failed to delete file.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        boolean exit = false; // Control variable for loop

        while (!exit) { // Looping until user chooses to exit
            // Display menu
            System.out.println("\nFile Handling Menu:");
            System.out.println("1. Create File");
            System.out.println("2. Write to File");
            System.out.println("3. Read File");
            System.out.println("4. Append to File");
            System.out.println("5. Rename File");
            System.out.println("6. Delete File");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt(); // Taking user choice input
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1: // Create file
                    System.out.print("Enter the file name to create: ");
                    String createFileName = scanner.nextLine();
                    createFile(createFileName);
                    break;

                case 2: // Write to file
                    System.out.print("Enter the file name to write to: ");
                    String writeFileName = scanner.nextLine();
                    System.out.print("Enter content to write: ");
                    String writeContent = scanner.nextLine();
                    writeToFile(writeFileName, writeContent);
                    break;

                case 3: // Read file
                    System.out.print("Enter the file name to read: ");
                    String readFileName = scanner.nextLine();
                    readFromFile(readFileName);
                    break;

                case 4: // Append to file
                    System.out.print("Enter the file name to append to: ");
                    String appendFileName = scanner.nextLine();
                    System.out.print("Enter content to append: ");
                    String appendContent = scanner.nextLine();
                    modifyFile(appendFileName, appendContent);
                    break;

                case 5: // Rename file
                    System.out.print("Enter the current file name: ");
                    String oldFileName = scanner.nextLine();
                    System.out.print("Enter the new file name: ");
                    String newFileName = scanner.nextLine();
                    renameFile(oldFileName, newFileName);
                    break;

                case 6: // Delete file
                    System.out.print("Enter the file name to delete: ");
                    String deleteFileName = scanner.nextLine();
                    deleteFile(deleteFileName);
                    break;

                case 7: // Exit program
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;

                default: // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close(); // Closing scanner
    }
}
