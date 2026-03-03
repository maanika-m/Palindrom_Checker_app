import java.util.Scanner;

public class PalindromCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter a string to check if it is a palindrome: ");
        String original = scanner.nextLine();

        // Check using recursion
        boolean isPalindrome = isPalindromeRecursive(original, 0, original.length() - 1);

        // Display result
        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }

    // Recursive function to check palindrome
    private static boolean isPalindromeRecursive(String str, int start, int end) {
        // Base condition: crossed pointers or single character
        if (start >= end) {
            return true;
        }

        // Compare characters at start and end
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call for the inner substring
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}