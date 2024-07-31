package binary_search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1654 {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	
	static int K, N;
	static int[] A;
	
	static void input() {
		K = scan.nextInt();
		N = scan.nextInt();
		A = new int[K + 1];
		for(int i = 1; i <= K; i++) A[i] = scan.nextInt();
	}
	
	
	static boolean determination(long len) {//int로 받아도 되지 않나?
		long sum = 0;
		
		for(int i = 1; i <= K; i++) {
			sum += A[i] / len;
		}
		
		return sum >= N;
	}
	
	static void pro() {
		long L = 1, R = Integer.MAX_VALUE, ans = 0;
		
		while (L <= R) {
			long mid = (L + R) / 2;
			if (determination((mid))) {
				ans = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
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
		
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			
			return st.nextToken();
		}
		
		String nextLine() {
			String str = "";
			
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
