import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string to check palindrome performance: ");
        String input = scanner.nextLine();

        // --- UC3: String Reverse ---
        long startTime = System.nanoTime();
        boolean uc3 = checkPalindromeReverse(input);
        long endTime = System.nanoTime();
        System.out.println("UC3 (String Reverse): " + uc3 + " | Time: " + (endTime - startTime) + " ns");

        // --- UC4: Character Array ---
        startTime = System.nanoTime();
        boolean uc4 = checkPalindromeCharArray(input);
        endTime = System.nanoTime();
        System.out.println("UC4 (Char Array Two-Pointer): " + uc4 + " | Time: " + (endTime - startTime) + " ns");

        // --- UC5: Stack ---
        startTime = System.nanoTime();
        boolean uc5 = checkPalindromeStack(input);
        endTime = System.nanoTime();
        System.out.println("UC5 (Stack): " + uc5 + " | Time: " + (endTime - startTime) + " ns");

        // --- UC6: Queue + Stack ---
        startTime = System.nanoTime();
        boolean uc6 = checkPalindromeQueueStack(input);
        endTime = System.nanoTime();
        System.out.println("UC6 (Queue + Stack): " + uc6 + " | Time: " + (endTime - startTime) + " ns");

        // --- UC7: Deque ---
        startTime = System.nanoTime();
        boolean uc7 = checkPalindromeDeque(input);
        endTime = System.nanoTime();
        System.out.println("UC7 (Deque): " + uc7 + " | Time: " + (endTime - startTime) + " ns");

        // --- UC10: Case-insensitive & spaces ignored ---
        startTime = System.nanoTime();
        boolean uc10 = checkPalindromeNormalized(input);
        endTime = System.nanoTime();
        System.out.println("UC10 (Normalized Case/Spaces): " + uc10 + " | Time: " + (endTime - startTime) + " ns");

        scanner.close();
    }

    // UC3: Reverse string
    private static boolean checkPalindromeReverse(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return str.equals(reversed);
    }

    // UC4: Char array two-pointer
    private static boolean checkPalindromeCharArray(String str) {
        char[] chars = str.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    // UC5: Stack
    private static boolean checkPalindromeStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) stack.push(str.charAt(i));
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop()) return false;
        }
        return true;
    }

    // UC6: Queue + Stack
    private static boolean checkPalindromeQueueStack(String str) {
        Deque<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            queue.addLast(str.charAt(i));
            stack.push(str.charAt(i));
        }
        while (!queue.isEmpty()) {
            if (queue.removeFirst() != stack.pop()) return false;
        }
        return true;
    }

    // UC7: Deque
    private static boolean checkPalindromeDeque(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) deque.addLast(str.charAt(i));
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    // UC10: Normalized (case-insensitive, spaces ignored)
    private static boolean checkPalindromeNormalized(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        int start = 0, end = normalized.length() - 1;
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}