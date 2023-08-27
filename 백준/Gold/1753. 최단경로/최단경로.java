import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
	static class Vertex implements Comparable<Vertex>{
		int e, w;
		public Vertex(int e, int w) {
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
		
	}
	static int V, E, K;
	static int[] dist;
	static ArrayList<Vertex> vertexs[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();
		dist = new int[V + 1];
		vertexs = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			vertexs[i] = new ArrayList<Vertex>();
		}
		
		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int w = sc.nextInt();
			vertexs[s].add(new Vertex(e, w));
		}
		
		dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] v = new boolean[V + 1];

		dijkstra(K);
		for (int i = 1; i < dist.length; i++) {
			if (dist[i]== Integer.MAX_VALUE ) {
				System.out.println("INF");
				continue;
			}
			System.out.println(dist[i]);
		}
	}
	static void dijkstra(int start) {
		PriorityQueue<Vertex> queue = new PriorityQueue<>();
		boolean[] v = new boolean[V + 1];
		queue.add(new Vertex(start, 0));
		dist[start] = 0;
		while (!queue.isEmpty()) {
			Vertex poll = queue.poll();
			int minIdx = poll.e;
			if (v[minIdx] == true) continue;
			v[minIdx] = true;
			for (Vertex next : vertexs[minIdx]) {
				if (dist[next.e] > dist[minIdx] + next.w) {
					dist[next.e] = dist[minIdx] + next.w;
					queue.add(new Vertex(next.e, dist[next.e]));
				}
			}
			
			
		}
	}
}