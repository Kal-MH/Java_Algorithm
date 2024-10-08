package recursive;

import java.io.*;
import java.util.*;

public class Main15651 {
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] selected;
	
    static void input() {
    	FastReader scan = new FastReader();
    	
    	N = scan.nextInt();
    	M = scan.nextInt();
    	selected = new int[M + 1];
    }


    static void rec_func(int k) {
        if (k == M + 1) {
        	for(int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
        	sb.append('\n');
        } else {
        	// N개 중에 순차적으로 하나 고른다.
        	for(int cand = 1; cand <= N; cand++) {
        		selected[k] = cand;
        		rec_func(k+1);
        		selected[k] = 0;
        	}
        }
    }

    public static void main(String[] args) {
       input();
       
       // 1번째 원소부터 탐색
       rec_func(1);
       System.out.println(sb.toString());
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
