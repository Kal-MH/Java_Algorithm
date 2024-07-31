package binary_search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10816 {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[] A;
	
	static void input() {
		N = scan.nextInt();
		A = new int[N + 1];
		for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
	}
	
	//X값 중에서도 가장 왼쪽(가장 작은 인덱스를 가진)인 값을 찾는다.
	static int lower_bound(int[] A, int L, int R, int X) {
		int res = R + 1;
		
		while (L <= R) {
			int mid = (L + R) / 2;
			
			if (A[mid] >= X) {
				res = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		
		return res;
	}
	
	//X값 보다 큰 값 중 가작 작은 값(X 바로 옆에 있는 값)을 찾는다.
	static int upper_bound(int[] A, int L, int R, int X) {
		int res = R + 1;
		
		while (L <= R) {
			int mid = (L + R) / 2;
			
			if (A[mid] > X) {
				res = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		
		return res;
	}
	
	static void pro() {
		Arrays.sort(A, 1, N + 1);
		
		int M = scan.nextInt();
		for(int i = 1; i <= M; i++) {
			int X = scan.nextInt();
			int upper = upper_bound(A, 1, N, X);
			int lower = lower_bound(A, 1, N, X);
			
			sb.append(upper - lower).append(' ');
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
