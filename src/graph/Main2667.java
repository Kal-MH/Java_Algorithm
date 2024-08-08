package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2667 {
	static Scanner scan = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	
	static int N, group_cnt;
	static String[] a;
	static boolean[][] visit;
	static ArrayList<Integer> group;
	static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
	
	static void input() {
		N = scan.nextInt();
		
		a = new String[N];
		for(int i = 0; i < N; i++) a[i] = scan.next();
		
		visit = new boolean[N][N];
	}
	
	public static void dfs(int x, int y) {
		visit[x][y] = true;
		group_cnt++;
		
		for(int k = 0; k < 4; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if (a[nx].charAt(ny) == '0') continue;
			if (visit[nx][ny]) continue;
			
			dfs(nx, ny);
		}
	}
	
	static void pro() {
		group = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (!visit[i][j] && a[i].charAt(j) == '1') {
					group_cnt = 0;
					dfs(i, j);
					group.add(group_cnt);
				}
			}
		}
		
		sb.append(group.size()).append('\n');
		
		Collections.sort(group);
		for(int cnt: group) sb.append(cnt).append('\n');
		
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
