import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class FileOperationsProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nFile Operations Menu:");
            System.out.println("1. Create a new directory");
            System.out.println("2. Create a new text file and write content to it");
            System.out.println("3. Read the content from an existing text file");
            System.out.println("4. Append new content to an existing text file");
            System.out.println("5. Copy content from one text file to another");
            System.out.println("6. Delete a text file");
            System.out.println("7. List all files and directories in a given directory");
            System.out.println("8. Search for a specific file in a directory and its subdirectories");
            System.out.println("9. Rename a file");
            System.out.println("10. Get information about a file");
            System.out.println("11. Exit");
            System.out.print("Enter your choice (1-11): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createNewDirectory(scanner);
                    break;
                case 2:
                    createAndWriteToFile(scanner);
                    break;
                case 3:
                    readFromFile(scanner);
                    break;
                case 4:
                    appendToFile(scanner);
                    break;
                case 5:
                    copyFile(scanner);
                    break;
                case 6:
                    deleteFile(scanner);
                    break;
                case 7:
                    listFilesAndDirectories(scanner);
                    break;
                case 8:
                    searchFile(scanner);
                    break;
                case 9:
                    renameFile(scanner);
                    break;
                case 10:
                    getFileInfo(scanner);
                    break;
                case 11:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 11.");
            }
        }
    }

    private static void createNewDirectory(Scanner scanner) {
        System.out.print("Enter the directory name: ");
        String directoryName = scanner.nextLine();

        try {
            Files.createDirectory(Paths.get(directoryName));
            System.out.println("Directory created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating directory: " + e.getMessage());
        }
    }

    private static void createAndWriteToFile(Scanner scanner) {
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        System.out.print("Enter the content to write to the file: ");
        String content = scanner.nextLine();

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(content);
            System.out.println("Content written to the file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    private static void readFromFile(Scanner scanner) {
        System.out.print("Enter the file name to read: ");
        String fileName = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Content of the file:");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from the file: " + e.getMessage());
        }
    }

    private static void appendToFile(Scanner scanner) {
        System.out.print("Enter the file name to append: ");
        String fileName = scanner.nextLine();

        System.out.print("Enter the content to append to the file: ");
        String content = scanner.nextLine();

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(content);
            System.out.println("Content appended to the file successfully.");
        } catch (IOException e) {
            System.out.println("Error appending to the file: " + e.getMessage());
        }
    }

    private static void copyFile(Scanner scanner) {
        System.out.print("Enter the source file name: ");
        String sourceFileName = scanner.nextLine();

        System.out.print("Enter the destination file name: ");
        String destinationFileName = scanner.nextLine();

        try {
            Files.copy(Paths.get(sourceFileName), Paths.get(destinationFileName), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("Error copying the file: " + e.getMessage());
        }
    }

    private static void deleteFile(Scanner scanner) {
        System.out.print("Enter the file name to delete: ");
        String fileName = scanner.nextLine();

        try {
            Files.delete(Paths.get(fileName));
            System.out.println("File deleted successfully.");
        } catch (IOException e) {
            System.out.println("Error deleting the file: " + e.getMessage());
        }
    }

    private static void listFilesAndDirectories(Scanner scanner) {
        System.out.print("Enter the directory name: ");
        String directoryName = scanner.nextLine();

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directoryName))) {
            System.out.println("Files and directories in the specified directory:");

            for (Path path : directoryStream) {
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            System.out.println("Error listing files and directories: " + e.getMessage());
        }
    }

    private static void searchFile(Scanner scanner) {
        System.out.print("Enter the directory to search in: ");
        String directoryName = scanner.nextLine();

        System.out.print("Enter the file name to search: ");
        String fileName = scanner.nextLine();

        try {
            Path filePath = Files.walk(Paths.get(directoryName))
                    .filter(path -> path.getFileName().toString().equals(fileName))
                    .findFirst()
                    .orElse(null);

            if (filePath != null) {
                System.out.println("File found at: " + filePath);
            } else {
                System.out.println("File not found in the specified directory and its subdirectories.");
            }
        } catch (IOException e) {
            System.out.println("Error searching for the file: " + e.getMessage());
        }
    }

    private static void renameFile(Scanner scanner) {
        System.out.print("Enter the current file name: ");
        String currentFileName = scanner.nextLine();

        System.out.print("Enter the new file name: ");
        String newFileName = scanner.nextLine();

        try {
            Files.move(Paths.get(currentFileName), Paths.get(newFileName), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File renamed successfully.");
        } catch (IOException e) {
            System.out.println("Error renaming the file: " + e.getMessage());
        }
    }

    private static void getFileInfo(Scanner scanner) {
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        try {
            Path filePath = Paths.get(fileName);
            BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);

            System.out.println("File Information:");
           
