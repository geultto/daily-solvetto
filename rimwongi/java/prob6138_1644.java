/**
해피 문자열은 다음과 같은 문자열입니다: 
    ['a', 'b', 'c'] 집합의 문자로만 구성. 
    s[i] != s[i + 1] 1부터 s.length - 1까지의 모든 i 값에 대해(문자열은 1-인덱스). 
예를 들어 문자열 "abc", "ac", "b" 및 "abcbabcbcb"는 모두 해피 문자열
문자열 "aa", "baa" 및 "ababbc"는 해피 문자열이 아님

두 개의 정수 n과 k가 주어졌을 때, 사전적 순서로 정렬된 길이 n의 모든 해피 문자열의 목록을 고려
이 목록의 k번째 문자열을 반환하거나 길이 n의 해피 문자열이 k보다 작으면 빈 문자열을 반환

pseudo code

- 백트래킹
   - 현재 생성된 문자열 cur이 길이 n에 도달하면 result에 추가
   - 현재 문자열의 마지막 문자와 같은 문자는 추가 X
   - 가능한 문자들을 하나씩 추가하며 재귀 호출

- 백트래킹 시작:
   - 빈 문자열로 시작하여 가능한 모든 happy string을 생성

- 결과 처리:
   - 생성된 happy string 리스트 result가 k번째 요소를 포함하면 반환
   - k번째 요소가 없다면 빈 문자열을 반환
 */

class Solution {
    public String getHappyString(int n, int k) {
        List<String> result = new ArrayList<>();
        char[] chars = {'a', 'b', 'c'};

        backtrack(n, new StringBuilder(), result, chars);

        if(k > result.size()) 
            return "";
        return result.get(k-1);
    }

    private void backtrack(int n, StringBuilder curr, List<String> result, char[] chars) {
        if(curr.length()==n) {
            result.add(curr.toString());
            return;
        }

        for (char ch : chars) {
            if (curr.length() == 0 || curr.charAt(curr.length() - 1) != ch) {
                curr.append(ch);
                backtrack(n, curr, result, chars);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
}