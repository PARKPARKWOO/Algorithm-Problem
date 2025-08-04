import java.util.Arrays;

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        // 1. 각 도시의 연결 수(degree)를 저장할 배열을 생성합니다.
        // 도시 번호가 0부터 n-1까지이므로 배열을 사용하는 것이 효율적입니다.
        long[] degree = new long[n];

        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        // 2. 연결 수 배열을 오름차순으로 정렬합니다.
        // 이제 degree[0]는 가장 연결이 적은 도시의 연결 수,
        // degree[n-1]은 가장 연결이 많은 도시의 연결 수가 됩니다.
        Arrays.sort(degree);

        long totalImportance = 0;
        // 3. 중요도를 1부터 n까지 할당하며 총합을 계산합니다.
        // 연결 수가 가장 적은 도시(degree[0])에 중요도 1을,
        // 두 번째로 적은 도시(degree[1])에 중요도 2를...
        // 가장 많은 도시(degree[n-1])에 중요도 n을 곱해 더합니다.
        for (int i = 0; i < n; i++) {
            // degree[i]는 i번째로 연결이 적은 도시의 연결 수
            // (long)(i + 1)은 할당될 중요도 (1부터 시작)
            totalImportance += degree[i] * (long)(i + 1);
        }

        return totalImportance;
    }
}