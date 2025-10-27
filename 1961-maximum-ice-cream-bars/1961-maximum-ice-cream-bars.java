class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int answer = 0;
        for (int c : costs) {
            if (c <= coins) {
                coins -= c;
                answer++;
            }
        }
        return answer;
    }
}