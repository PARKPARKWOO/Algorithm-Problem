class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] answer = new int[tasks.length];
        PriorityQueue<Server> worker = new PriorityQueue<>();
        PriorityQueue<long[]> wait = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0])); // 0 이 시간 1인덱스
        for (int i = 0; i < servers.length; i++) {
            worker.add(new Server(i, servers[i]));
        } 
        long time = 0;
        for (int i = 0; i < tasks.length; i++) {
            int t = tasks[i];
            time = Math.max(time, i);
            
                while (!wait.isEmpty() && wait.peek()[0] <= time) {
                    long[] w = wait.poll();       
                    worker.add(new Server((int)w[1], servers[(int) w[1]]));
                }
            
            
            if (worker.isEmpty()) {
                time = wait.peek()[0];
                while (!wait.isEmpty() && wait.peek()[0] <= time) {
                    long[] w = wait.poll();       
                    worker.add(new Server((int)w[1], servers[(int)w[1]]));
                }
            }
            Server server = worker.poll();
            answer[i] = server.index;
            wait.add(new long[]{t + time, server.index});
        }
        return answer;
    }
}

class Server implements Comparable<Server>{
    int index;
    int weight;
    
    public Server(int idx, int weight) {
        this.index = idx;
        this.weight = weight;
    }

    public int compareTo(Server s) {
        if (this.weight == s.weight) {
            return this.index - s.index; 
        }
        
        return this.weight - s.weight;
    }
}