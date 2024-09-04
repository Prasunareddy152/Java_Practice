import java.util.Scanner;

public class StringOperationsProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nString Operations Menu:");
            System.out.println("1. Concatenate Strings");
            System.out.println("2. Find Length of a String");
            System.out.println("3. Convert to Uppercase and Lowercase");
            System.out.println("4. Extract Substring");
            System.out.println("5. Split a Sentence");
            System.out.println("6. Reverse a String");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    concatenateStrings(scanner);
                    break;
                case 2:
                    findStringLength(scanner);
                    break;
                case 3:
                    convertToUppercaseLowercase(scanner);
                    break;
                case 4:
                    extractSubstring(scanner);
                    break;
                case 5:
                    splitSentence(scanner);
                    break;
                case 6:
                    reverseString(scanner);
                    break;
                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }

    private static void concatenateStrings(Scanner scanner) {
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        String result = str1.concat(str2);
        System.out.println("Concatenated String: " + result);
    }

    private static void findStringLength(Scanner scanner) {
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();

        int length = input.length();
        System.out.println("Length of the String: " + length);
    }

    private static void convertToUppercaseLowercase(Scanner scanner) {
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();

        String uppercase = input.toUpperCase();
        String lowercase = input.toLowerCase();

        System.out.println("Uppercase: " + uppercase);
        System.out.println("Lowercase: " + lowercase);
    }

    private static void extractSubstring(Scanner scanner) {
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();

        System.out.print("Enter the starting index: ");
        int startIndex = scanner.nextInt();

        System.out.print("Enter the ending index: ");
        int endIndex = scanner.nextInt();

        if (startIndex >= 0 && startIndex < endIndex && endIndex <= input.length()) {
            String substring = input.substring(startIndex, endIndex);
            System.out.println("Extracted Substring: " + substring);
        } else {
            System.out.println("Invalid indices. Please check the input indices.");
        }
    }

    private static void splitSentence(Scanner scanner) {
        System.out.print("Enter the sentence: ");
        String sentence = scanner.nextLine();

        String[] words = sentence.split("\\s+");
        System.out.println("Words in the Sentence:");

        for (String word : words) {
            System.out.println(word);
        }
    }

    private static void reverseString(Scanner scanner) {
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();

        StringBuilder reversed = new StringBuilder(input).reverse();
        System.out.println("Reversed String: " + reversed.toString());
    }
}
