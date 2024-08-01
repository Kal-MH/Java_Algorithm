package two_pointer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11728 {
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
		int right = 0, ans = -1, sum = 0;
		
		for(int left = 1; left <= N; left++) {
			while (right < N && sum < K) {
				right++;
				if (A[right] == 1) sum++;
			}
			
			if (sum == K) {
				if (ans == -1) ans = right - left + 1;
				ans = Math.min(ans, right - left + 1);
			}
			
			if (A[left] == 1) sum--;
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
