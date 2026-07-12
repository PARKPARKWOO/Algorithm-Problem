class Solution {
    int[] answer;
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Server> pq = new PriorityQueue<>();
        // index, 대기시간 
        PriorityQueue<int[]> wq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        answer = new int[tasks.length];
        for (int i = 0; i< servers.length; i++) {
            pq.add(new Server(i, servers[i]));
        }
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(time, i);
            while (!wq.isEmpty() && wq.peek()[1] <= time) {
                int[] w = wq.poll();
                int weight = servers[w[0]];
                pq.add(new Server(w[0], weight));
            }
            
            if (pq.isEmpty()) {
                time = wq.peek()[1];
                while (!wq.isEmpty() && wq.peek()[1] <= time) {
                    int[] w = wq.poll();
                    int weight = servers[w[0]];
                    pq.add(new Server(w[0], weight));
                }
            }
            
            
            Server server = pq.poll();
            answer[i] = server.index;
            int processTime = tasks[i];
            
            wq.add(new int[]{server.index, time + processTime});            
        }
        
        return answer;
    }
}

class Server implements Comparable<Server> {
    int index;
    int weight;
    public Server(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    public int compareTo(Server o) {
        if (o.weight == this.weight) {
            return this.index - o.index;
        }

        return this.weight - o.weight;
    }
}