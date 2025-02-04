class Solution {
    public boolean isAnagram(String s, String t) {
        char[] chararray1 = new char[s.length()];
        char[] chararray2 = new char[t.length()];
        
        for(int i = 0 ; i < s.length() ;i++){
            chararray1[i] = s.charAt(i);
        }
        
        for(int i = 0 ; i < t.length() ;i++){
            chararray2[i] = t.charAt(i);
        }
        
        Arrays.sort(chararray1);
        Arrays.sort(chararray2);
     
        if(Arrays.equals(chararray1, chararray2)){
            return true;
        }
        return false;
    }
}