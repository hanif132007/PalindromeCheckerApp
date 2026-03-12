public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "level";

        // Use the StackStrategy from the previous case
        PalindromeStrategy strategy = new StackStrategy();

        // Capture execution start time
        long startTime = System.nanoTime();

        boolean isPalindrome = strategy.check(input);

        // Capture execution end time
        long endTime = System.nanoTime();

        // Calculate total execution duration
        long duration = endTime - startTime;

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
        System.out.println("Execution Time : " + duration + " ns");
    }
}

// Re-using the structure from UseCase12
interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}