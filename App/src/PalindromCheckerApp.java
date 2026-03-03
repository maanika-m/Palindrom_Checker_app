import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

// Main class
public class PalindromCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter a string to check if it is a palindrome: ");
        String input = scanner.nextLine();

        // Choose strategy
        System.out.println("Choose Palindrome Strategy:");
        System.out.println("1. Stack-based");
        System.out.println("2. Deque-based");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else if (choice == 2) {
            strategy = new DequeStrategy();
        } else {
            System.out.println("Invalid choice. Defaulting to Stack strategy.");
            strategy = new StackStrategy();
        }

        // Inject strategy and check palindrome
        PalindromeService service = new PalindromeService(strategy);
        boolean isPalindrome = service.check(input);

        // Display result
        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome (Strategy Pattern).");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome (Strategy Pattern).");
        }

        scanner.close();
    }
}

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String str);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            deque.addLast(str.charAt(i));
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// PalindromeService that injects strategy
class PalindromeService {
    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String str) {
        return strategy.isPalindrome(str);
    }
}