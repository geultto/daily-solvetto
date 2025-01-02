class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        TreeMap<Character, Integer> map = new TreeMap<>((a, b) -> b - a);
        for(char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        while(!map.isEmpty()) {
            char cur = map.firstKey();

            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == cur && count == repeatLimit) {
                Character nextChar = map.higherKey(cur);
                if(nextChar == null) break;  // 없다면 종료

                sb.append(nextChar);
                map.merge(nextChar, -1, (old, value) -> old + value == 0 ? null : old + value);
                count = 0;
            } else {
                sb.append(cur);
                map.merge(cur, -1, (old, value) -> old + value == 0 ? null : old + value);
                
                if(sb.length() > 1 && sb.charAt(sb.length()-2) == cur) {
                    count++;
                } else {
                    count = 1;
                }
            }
        }

        return sb.toString();
    }
}