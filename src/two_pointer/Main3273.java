package two_pointer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3273 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int n, x;
    static int[] a;
    
    public static void input() {
    	n = scan.nextInt();
    	
    	a = new int[n + 1];
    	for(int i = 1; i <= n; i++) a[i] = scan.nextInt();
    	
    	x = scan.nextInt();
    }
    
    public static void pro() {
    	Arrays.sort(a, 1, n + 1);
    	
    	int left = 1, right = n, cnt = 0;
    	
    	while (left < right) {
    		if (a[left] + a[right] == x) cnt++;
    		
    		if (a[left] + a[right] >= x) right--;
    		else left++;
    	}
    	
    	System.out.println(cnt);
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
