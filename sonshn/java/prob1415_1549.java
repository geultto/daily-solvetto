import java.util.*;

class Solution {
    HashMap<Integer, String> hashMap = new HashMap<>();
    int count = 1;

    public void generateHappyStrings(int n, String currentString) {
        // 몇 번째 Happy String 인지를 표시하기 위해 count 변수를 활용해 Key를 만들어 HashMap에 저장
        if(currentString.length() == n) {
            hashMap.put(count++, currentString);
            return;
        }

        // a 부터 c 까지 for문 돌리면서 if 조건문으로 's[i] != s[i + 1]' 되게끔 처리
        for (char currentChar = 'a'; currentChar <= 'c'; currentChar++) {
            if (
                currentString.length() > 0 &&
                currentString.charAt(currentString.length() - 1) == currentChar
            ) continue;

            // currentString + currentChar 처럼 문자열과 문자 바로 더하기
            generateHappyStrings(n, currentString + currentChar);
        }
    }

    public String getHappyString(int n, int k) {
        String currentString = "";

        generateHappyStrings(n, currentString);

        if(hashMap.size() < k) {
            return "";
        }
        
        return hashMap.get(k);
    }
}