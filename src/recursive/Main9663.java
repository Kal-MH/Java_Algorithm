package recursive;


import java.io.*;
import java.util.*;


public class Main9663 {

	static StringBuilder sb = new StringBuilder();
	
	static int N, ans;
	static int[] col;
	
    static void input() {
    	FastReader scan = new FastReader();
    	
    	N = scan.nextInt();
    	col = new int[N + 1];
    }
    
    static boolean attackable(int r1, int c1, int r2, int c2) {
    	if (c1 == c2) return true;
    	if (r1 - c1 == r2 - c2) return true;
    	if (r1 + c1 == r2 + c2) return true;
    	return false;
    }


    static void rec_func(int k) {
    	if (k == N + 1) {
    		ans++;
    	} else {
    		// 각 행에 대해 하나씩 기물 놓기
    		// 순서 중요, 중복 허용 -> 순열
    		for(int c = 1; c <= N; c++) {
    			boolean possible = true;
    			
    			for(int r = 1; r < k; r++) {
    				//지금까지 놓았던 기물과 충돌하는지 체크
    				if (attackable(k, c, r, col[r])) {
    					possible = false;
    					break;
    				}
    			}
    			
    			
    			if (possible) {
    				col[k] = c;
    				rec_func(k + 1);
    				col[k] = 0;
    			}
    		}
    	}
    }

    public static void main(String[] args) {
       input();
       
       rec_func(1);
       System.out.println(ans);
    }


    static class FastReader {
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
                } catch (IOException e) {
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
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
