package binary_search;

import java.io.*;
import java.util.*;

public class Main2110 {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	
	static int N, C;
	static int[] A;
	
	static void input() {
		N = scan.nextInt();
		C = scan.nextInt();
		A = new int[N + 1];
		for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
	}
	
	static boolean determination(int D) {
		int cnt = 1, last = A[1];
		
		for(int i = 2; i <= N; i++) {
			if (A[i] - last < D) continue;
			last = A[i];
			cnt++;
		}
		
		return cnt >= C;
	}
	
	static void pro() {
		Arrays.sort(A, 1, N + 1);
		
		//거리를 하나 탐색하고, 해당 거리로 공유기 C개를 설치할 수 있는지 확인하자.
		int L = 1, R = 1000000000, ans = 0;
		
		while (L <= R) {
			int mid = (L + R) / 2;
			
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
