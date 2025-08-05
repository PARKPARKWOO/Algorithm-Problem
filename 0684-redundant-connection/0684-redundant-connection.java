class Solution {
    private int[] answer = new int[2];
    private int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        for (int i = 0; i < edges.length + 1; i++) {
            parent[i] = i;
        }
        
        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            if (getParent(a) == getParent(b)) {
                return edge;
            }
            union(a, b);
        }

        return answer;
    }

    private int getParent(int x) {
        if (parent[x] != x) {
            parent[x] = getParent(parent[x]);
        }
        return parent[x];
    }

    private void union(int a, int b) {
        int pa = getParent(a);
        int pb = getParent(b);
        if (pa != pb) {
            parent[pa] = pb;
        }
    }
}