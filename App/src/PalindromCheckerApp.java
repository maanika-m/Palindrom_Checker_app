import java.util.Scanner;
import java.util.Stack;

public class PalindromCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter a string to check if it is a palindrome: ");
        String input = scanner.nextLine();

        // Create PalindromeChecker instance
        PalindromeChecker checker = new PalindromeChecker();

        // Check if palindrome
        boolean isPalindrome = checker.checkPalindrome(input);

        // Display result
        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome (using OOP service).");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome (using OOP service).");
        }

        scanner.close();
    }
}

// Encapsulated Palindrome logic
class PalindromeChecker {

    // Method to check palindrome using stack
    public boolean checkPalindrome(String str) {
        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // Pop and compare
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}