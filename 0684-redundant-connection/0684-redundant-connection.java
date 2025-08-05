class Solution {
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            // 이미 같은 집합이라면 이 간선이 사이클을 만드는 중복 간선
            if (find(u) == find(v)) {
                return edge;
            }
            // 아니면 두 집합 합치기
            union(u, v);
        }
        return new int[0]; // 문제 조건상 여기로 안 옵니다.
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb) {
            parent[pb] = pa;
        }
    }
}
