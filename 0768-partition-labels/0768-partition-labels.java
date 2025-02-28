class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < s.length();) {
            int start = i;
            int end = s.lastIndexOf(s.charAt(i));
            for (int j = start + 1; j < end; j++) {
                int t = s.lastIndexOf(s.charAt(j));
                end = Math.max(end, t);
            }
            answer.add(end - start + 1);
            i = end + 1;
        }
        return answer;
    }
}