class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while (true) {
            answer++;
            int temp1 = (int) Math.ceil((double) a / 2);
            int temp2 = (int) Math.ceil((double) b / 2);
            if (temp1 == temp2) {
                break;
            } else {
                a = (int) Math.ceil((double) a / 2);
                b = (int) Math.ceil((double) b / 2);
            }
        }

        return answer;
    }
}