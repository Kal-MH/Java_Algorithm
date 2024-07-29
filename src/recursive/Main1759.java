package recursive;


import java.io.*;
import java.util.*;

/*
 * 전체 C개의 알파벳에서 L개의 알파벳을 중복을 허락하지 않고 고르는 조합.*/


public class Main1759 {

	static StringBuilder sb = new StringBuilder();

	static int L, C;
	static char[] chars;
	static int[] selected;

    static void input() {
    	FastReader scan = new FastReader();
    	
    	L = scan.nextInt();
    	C = scan.nextInt();
    	
    	chars = new char[C + 1];
    	
    	String[] tokens = scan.nextLine().split(" ");
    	for(int i = 1; i <= C; i++) chars[i] = tokens[i - 1].charAt(0);
    	
    	selected = new int[L + 1];
    }


    static boolean isVowel(char x) {
    	return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }

	static void rec_func(int k) {
		if (k == L + 1) {
			int vowel = 0, consonant = 0;
			
			for(int i = 1; i <= L; i++) {
				if (isVowel(chars[selected[i]])) vowel++;
				else consonant++;
			}
			
			if (vowel >= 1 && consonant >= 2) {
				for(int i = 1; i <= L; i++) sb.append(chars[selected[i]]);
				sb.append('\n');
			}
		} else {
			for(int i = selected[k - 1] + 1; i <= C; i++) {
				selected[k] = i;
				rec_func(k + 1);
				selected[k] = 0;
			}
		}
    }

    public static void main(String[] args) {
    	input();
    	
    	Arrays.sort(chars, 1, C + 1);
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

