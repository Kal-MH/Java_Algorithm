package two_pointer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2473 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int[] A;
    
    public static void input() {
    	N = scan.nextInt();
    	
    	A = new int[N + 1];
    	for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }
    
    public static void pro() {
    	Arrays.sort(A, 1, N + 1);
    	
    	long best_sum = Long.MAX_VALUE;
    	int v1 = 0, v2 = 0, v3 = 0;
    	
    	for(int i = 1; i <= N - 2; i++) {
    		int target = -A[i];
    		
    		int L = i + 1, R = N;
    		while (L < R) {
    			if (best_sum > Math.abs(-(long)target + A[L] + A[R])) {
    				best_sum = Math.abs(-(long)target + A[L] + A[R]);
    				v1 = -target;
    				v2 = A[L];
    				v3 = A[R];
    			}
    			
    			if (A[L] + A[R] > target) R--;
    			else L++;
    		}
    	}
    	
    	sb.append(v1).append(' ').append(v2).append(' ').append(v3);
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
