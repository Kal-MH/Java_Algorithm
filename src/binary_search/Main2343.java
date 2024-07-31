package binary_search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2343 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N, M;
    static int[] A;
    
    static void input() {
    	N = scan.nextInt();
    	M = scan.nextInt();
    	A = new int[N + 1];
    	for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }
    
    static boolean determination(int len) {
    	int cnt = 1, sum = 0;
    	
    	for(int i = 1; i <= N; i++) {
    		if (sum + A[i] > len) {
    			cnt++;
    			sum = A[i];
    		} else {
    			sum += A[i];
    		}
    	}
    	
    	return cnt <= M;
    }
    
    static void pro() {
    	int L = A[1], R = 1000000000, ans = 0;
    	for(int i = 1; i <= N; i++) L = Math.max(L, A[i]);
    	
    	while (L <= R) {
    		int mid = (L + R) / 2;
    		if (determination(mid)) {
    			ans = mid;
    			R = mid - 1;
    		} else {
    			L = mid + 1;
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
