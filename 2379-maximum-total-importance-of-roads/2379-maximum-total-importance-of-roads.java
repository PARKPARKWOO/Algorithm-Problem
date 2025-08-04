class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long answer = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        
        // 각 노드의 연결 횟수 계산
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            counter.put(a, counter.getOrDefault(a, 0) + 1);
            counter.put(b, counter.getOrDefault(b, 0) + 1);
        }
        
        // 모든 노드(0부터 n-1까지)를 연결 횟수로 정렬
        List<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(i);
        }
        nodes.sort((a, b) -> counter.getOrDefault(b, 0) - counter.getOrDefault(a, 0));
        
        // 가장 많이 연결된 노드부터 높은 값 할당
        Map<Integer, Integer> nodeValues = new HashMap<>();
        for (int i = 0; i < nodes.size(); i++) {
            nodeValues.put(nodes.get(i), n - i);
        }
        
        // 각 도로의 중요도 합계 계산
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            answer += nodeValues.get(a) + nodeValues.get(b);
        }
        
        return answer;
    }
}