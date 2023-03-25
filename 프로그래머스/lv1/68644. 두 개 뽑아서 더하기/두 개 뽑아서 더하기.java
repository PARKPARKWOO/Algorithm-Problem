import java.util.HashSet;
class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                hashSet.add(numbers[i] + numbers[j]);
            }
        }
        return hashSet.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}