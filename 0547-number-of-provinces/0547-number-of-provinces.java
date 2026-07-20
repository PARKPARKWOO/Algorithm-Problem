class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int[] parent;
    int[] size;
    boolean[] v;
    int answer = 0;
    public int findCircleNum(int[][] isConnected) {
        parent = new int[isConnected.length];
        size = new int[isConnected.length];
        v = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i <isConnected.length; i++) {
            int[] c = isConnected[i];
            parent[i] = i;    
            for (int j = 0; j <c.length; j++) {
                if (j == i || c[j] == 0) continue;
            
                graph.get(i).add(j);
            }
        }
        for (int i = 0; i < graph.size(); i++) {
            if (!v[i]){
                bfs(i, isConnected);
            }
        }
        
        return answer;   
    }
    
    void bfs(int x, int[][] isCon) {
        v[x] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        answer++;
        while (!q.isEmpty()) {
            int poll = q.poll();
            List<Integer> list = graph.get(poll);
            for (int i = 0; i <list.size(); i++) {
                int get = list.get(i);
                if (!v[get]){
                    v[get] =true;
                    q.add(get);
                }
            }
        }
    }

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x];
    }

    void union(int a, int b) {
        int aP = find(a);
        int bP = find(b);
        
        if (size[aP] < size[bP]) {
            
        }
    }
}