import java.util.Scanner;

public class PalindromCheckerApp {

    // Node class for singly linked list
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter a string to check if it is a palindrome: ");
        String original = scanner.nextLine();

        // Convert string to linked list
        Node head = null;
        Node tail = null;
        for (int i = 0; i < original.length(); i++) {
            Node newNode = new Node(original.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Check if linked list is palindrome
        boolean isPalindrome = isPalindromeLinkedList(head);

        // Display result
        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }

    // Function to check palindrome using fast/slow pointer technique
    private static boolean isPalindromeLinkedList(Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;
        Node prevSlow = null;

        // Find middle using fast/slow pointers
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }

        Node secondHalf = slow;
        prevSlow.next = null; // Split list into two halves

        // Reverse second half
        secondHalf = reverseList(secondHalf);

        // Compare first and second half
        Node firstHalf = head;
        Node tempSecond = secondHalf;
        while (firstHalf != null && tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        return true;
    }

    // Function to reverse linked list
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}