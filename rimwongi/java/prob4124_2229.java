class Solution {
    public String mergeAlternately(String s1, String s2) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s1.length() || i <s2.length(); i++) {
            if (i < s1.length()) 
                sb.append(s1.charAt(i)); 

            if (i < s2.length()) 
                sb.append(s2.charAt(i)); 
        }

        return sb.toString();
    }
}