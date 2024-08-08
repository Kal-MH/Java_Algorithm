import java.io.*;
import java.util.*;

public class Main {
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
			adj[x][y] = 1;
		}
	}
	
	

	public static void pro() {
		
	}
	
	public static void main(String args[]) {
		input();
		pro();
		
	}
}