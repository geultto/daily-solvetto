import java.util.*;

class Solution {
    private static int AliceIncome = 0;
    private static boolean[] AliceVisited, BobVisited;
    private static Map<Integer, Integer> BobPath;
    private static ArrayList<ArrayList<Integer>> Graph;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        AliceIncome = Integer.MIN_VALUE; 
        AliceVisited = new boolean[amount.length];
        BobVisited = new boolean[amount.length];
        BobPath = new HashMap<>();
        Graph = new ArrayList<>();

        for (int i = 0; i < amount.length; ++i) {
            Graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            Graph.get(edge[0]).add(edge[1]);
            Graph.get(edge[1]).add(edge[0]);
        }

        dfsBob(bob, 0);
        dfsAlice(0, 0, 0, amount);

        return AliceIncome;
    }

    private void dfsBob(int bob, int depth) {
        BobPath.put(bob, depth);

        if (bob == 0) {
            return;
        }

        BobVisited[bob] = true;
    
        for (int next : Graph.get(bob)) {
            if (BobVisited[next]) continue;
        
            dfsBob(next, depth + 1);
            if (BobPath.containsKey(0)) {
                return;
            }
        }   
    
        BobPath.remove(bob);
    }


    private void dfsAlice(int alice, int aliceVisitedTime, int income, int[] amount) {
        AliceVisited[alice] = true;

        if (!BobPath.containsKey(alice) || aliceVisitedTime < BobPath.get(alice)) {
            income += amount[alice];
        } else if (aliceVisitedTime == BobPath.get(alice)){
            income += amount[alice] / 2;
        }

        if (Graph.get(alice).size() == 1 && alice != 0) {
            AliceIncome = Math.max(AliceIncome, income);
        }

        for (int next : Graph.get(alice)) {
            if (AliceVisited[next]) continue;
            dfsAlice(next, aliceVisitedTime+1, income, amount);
        }
    }
}