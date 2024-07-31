package binary_search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1300 {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	
	static int N, K;
	
	public static void input() {
		N = scan.nextInt();
		K = scan.nextInt();
	}
	
	
	// k번째라는 건, 앞에 K개만큼의 수가 있다는 것(1부터 시작하니까 0까지 포함해서 k - 1개가 아닌 k개)
	public static boolean determination(long candidate) {
		long sum = 0;
		
		// candidate이라는 숫자가 k번째인가?
		//candidate 이하의 숫자가 k개 이상인가?
		
		for(int i = 1; i <= N; i++) {
			sum += Math.min(N,  candidate / i);
		}
		
		return sum >= K;
	}
	
	public static void pro() {
		long L = 1, R = (long) N * N, ans = 0;
		
		while (L <= R) {
			long mid = (L + R) / 2;
			
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

