package package1;

public class Fibonacci {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Fibonacci <n>");
            return;
        }
        
        int n = Integer.parseInt(args[0]);
        
        if (n < 0) {
            System.out.println("Please provide a non-negative integer.");
            return;
        }
        
        System.out.println("Fibonacci sequence up to " + n + ":");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
    
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
