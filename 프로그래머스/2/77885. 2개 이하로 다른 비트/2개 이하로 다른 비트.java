class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            if (num % 2 == 0) {
                answer[i] = num + 1;
            }else {
                String binaryString = Long.toBinaryString(num);
                int zeroIdx = binaryString.lastIndexOf("0");
                if (zeroIdx != -1) {
                    String s = binaryString.substring(0, zeroIdx) + "10" + binaryString.substring(zeroIdx + 2);
                    answer[i] = Long.parseLong(s, 2);
                } else {
                    String s = "10" + binaryString.substring(1);
                    answer[i] = Long.parseLong(s, 2);
                }
            }
        }
        return answer;
    }
}