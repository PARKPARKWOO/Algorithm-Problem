class Solution {
    private int result;
    public int solution(int[] numbers, int target) {
        result = 0;
        dfs(target, 0, numbers, 0);
        return result;
    }
    
    private void dfs(int target, int n, int[] numbers, int idx) {
        if (idx == numbers.length) {
            if (target == n) {
                result++;
            }
            return;
        }
        dfs(target, n + numbers[idx], numbers, idx + 1);
        dfs(target, n - numbers[idx], numbers, idx + 1);
    }
}