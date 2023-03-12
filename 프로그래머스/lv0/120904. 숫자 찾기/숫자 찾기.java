class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        String num_str = num + "";
        if (num_str.indexOf(k+"") < 1000000 && num_str.indexOf(k+"") >= 0){
            answer = num_str.indexOf(k +"") + 1;
        } else {answer = num_str.indexOf(k +"");}
        return answer;
    }
}