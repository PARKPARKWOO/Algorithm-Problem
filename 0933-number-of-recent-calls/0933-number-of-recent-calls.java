class RecentCounter {
    int[] requests = new int[10001];
    int idx;
    int offset = 3000;
    int startIdx;
    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        requests[idx++] = t;
        int start = t - offset;
        if (start < 0) start = 0;
        int s = startIdx;
        int e = idx - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            int v = requests[mid];
            if (v > start) {
                e = mid - 1;
                startIdx = mid;
            } else if (v == start) {
                startIdx = mid;
                break;
            } else {
                s = mid + 1;
            }
        }

        return idx - startIdx;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */