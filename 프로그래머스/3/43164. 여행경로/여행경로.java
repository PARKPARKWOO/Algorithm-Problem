import java.util.*;
class Solution {
    private String[] answer;
    private List<String> list;
    private boolean[] v;
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length + 1];
        list = new ArrayList<>();
        v = new boolean[tickets.length + 1];
        dfs("ICN", 0, tickets, "ICN");
        Collections.sort(list);
        return list.get(0).split(" ");
    }
    private void dfs(String start, int depth, String[][] tickets, String now) {
        if (depth == tickets.length) {
            list.add(now);
            return;
        }

        for (int i =0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !v[i]) {
                v[i] = true;
                dfs(tickets[i][1], depth + 1, tickets, now + " " + tickets[i][1]);
                v[i] = false;
            }
        }
    }
}