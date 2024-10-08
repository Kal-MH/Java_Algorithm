package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main20291 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static String[] a;
    
	static void input() {
		N = scan.nextInt();
		
		a = new String[N + 1];
		for(int i = 1; i <= N; i++) a[i] = scan.nextLine().split("\\.")[1];
	}
	
	static void pro() {
		Arrays.sort(a, 1, N + 1);
		
		for(int i = 1; i <= N;) {
			int cnt = 1, j = i + 1;
			
			for(;j <= N; j++) {
				if (a[i].compareTo(a[j]) == 0) cnt++;
				else break;
			}
			
			sb.append(a[i]).append(' ').append(cnt).append('\n');
			i = j;
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
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			
			return st.nextToken();
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
		
		String nextLine() {
			String str = "";
			
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			return str;
		}
	}
}
