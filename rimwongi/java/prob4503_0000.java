class Solution {
    static final String alpha = "AEIOU";
    static final int [] cipher = {781, 156, 31, 6 ,1};
    
    public int solution(String word) {
        int answer = word.length();
        for(int i=0; i<word.length(); i++){
            answer += (cipher[i] * alpha.indexOf(word.charAt(i)));
        }
        return answer;
    }
}