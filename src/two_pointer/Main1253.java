package two_pointer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1253 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int[] A;
    static boolean[] goods;
    
    public static void input() {
    	N = scan.nextInt();
    	A = new int[N + 1];
    	for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }
    
    public static boolean func(int target_idx) {
    	int L = 1, R = N;
    	int target = A[target_idx];
    	
    	while (L < R) {
    		if (L == target_idx) L++;
    		else if (R == target_idx) R--;
    		else {
        		if (A[L] + A[R] == target) return true;
        		
        		if (A[L] + A[R] > target) R--;
        		else L++;	
    		}
    	}
    	
    	return false;
    }
    
    public static void pro() {
    	Arrays.sort(A, 1, N + 1);
    	
    	int ans = 0;
    	for(int i = 1; i <= N; i++) {
    		if (func(i)) {
    			ans++;
    		}
    	}
    	
    	System.out.println(ans);
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
