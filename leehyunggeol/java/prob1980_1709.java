import java.util.*;

class Solution {
    private static int N = 0;
    private static String Answer = "";
    private static Set<String> AlreadyAppeared;

    public String findDifferentBinaryString(String[] nums) {
        N = nums[0].length();
        Answer = "";
        AlreadyAppeared = new HashSet<>(Arrays.asList(nums));

        setUnqueBinaryString("", 0);

        return Answer;
    }

    private void setUnqueBinaryString(String binaryString, int depth) {
        if (Answer.length() != 0) {
            return;
        }
        if (depth == N) {
            if (!AlreadyAppeared.contains(binaryString)) {
                Answer = binaryString;
            }
            return;
        }

        for (int i = 0; i < 2; ++i) {
            setUnqueBinaryString(binaryString+i, depth+1);
        }
    }
}