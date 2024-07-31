package binary_search;

import java.io.*;
import java.util.*;

public class Main1764 {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static String[] A;
	
	static void input() {
		N = scan.nextInt();
		A = new String[N + 1];
		for(int i = 1; i <= N; i++) A[i] = scan.nextLine();
	}
	
	static boolean bin_search(String[] A, int L, int R, String x) {
		boolean res = false;
		
		while (L <= R) {
			int mid = (L + R) /  2;
			
			if (A[mid].compareTo(x) == 0) {
				res = true;
				break;
			} else if (A[mid].compareTo(x) < 0) {
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		
		return res;
	}

	static void pro() {
		Arrays.sort(A, 1, N + 1);
		
		int M = scan.nextInt();
		int ansCnt = 0;
		String[] ans = new String[M + 1];
		
		for(int i = 1; i <= M; i++) {
			String x = scan.nextLine();
			
			if (bin_search(A, 1, N, x)) ans[ansCnt++] = x;
		}
		
		sb.append(ansCnt).append('\n');
		for(int i = 0; i < ansCnt; i++) sb.append(ans[i]).append('\n');
		
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
