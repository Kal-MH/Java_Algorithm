package binarySearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2805 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A;
    
    public static void input() {
    	N = scan.nextInt();
    	M = scan.nextInt();
    	
    	A = new int[N + 1];
    	for(int i = 1; i <= N; i++) A[i] = scan.nextInt();
    }
    

    static long calculate(int height) {
    	long sum = 0;
    	
    	for(int i = 1; i <= N; i++) {
    		if (A[i] > height) {
    			sum += (A[i] - height);
    		}
    	}
    	
    	return sum;
    }

    static void pro() {
        Arrays.sort(A, 1, N + 1);
        
        long L = 0, R = A[N];
        long res = 0;
        while (L <= R) {
        	int mid = (int)((L + R) / 2);
        	
        	if (calculate(mid) >= M) {
        		res = mid;
        		L = mid + 1;
        	} else {
        		R = mid - 1;
        	}
        }
        
        System.out.println(res);
    }
    
	public static void main(String[] args) {
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
