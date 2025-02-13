import java.util.*;

public class Main {
    static int N = 0;
    private static String Answer = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dfs("", 0);

        System.out.println(Answer);
    }

    private static void dfs(String number, int depth) {
        if (Answer.length() != 0 || isNotPossible(number)) {
            return;
        }
        if (depth == N) {
            Answer = number;
            return;
        }

        for (int n = 4; n <= 6; ++n) {
            dfs(number + n, depth+1);
        }
    }

    private static boolean isNotPossible(String number) {
        int n = number.length();

        for (int length = 1; length <= n / 2; ++length) { 
            for (int i = 0; i + 2 * length <= n; ++i) { 
                String first = number.substring(i, i + length);
                String second = number.substring(i + length, i + 2 * length);

                if (first.equals(second)) {
                    return true; 
                }
            }
        }

        return false;
    }
}