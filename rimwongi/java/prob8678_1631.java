import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int skill_index = 0;

        ArrayList<String> skill_order = new ArrayList<>();
        for(int i=0; i<skill.length(); i++) {
            skill_order.add(skill.substring(i, i+1));
        }

        for(int i=0; i<skill_trees.length; i++) {
            for(int j=0; j<skill_trees[i].length(); j++) {
                String x = skill_trees[i].substring(j, j+1);
                
                // 포함 안되어 있으면 통과
                if(!skill_order.contains(x)) {
                    if(j == skill_trees[i].length()-1) {
                        answer++;
                        break;
                    }
                    continue;
                }

                // 포함 되어 있으면 순서 체크
                if(skill_order.get(skill_index).equals(x)) { 
                   if(j == skill_trees[i].length()-1) {
                       answer++;
                       break;
                   }
                    skill_index++;
                   continue;
                } else { 
                    break;
                }
            }
            skill_index = 0; 
        }
        
        return answer;
    }
}