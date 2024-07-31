package binary_search;

import java.io.*;
import java.util.*;

public class Main13702 {
	static FastReader scan = new FastReader();
	
	static int N, K;
	static int[] A;
	
	static void input() {
		N = scan.nextInt();
		K = scan.nextInt();
		A = new int[N + 1];
		for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
	}
	
	static boolean determination(long limit) {
		int cnt = 0;
		
		for(int i = 1; i <= N; i++) {
			if (A[i] < limit) continue;
			
			cnt += (A[i] / limit);
		}
		
		return cnt >= K;
	}
	
	static void pro() {
		Arrays.sort(A, 1, N + 1);
		
		long L = 0, R = Integer.MAX_VALUE, ans = 0;
		
		while (L <= R) {
			long mid = (L + R) / 2;
			
			if (determination(mid)) {
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
