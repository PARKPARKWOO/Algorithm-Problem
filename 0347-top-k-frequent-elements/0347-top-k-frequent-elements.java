class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 요소의 값이 얼마나 많이 사용됐고, 최다 빈도수를 나타내는 요소를 k 개 순으로 반환
        // 1. array (nums 요소 값unique 하게 배열로 만들어 count), 2. Map 각 요소의 값을 증가시킨다.
        // 두가지 다 1개의 요소 값을 갱신할때 O(1) 상수 만큼 시간 이 들지만 공간복잡도를 봤을때 최악의 경우 동일 하지만, Map 은 실제 있는 element 만 계산하면 된다 .
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        int[] answer = new int[k];
        int idx = 0;
        for (int i = list.size() - 1; i >= list.size() - k; i--) {
            answer[idx++] = list.get(i).getKey();
        }

        return answer;
    }
}