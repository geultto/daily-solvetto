import java.util.*;

public class Main {
    private static final int BLANK = 0;
    private static int N = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close(); 

        N = n;

        while (true) {
            boolean isExploded = false;

            for (int start = 0; start < N; ++start) {
                if (arr[start] == 0) {
                    continue;
                }
                int end = getEndIndexOfExplosion(arr, start, arr[start]);

                if (end - start + 1 >= m) {
                    bomb(arr, start, end);
                    isExploded = true;
                }
            }

            if (isExploded) {
                gravity(arr);
            } else {
                break;
            }
        }
        
        System.out.println(N);
        for (int i = 0; i < N; ++i) {
            if (arr[i] != BLANK) {
                System.out.println(arr[i]);
            }
        }
        return;
    }

    private static int getEndIndexOfExplosion(int[] arr, int start, int num) {
        int end = start; 
        for (int i = start + 1; i < N; ++i) {
            if (arr[i] == num) {
                end = i;
            } else {
                break;
            }
        }   
        return end;
    }

    private static void bomb(int[] arr, int start, int end) {
        for (int i = start; i <= end; ++i) {
            arr[i] = BLANK;
        }
    }

    private static void gravity(int[] arr) {
        int count = 0;
        int[] tempArr = new int[N];
        int endOfTempArr = 0;

        for (int i = 0; i < N; ++i) {
            if (arr[i] != BLANK) {
                tempArr[endOfTempArr++] = arr[i];
            }
        }

        N = endOfTempArr;

        for (int i = 0; i < N; ++i) {
            arr[i] = tempArr[i];
        }
    }
}