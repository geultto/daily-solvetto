class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }


        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c-'a']++;
        }

        int odds = 0;
        for (int i = 0 ;i < 26;i++) {
            int count = counts[i];
            if ( count % 2 ==0 ) {
                continue;
            }
            odds++;
        }

        if (odds > k) {
            return false;
        }

        return true;
    }
}