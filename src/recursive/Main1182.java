package recursive;


import java.io.*;
import java.util.*;


public class Main1182 {

	static StringBuilder sb = new StringBuilder();


	static int N, S, ans;
	static int[] nums;
	
    static void input() {
    	FastReader scan = new FastReader();
    	
    	N = scan.nextInt();
    	S = scan.nextInt();
    	
    	nums = new int[N + 1];
    	for(int i = 1; i <= N; i++) nums[i] = scan.nextInt();
    }


    static void rec_func(int k, int value) {
    	if (k == N + 1) {
    		if (value == S) ans++;
    	} else {
    		rec_func(k + 1, value);
    		rec_func(k + 1, value + nums[k]);
    	}
    }

    public static void main(String[] args) {
    	input();
    	
    	rec_func(1, 0);
    	
    	//아무것도 선택 안해서 0인 경우도 있으니까.
    	if (S == 0) {
    		ans--;
    	}
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
