package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class State {
	int[] X;
	State(int[] _X) {
		X = new int[3];
		for(int i = 0; i < 3; i++) X[i] = _X[i];
	}
	
	State move(int from, int to, int[] Limit) {
		int[] nX = new int[]{X[0], X[1], X[2]};
		
		if (X[from] + X[to] <= Limit[to]) {
			nX[to] = X[from] + X[to];
			nX[from] = 0;
		} else {
			nX[to] = Limit[to];
			nX[from] -= (Limit[to] - X[to]);
		}
		
		return new State(nX);
	}
}

public class Main2251 {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	
	static int[] Limit;
	static boolean[] possible;
	static boolean[][][] visit;
	
	static void input() {
		Limit = new int[3];
		for(int i = 0; i < 3; i++) Limit[i] = sc.nextInt();
		visit = new boolean[205][205][205];
		possible = new boolean[205];
	}
	
	static void bfs(int x1, int x2, int x3) {
		Queue<State> q = new LinkedList<State>();
		
		q.add(new State(new int[] {x1, x2, x3}));
		visit[x1][x2][x3] = true;
		
		while (!q.isEmpty()) {
			State st = q.poll();
			
			if (st.X[0] == 0) possible[st.X[2]] = true;
			
			for(int from = 0; from < 3; from++) {
				for(int to = 0; to < 3; to++) {
					if (from == to) continue;
					
					State nxt = st.move(from, to, Limit);
					
					if (visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) continue;
					
					visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
					q.add(nxt);
				}
			}
			
		}
	}
	
	static void pro() {
		bfs(0, 0, Limit[2]);
		
		for(int i = 0; i <= 200; i++) {
			if (possible[i]) sb.append(i).append(' ');
		}
		
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
