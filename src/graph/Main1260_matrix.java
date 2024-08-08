package graph;

import java.io.*;
import java.util.*;

public class Main1260_matrix {
	static StringBuffer sb = new StringBuffer();
	static Scanner sc = new Scanner(System.in);
	
	static int N, M, V;
	static int[][] adj;
	static boolean[] visit;
	
	public static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		adj = new int[N + 1][N + 1];
		for(int i = 0; i < M; i++) {
			int x = sc.nextInt(), y = sc.nextInt();
			adj[x][y] = adj[y][x] = 1;
		}
	}
	
	static void dfs(int x) {
		visit[x] = true;
		sb.append(x).append(' ');
		
		for(int y = 1; y <= N; y++) {
			if (adj[x][y] == 0) continue;
			if (visit[y]) continue;
			
			dfs(y);
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(start);
		visit[start] = true;
		
		while (!que.isEmpty()) {
			int x = que.poll();
			
			sb.append(x).append(' ');
			for(int y = 1; y <= N; y++) {
				if (adj[x][y] == 0) continue;
				if (visit[y]) continue;
				
				que.add(y);
				visit[y] = true;
			}
		}
	}

	public static void pro() {
		visit = new boolean[N + 1];
		dfs(V);
		sb.append('\n');
		for(int i = 1; i <= N; i++) visit[i] = false;
		bfs(V);
		System.out.println(sb.toString());
	}
	
	public static void main(String args[]) {
		input();
		pro();
		
	}
}