class Solution {
    public int[] solution(int[] sequence, int k) {
        int end = 0;
        int cnt = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE;
        int last = Integer.MAX_VALUE;
        int sum = 0;
        for (int start = 0; start < sequence.length; start++) {
            while (end < sequence.length && sum < k){
                sum += sequence[end++];
            }
            if (sum == k) {
                if ((end - start - 1) < cnt) {
                    cnt = Math.min(cnt, end - start - 1);
                    first = start;
                    last = end - 1;
                }
            }
            sum -= sequence[start];
        }
        int[] answer = new int[]{first, last};
        return answer;
    }
}