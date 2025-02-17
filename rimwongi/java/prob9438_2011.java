/**
중복 제거 필요할듯? -> set
백트래킹 접근? 그렇다면 시간복잡도 O(n * 2^n) 예상

문자열 -> 배열 변환
중복처리를 위한 정렬
백트래킹으로 모든 시퀀스 생성
    사용하지 않은 문자 접근
    사용되었거나 이전에 같은 문자가 사용되지 않았다면 skip
    현재 문자 사용하고
    현재 문자로 재귀적으로 시퀀스 생성
    백트래킹
고유 시퀀스 갯수 반환
 */
class Solution {

    Set<String> sequences = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars); // AAB
        generateSequence(chars, new boolean[chars.length], new StringBuilder()); // AAB, 3, SB
        return sequences.size();
    }

    private void generateSequence(char[] chars, boolean[] used, StringBuilder curr) {
        
        if(curr.length() > 0) 
            sequences.add(curr.toString()); // 시퀀스 비어있지 않으면 추가하기

        for (int i=0; i<chars.length; i++) {
            if(used[i] || (i>0 && chars[i] == chars[i-1] && !used[i-1]))
                continue;

            used[i] = true;
            curr.append(chars[i]);

            // 재귀 시퀀스
            generateSequence(chars, used, curr);

            // 백트래킹
            used[i] = false;
            curr.setLength(curr.length()-1);
        }
    }
}