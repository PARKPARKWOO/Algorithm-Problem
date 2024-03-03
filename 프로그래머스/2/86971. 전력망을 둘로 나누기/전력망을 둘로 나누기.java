class Solution {
    private int result;

    public int solution(int n, int[][] wires) {
        int answer = -1;
        result = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            int[] nodes = new int[n + 1];
            recursive(i, wires, nodes);
        }
        return result;
    }

    private void recursive(int idx, int[][] wires, int[] nodes) {
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = i;
        }
        for (int i = 0; i < wires.length; i++) {
            if (i == idx) continue;
            int a = wires[i][0];
            int b = wires[i][1];
            unionParent(a, b, nodes);
        }
        int groupA = findParent(1, nodes); // 첫 번째 노드의 그룹을 기준으로 삼음
        int cntA = 0;
        int cntB = 0;
        for (int j = 1; j < nodes.length; j++) {
            if (findParent(j, nodes) == groupA) cntA++;
            else cntB++;
        }

        result = Math.min(result, Math.abs(cntA - cntB));
    }

    private void unionParent(int a, int b, int[] nodes) {
        a = findParent(a, nodes);
        b = findParent(b, nodes);
        if (a < b) nodes[b] = a;
        else nodes[a] = b;
    }

    private int findParent(int x, int[] nodes) {
        if (nodes[x] == x) {
            return x;
        }
        return nodes[x] = findParent(nodes[x], nodes);
    }
}