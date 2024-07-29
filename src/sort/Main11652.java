package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11652 {
	static int N;
	static long[] cards;

	static void input() {
		FastReader scan = new FastReader();
		
		N = scan.nextInt();
		
		cards = new long[N];
		for(int i = 0; i < N; i++) cards[i] = scan.nextLong();
	}
	
	static void pro() {
		//sorting
		Arrays.sort(cards);
		
		long mode = cards[0];
		int modeCnt = 1, curCnt = 1;
		
		for(int i = 1; i < N; i++) {
			if (cards[i] == cards[i - 1]) curCnt++;
			else curCnt = 1;
			
			if (curCnt > modeCnt) {
				modeCnt = curCnt;
				mode = cards[i];
			}
		}
		
		System.out.println(mode);
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
