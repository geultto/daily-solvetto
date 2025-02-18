/**
증가를 의미하는 문자 'I'와 감소를 의미하는 문자 'D'로 구성된 길이 n의 0 인덱스 문자열 패턴이 주어집니다.
다음 조건을 사용하여 길이 n + 1의 0 인덱스 문자열 num을 생성합니다: 
    num은 '1'에서 '9'의 숫자로 구성되며, 각 숫자는 최대 한 번만 사용
    pattern[i] == 'I'이면 num[i] < num[i + 1]. 
    pattern[i] == 'D'이면 num[i] > num[i + 1]. 
    조건을 충족하는 사전적으로 가능한 가장 작은 문자열 num을 반환
 */
class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder answer = new StringBuilder("1");
        StringBuilder temp = new StringBuilder();
        
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'I') {
                answer.append(temp).append((char)('2' + i));
                temp.setLength(0);
            } else {
                temp.insert(0, answer.charAt(answer.length() - 1));
                answer.setLength(answer.length() - 1);
                answer.append((char)('2' + i));
            }
        }
        return answer.append(temp).toString();
    }
}