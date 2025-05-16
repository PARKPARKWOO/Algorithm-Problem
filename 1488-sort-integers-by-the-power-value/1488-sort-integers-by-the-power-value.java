import java.util.*;
class Solution {
    private int[] dp;
    public int getKth(int lo, int hi, int k) {
        dp = new int[(hi * 3) + 1];
        int size = hi - lo + 1;
        Map<Integer, Integer> map = new HashMap<>();
        Nodes[] result = new Nodes[size];
        for (int i = lo; i <= hi; i++) {
            int num = power(i, 0);
            Nodes node = new Nodes(i, num);
            result[i - lo] = node;
        }
        Arrays.sort(result);
        return result[k - 1].idx;
    }

    private int power(int num, int cnt) {
        if (num == 1) {
            return cnt;
        }
        if (num % 2 == 0) {
            return power(num / 2, cnt + 1); 
        } else {
            return power((num * 3) + 1, cnt + 1);
        }
    }
}

class Nodes implements Comparable<Nodes>{
    int idx;
    int num;
    public Nodes(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }
    public int compareTo(Nodes o) {
        return this.num - o.num;
    }
}