package recursive;

import java.io.*;
import java.util.*;

/*고르기, 중복 허용*/
public class Main15652 {

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
    		//M개를 고르는 것은 이전으로 돌아가지 않는 것과 같다.
    		//출발점을 바로 이전 시점의 값으로 맞춰주자.
    		int pre_value = selected[k - 1];
    		int cand = pre_value == 0 ? 1 : pre_value;
    		
    		for(int i = cand; i <= N; i++) {
    			selected[k] = i;
    			rec_func(k + 1);
    			selected[k] = 0;
    		}
    	}
    }

    public static void main(String[] args) {
       input();
       
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
