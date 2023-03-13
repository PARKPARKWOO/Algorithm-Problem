class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int error;
        int last_num;
        for (int i = 1; i < 10; i++) {
            error = 0;
            last_num = 0;
            for (int j = 0; j < numbers.length; j++) {
                if (i == numbers[j]){
                    error++;
                    break;
                }
                if (numbers[j] != i){
                    last_num = i;
                }
            }
            if (error == 0){
                answer += last_num;
            }
        }
        return answer;
    }
}