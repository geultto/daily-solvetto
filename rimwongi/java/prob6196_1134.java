import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] numbers = new int[a];
        for(int i=0; i<a; i++) {
            numbers[i] = sc.nextInt();
        }
        int lcm = findLCM(numbers, numbers.length);
        System.out.println(lcm);
    }

    public static int gcd(int a, int b) {
        if (b == 0) 
            return a;
            
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public static int findLCM(int[] numbers, int n) {
        if (n == 1) 
            return numbers[0];
        return lcm(numbers[n - 1], findLCM(numbers, n - 1));
    } 
}