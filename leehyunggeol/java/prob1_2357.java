import java.util.*;

public class Main {
    static int K = 0, N = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        K = scanner.nextInt();
        N = scanner.nextInt();

        dfs("", 0);
    }

    private static void dfs(String answer, int size) {
        if (size == N) {
            for (int i = 0; i < answer.length(); ++i) {
                System.out.print(answer.charAt(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= K; ++i) {
            dfs(answer + i, size+1);
        }
    }
}