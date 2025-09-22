class Solution {
    int answer;
    public int punishmentNumber(int n) {
        if (n == 1) return 1;
        int n2 = n * n;
        int cnt = 0;
        if (canPunish(n2, n)) {
            cnt = n2;
        }
        return punishmentNumber(n - 1) + cnt;
    }

    private boolean canPunish(int n, int target) {
        if (n < target || target < 0) return false;
        if (n == target) return true;
        return canPunish(n / 10, target - (n % 10)) || canPunish(n / 100, target - (n % 100)) || canPunish(n / 1000, target - (n % 1000));
    }
}