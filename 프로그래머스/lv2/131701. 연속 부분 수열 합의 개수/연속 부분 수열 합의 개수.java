import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        int[] eleDouble = new int[elements.length * 2];
        for (int i = 0; i < eleDouble.length; i++) {
            eleDouble[i] = elements[i % elements.length];
        }
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                set.add(Arrays.stream(eleDouble, j, j+i).sum());
            }
        }
        return set.size();
    }
}