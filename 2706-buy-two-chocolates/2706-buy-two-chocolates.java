class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int buy = 0;
        for (int i = 0; i < 2; i++) {
            buy += prices[i];
        }

        if (money < buy) return money;
        
        return money - buy;
    }
}