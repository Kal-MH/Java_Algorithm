package two_pointer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2559 {
	static StringBuilder sb = new StringBuilder();
	static FastReader scan = new FastReader();
	
	static int N, K;
	static int[] A;
	
	static void input() {
		N = scan.nextInt();
		K = scan.nextInt();
		A = new int[N + 1];
		
		for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
	}
	
	static void pro() {
		int R = 0, sum = 0, ans = -100 * N;
		
		for(int L = 1; L + K - 1 <= N; L++) {
			sum -= A[L - 1];
			
			while (R + 1 <= L + K - 1) {
				sum += A[++R];
			}
			
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
