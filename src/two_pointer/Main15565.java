package two_pointer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15565 {
	static StringBuilder sb = new StringBuilder();
	static FastReader scan = new FastReader();
	
	static int N, M;
	static int[] A, B, totalArr;
	
	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		
		A = new int[N + 1];
		B = new int[M + 1];
		for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
		for(int i = 1; i <= M; i++) B[i] = scan.nextInt();
	}
	
	static void pro() {
		int L = 1, R = 1;
		
		while (L <= N && R <= M) {
			if (A[L] < B[R]) sb.append(A[L++]).append(' ');
			else sb.append(B[R++]).append(' ');
		}
		
		while (L <= N) sb.append(A[L++]).append(' ');
		while (R <= M) sb.append(B[R++]).append(' ');
		
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}
	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
		}
		
		public String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			
			return st.nextToken();
		}
		
		public String nextLine() {
			String str = "";
			
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			return str;
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
