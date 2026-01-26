class Solution {
    int[] graph = new int[26];
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for (int i = 0; i < 26; i++) {
            graph[i] = i;
        }
        
        int length =  s1.length();
        for (int i = 0; i < length; i++) {
            int i1 = s1.charAt(i) - 'a';
            int i2 = s2.charAt(i) - 'a';
            union(i1, i2);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            int idx = baseStr.charAt(i) - 'a';
            sb.append(find(idx, idx));
        }        
        return sb.toString();
    }
    
    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            if (pa > pb) {
                graph[pa] = pb;
            } else {
                graph[pb] = pa;
            }
        }
    }

    private int find(int a) {
        if (graph[a] == a) {
            return a;
        }
        return find(graph[a]);
    }

    private char find(int a, int num) {
        num = Math.min(a, num);
        if (graph[a] == a) {
            return (char) (num + 'a');
        }
        return find(graph[a], num);
    }

}