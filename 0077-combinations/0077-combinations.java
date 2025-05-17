import java.util.*;
class Solution {
    private List<List<Integer>> answer;
    public List<List<Integer>> combine(int n, int k) {
        answer = new ArrayList<>();
        combination(1, k, new ArrayList<>(), n, 0);
        return answer;
    }
    private void combination(int depth, int k, List<Integer> list, int n, int cnt) {
        if (cnt == k) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = depth; i <= n; i++) {
            list.add(i);
            combination(i + 1, k, list, n, cnt + 1);
            list.remove(list.size() - 1);
        }
    }
}