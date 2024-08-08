package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1260_list {
	static StringBuilder sb = new StringBuilder();
	static Scanner sc = new Scanner(System.in);
	
	static int N, M, V;
	static ArrayList<Integer>[] adj;
	static boolean[] visit;
	
	static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		adj = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) adj[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			int x = sc.nextInt(), y = sc.nextInt();
			
			adj[x].add(y);
			adj[y].add(x);
		}
		
		for(int i = 1; i <= N; i++) Collections.sort(adj[i]);
	}
	
	static void dfs(int x) {
		visit[x] = true;
		
		sb.append(x).append(' ');
		
		for(int y: adj[x]) {
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
			
			for(int y : adj[x]) {
				if (visit[y]) continue;
				
				que.add(y);
				visit[y] = true;
			}
		}
	}
	
	static void pro() {
		visit = new boolean[N + 1];
		
		dfs(V);
		for(int i = 1; i <= N; i++) visit[i] = false;
		sb.append('\n');
		bfs(V);
		
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		input();
		pro();
	}
	

}
