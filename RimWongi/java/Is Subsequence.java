class Solution {
    /**
    s를 인덱스를 가리키는 포인터 선언
    t의 길이만큼 순회하면서
    포인터가 가리키는 문자가 같다면 s의 포인터를 ++
    순회가 끝날 때까지 s의 포인터가 끝을 가리키지않는다면 false
    그 전에 포인터를 가리키면 true
     */
    public boolean isSubsequence(String s, String t) {
        
        if (s.length() == 0) return true; 

        int pt = 0;
        for(int i = 0; i < t.length(); i++) {
            if(pt < s.length() && s.charAt(pt) == t.charAt(i)) {
                pt++;
            }
            if(pt == s.length()) {
                return true;
            }
        }
        return false;
    }
}