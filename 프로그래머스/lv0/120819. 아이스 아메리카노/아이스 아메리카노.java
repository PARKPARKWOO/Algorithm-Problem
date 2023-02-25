class Solution {
    public int[] solution(int money) {
        int result = money / 5500;
        int ame = money % 5500;
        int[] answer = {result, ame};
        return answer;
    }
}