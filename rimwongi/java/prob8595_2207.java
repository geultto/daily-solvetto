/**
빨간색과 파란색 타일의 원이 있습니다. 
정수 색상과 정수 k가 주어집니다.
 타일 ​​I의 색상은 색상 [i] : 색상 [i] == 0으로 표시됩니다.
  타일 I은 빨간색임을 의미합니다. 색상 [i] == 1은 타일 i가 파란색임을 의미합니다.
   교대 그룹은 원의 모든 k 연속 타일입니다 (첫 번째 및 마지막 및 마지막 타일을 제외한 그룹의 각 타일은 왼쪽 및 오른쪽 타일과 다른 색상을 갖습니다). 
   교대 그룹의 수를 반환
 */

class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int w = 1;
        int answer = 0;
        int n = colors.length; 
        
        for (int i = 1; i <= n+k-2; i++) {
            if (colors[i % n] != colors[(i - 1 + n) % n])
                w++;
            else 
                w = 1;
            if (w >= k) 
                answer++;
        }
        return answer;   
    }
}