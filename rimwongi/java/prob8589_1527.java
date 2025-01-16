class Solution {
    /**
    애너그램은 정렬하게 되면 알 수 있다.
    애너그램 결과를 보관하는 맵 선언<String, List<String>>
    strs에 하나씩 접근 
    Key값이 없다면 Map에넣고
    이미 있는값이라면 strs를 value에 넣는다.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            
            String key = String.valueOf(ch);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}