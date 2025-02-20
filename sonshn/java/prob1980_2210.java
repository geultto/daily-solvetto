/**
[아래 코드는 시간 초과가 난 코드]
P
1. Java에서 2의 거듭제곱(n승): (int) Math.pow(2, n) -> Math.pow는 double을 반환하므로 반드시 int로 형 변환
2. 10진수(a) > 2진수(b): b = Integer.toBinaryString(a);
3. Set을 List로 변환: List<String> remainingList = new ArrayList<>(hashSet);

T
1. Set으로 선언하고 HashSet을 구현해서 사용하자 (정렬 기능 지원 안 됨)
2. Random random = new Random();
   random.nextInt(리스트의 크기 등 정수 값)
 */

import java.util.*;

class Solution {
    Set<String> hashSet = new HashSet<>();

    public void generateBinaryStrings(int length) {
        int power = (int) Math.pow(2, length);
        String binaryString = "";

        for(int i = 0; i < power; i++) {
            binaryString = String.format("%" + length + "s", Integer.toBinaryString(i)).replace(' ', '0');
            hashSet.add(binaryString);
        }
    }

    public String findDifferentBinaryString(String[] nums) {
        int length = nums[0].length();

        generateBinaryStrings(length);

        for(int i=0; i<nums.length; i++) {
            if(hashSet.contains(nums[i])) {
                hashSet.remove(nums[i]);
            }
        }

        List<String> remainingList = new ArrayList<>(hashSet);
        Random random = new Random();

        return remainingList.get(random.nextInt(remainingList.size()));
    }
}