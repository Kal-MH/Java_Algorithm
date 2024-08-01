package two_pointer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2230 {
	static StringBuilder sb = new StringBuilder();
	static FastReader scan = new FastReader();
	
	static int N, M;
	static int[] A;
	
	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		
		A = new int[N + 1];
		for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
	}
	
	static void pro() {
		Arrays.sort(A, 1, N + 1);
		
		int R = 1, ans = Integer.MAX_VALUE;
		for(int L = 1; L <= N; L++) {
			while (R + 1 <= N && A[R] - A[L] < M) R++;
			
			if (A[R] - A[L] >= M) ans = Math.min(ans, R - L + 1);
		}
		
		System.out.println(ans);
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
