import java.util.*;

public class Main {
    static int Answer = Integer.MIN_VALUE;
    static char[] Arr;
    static int[] Nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String expression = sc.nextLine();
        
        Arr = expression.toCharArray();
        Nums = new int[6];

        dfs(0);

        System.out.println(Answer);
    }

    private static void dfs(int size) {
        if (size == 6) {            
            Answer = Math.max(Answer, calculate());
            return;
        }

        for (int i = 1; i <= 4; ++i) {
            Nums[size] = i;
            dfs(size+1);
            Nums[size] = 0;
        }
    }

    private static int calculate() {
        int result = Nums[Arr[0]-'a'];

        for (int i = 1; i < Arr.length; i += 2) {
            if (Arr[i] == '+') {
                result += Nums[Arr[i+1]-'a'];
            } else if (Arr[i] == '-') {
                result -= Nums[Arr[i+1]-'a'];
            } else if (Arr[i] == '*') {
                result *= Nums[Arr[i+1]-'a'];
            }
        }

        return result;
    }
}