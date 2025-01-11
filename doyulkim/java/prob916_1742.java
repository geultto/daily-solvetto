class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] maxCount = new int[26];
        for (String b : B ){
            int[] bCount = new int[26];
            for (char c : b.toCharArray()) {
                bCount[c - 'a']++;
            }
            for (int i = 0; i< 26; i++) {
                maxCount[i] = Math.max(maxCount[i], bCount[i]);
            }
        }

        List<String> ans = new ArrayList();
        for (String a: A) {
            boolean isValid = true;
            int[] aCount = new int[26];
            for (char c: a.toCharArray()) {
                aCount[c - 'a']++;
            }

            for (int i = 0; i < 26; ++i) {
                if (aCount[i] < maxCount[i]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                ans.add(a);
            }
        }
        return ans;

        
    }
}