class Solution {
    public int solution(int order) {
        int answer = 0;
        String order_str = order +"";
        for (int i = 0; i < order_str.length(); i++) {
            int num = order_str.charAt(i) - 48;
            if (num == 3 || num == 6 || num == 9){
                answer += 1;
            }
        }
        return answer;
    }
}