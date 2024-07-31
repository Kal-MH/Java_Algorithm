package binary_search;

import java.io.*;
import java.util.*;

public class Main1920 {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] A, B;
	
	
	static void input() {
		N = scan.nextInt();
		A = new int[N + 1];
		for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
		
		M = scan.nextInt();
		B = new int[M + 1];
		for(int i = 1; i <= M; i++) B[i] = scan.nextInt();
	}
	
	static int lower_bound(int left, int right, int x) {
		int res = 0;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (A[mid] == x) {
				res = 1;
				break;
			} else if (A[mid] > x) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return res;
	}
	
	static void pro() {
		Arrays.sort(A, 1, N + 1);
		
		for(int i = 1; i <= M; i++) {
			sb.append(lower_bound(1, N, B[i])).append('\n');
		}
		
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
