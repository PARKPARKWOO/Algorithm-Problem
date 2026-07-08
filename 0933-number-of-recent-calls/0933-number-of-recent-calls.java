class RecentCounter {
    private int[] request;
    private int idx;
    private int start;
    public RecentCounter() {
        this.request = new int[10000];
    }
    
    public int ping(int t) {
        request[idx++] = t;
        int end = idx;    
        int cnt = 0;
        int range = t - 3000;
        for (int i = start; i < end; i++) {
            if (request[i] >= range && request[i] <= t) {
                break;
            } else {
                start++;
            }
        }
    
        return end - start;
    }
    
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */