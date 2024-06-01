import java.util.*;

class Solution {
    private List<List<Integer>> graph;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        
        // 목적지에서 모든 노드까지의 최단 거리를 계산
        int[] distances = bfsFromDestination(n, destination);
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = distances[sources[i]];
        }
        
        return answer;
    }
    
    private int[] bfsFromDestination(int n, int destination) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        distances[destination] = 0;
        
        while (!q.isEmpty()) {
            int current = q.poll();
            int currentDistance = distances[current];
            
            for (int neighbor : graph.get(current)) {
                if (distances[neighbor] == -1) { // 방문하지 않은 노드
                    distances[neighbor] = currentDistance + 1;
                    q.add(neighbor);
                }
            }
        }
        
        return distances;
    }

}
