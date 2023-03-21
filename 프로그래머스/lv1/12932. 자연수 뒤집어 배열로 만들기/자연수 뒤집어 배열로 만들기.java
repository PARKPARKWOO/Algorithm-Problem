class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder();
        String num = n + "";
        int[] answer = new int[num.length()];
        int j = 0;
        for (int i = num.length()-1; i > -1; i--) {
            answer[j] = Integer.parseInt(num.substring(i, i+1));
            j++;
        }
        return answer;
    }
}