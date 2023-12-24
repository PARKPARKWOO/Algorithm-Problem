class Solution {
    private boolean[] v;
    private int result;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        v = new boolean[numbers.length];
        result = 0;
        dfs(numbers, 0, 0, target, numbers.length);
        answer = result;
        System.out.println(answer);
        return answer;
    }

    // 현재 값 k, 끝 end
    private void dfs(int[] numbers, int idx, int k, int target, int end) {
        if (idx > end) return;

        if (idx == end) {
            if (k == target) {
                result++;
            }
            return;
        }

        dfs(numbers, idx + 1, k + numbers[idx], target, end);
        dfs(numbers, idx + 1, k - numbers[idx], target, end);
    }
}