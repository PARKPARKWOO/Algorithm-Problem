class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int tIdx = 0;
        int answer = 0;
        for (int i = 0; i < players.length; i++) {
            for (int j = tIdx; j < trainers.length; j++) {
                if (players[i] <= trainers[j]) {
                    tIdx = j + 1;
                    answer++;
                    
                    break;
                }
            }
        }
        return answer;
    }
}