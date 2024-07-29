package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1181 {
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static String[] a;
	
	static class MyComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			if (o1.length() != o2.length()) return o1.length() - o2.length();
			return o1.compareTo(o2);
		}
	}
	
	static void input() {
		FastReader scan = new FastReader();
		
		N = scan.nextInt();
		a = new String[N];
		for(int i = 0; i < N; i++) a[i] = scan.nextLine();
	}
	
	static void pro() {
		Arrays.sort(a, new MyComparator());
		
		for(int i = 0;  i < N; i++) {
			if (i == 0 || a[i].compareTo(a[i - 1]) != 0) {
				sb.append(a[i]).append('\n');
			}
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
