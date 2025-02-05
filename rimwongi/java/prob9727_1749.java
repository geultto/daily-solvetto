class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) 
            return true; 

        int n = s1.length();
        int first = -1, second = -1;

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }

        return second != -1 && 
               s1.charAt(first) == s2.charAt(second) && 
               s1.charAt(second) == s2.charAt(first);
    }
}