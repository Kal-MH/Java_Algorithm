package binary_search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17266 {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[] A;
	
	public static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		A = new int[M + 1];
		for(int i = 1; i <= M; i++) A[i]= scan.nextInt();
	}
	
	public static boolean determination(int height) {
		int last = 0;
		
		for(int i = 1; i <= M; i++) {
			if (A[i] - last <= height) {
				last = A[i] + height;
			} else {
				return false;
			}
		}
		
		return last >= N;
	}
	
	public static void pro() {
		Arrays.sort(A, 1, M + 1);
		
		int L = 1, R = N, ans = N;
		
		while(L <= R) {
			int mid = (L + R) / 2;
			
			if (determination(mid)) {
				ans = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		
		System.out.println(ans);
	}
	
	public static void main(String args[]) {
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
