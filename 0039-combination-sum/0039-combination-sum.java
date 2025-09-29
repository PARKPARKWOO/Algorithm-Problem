class Solution {
    private List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        getResult(target, candidates, new ArrayList<>(), 0, 0);
        return answer;
    }

    private void getResult(int target, int[] candidate, List<Integer> list, int now, int idx) {
        if (now == target) {
            answer.add(new ArrayList<>(list));
            return;
        } else if (now > target) {
            return;
        }

        for (int i = idx; i < candidate.length; i++) {
            int sum = now + candidate[i];
            if (sum <= target) {
                list.add(candidate[i]);
                getResult(target, candidate, list, sum, i);
                list.remove(list.size() - 1);
            }
        }
    }
}