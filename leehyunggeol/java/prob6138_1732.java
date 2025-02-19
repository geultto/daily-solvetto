import java.util.*;

class Solution {
    static char[] Letters = {'a', 'b', 'c'};
    static int TotalCount;
    static String Answer;

    public String getHappyString(int n, int k) {
        TotalCount = 0;
        Answer = "";

        dfs("",0,n,k);

        if (TotalCount < k) {
            Answer = "";
        }

        return Answer;
    }

    private void dfs(String happyString, int length, int n, int k) {
        if (TotalCount == k) {
            return;
        }
        if (length == n) {
            ++TotalCount;
            Answer = happyString;
            return;
        }

        for (int i = 0; i < 3; ++i) {
            if (happyString.length() != 0 && happyString.charAt(happyString.length()-1) == Letters[i]) continue; 
            dfs(happyString+Letters[i], length+1, n, k);
        }
    }
}