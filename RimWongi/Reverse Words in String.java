class Solution {
    /**
     */
    public String reverseWords(String s) {
        String temp = s.trim();
        String[] arr = temp.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i=arr.length-1; i>=0; i--) {
            String str = arr[i];
            if (str.isBlank()) continue;

            sb.append(str);
            if(i!=0) sb.append(" ");
        }
        return sb.toString();
    }
}