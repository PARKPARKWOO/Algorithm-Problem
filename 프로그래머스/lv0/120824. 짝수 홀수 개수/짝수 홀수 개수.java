class Solution {
    public int[] solution(int[] num_list) {
        int jjack = 0;
        int hole = 0;
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0){
                jjack += 1;
            }else {hole += 1;}
        }
        int[] answer = {jjack, hole};
        return answer;
    }
}