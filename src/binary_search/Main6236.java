package binary_search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main6236 {
	static FastReader scan = new FastReader();
	
	static int N, M;
	static int[] A;
	
	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		
		A = new int[N + 1];
		for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
	}
	
	static boolean calculator(int withdraw) {
		int cnt = 1, sum = 0;
		
		for(int i = 1; i <= N; i++) {
			if (sum + A[i] <= withdraw) {
				sum += A[i];
			} else {
				cnt++;
				sum = A[i];
			}
		}
		
		return cnt <= M;
	}
	
	static void pro() {
		Arrays.sort(A, 1, N + 1);
		
		int L = A[N], R = 1000000000, K = 0;
		
		while (L <= R) {
			int mid = (L + R) / 2;
			
			if (calculator(mid)) {
				K = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		
		System.out.println(K);
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
