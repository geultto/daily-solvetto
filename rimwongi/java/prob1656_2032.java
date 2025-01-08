import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], i);
        }

        int total = 0;
        for(int i = 0; i < number.length; i++) {
            total += number[i];
        }
        int ptr1 = 0;
        int ptr2 = total-1;

        int[] saleNum = new int[number.length];
        for(int i = 0; i < total; i++) {
            if(map.containsKey(discount[i])) {
                saleNum[map.get(discount[i])]++;
            }
        }
        while(true) {
           if(checkMatch(number, saleNum))
               answer++;

            if(map.containsKey(discount[ptr1])) {
                saleNum[map.get(discount[ptr1])]--;
            }

           ptr1++;
           ptr2++;

            if(ptr2 == discount.length)
                break;

            if(map.containsKey(discount[ptr2])) {
                saleNum[map.get(discount[ptr2])]++;
            }
        }
        return answer;
    }

    Boolean checkMatch(int[] number, int[] saleNum) {
        for(int i = 0; i < number.length; i++) {
            if(number[i]>saleNum[i])
                return false;
        }
        return true;
    }
}