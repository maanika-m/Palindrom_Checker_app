import java.util.Scanner;

public class PalindromCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter a string to check if it is a palindrome: ");
        String input = scanner.nextLine();

        // Normalize string: remove spaces and convert to lower case
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Two-pointer palindrome check
        boolean isPalindrome = true;
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome (case-insensitive, spaces ignored).");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome (case-insensitive, spaces ignored).");
        }

        scanner.close();
    }
}