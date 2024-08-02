import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	
	static int N, S, ans;
	static int[] A;

	static void input() {
		N = scan.nextInt();
		S = scan.nextInt();
		
		A = new int[N + 1];
		for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
	}
	
	static void rec_func(int k, int value) {
		if (k == N + 1) {
			if (value == S) ans++;
		} else {
			rec_func(k + 1, value + A[k]);
			rec_func(k + 1, value);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();

		rec_func(1, 0);
		
		if (S == 0) ans--;
		System.out.println(ans);
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
