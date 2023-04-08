class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] month = new int[]{31, 29, 31 , 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int temp = 0;
        String[] week = new String[]{"FRI","SAT","SUN","MON","TUE","WED","THU"};
        for (int i = 0; i < a - 1; i++) {
            temp += month[i];
        }
        temp += b - 1;
        answer = week[temp % 7];
        return answer;
    }
}