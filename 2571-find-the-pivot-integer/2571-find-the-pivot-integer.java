class Solution {
    public int pivotInteger(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return index(n, sum, n);
    }
    // num 은 idx 에서 n 까지 합
    private int index(int num, int sum, int idx) {
        if (num > sum) {
            return -1;
        } else if (num < sum) {
            int m = idx - 1;
            return index(num + m, sum - idx, m);
        }
        return idx;
    }
}