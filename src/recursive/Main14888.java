package recursive;

import java.io.*;
import java.util.*;

/*
 * 1. 연산자 4개가 주어지고, N - 1개 중복을 허용해서 나열하는 문제(앞, 뒤에 따라 달라지기 때문에 순서 중요) */

public class Main14888 {

	static StringBuilder sb = new StringBuilder();
	
	static int N, min, max;
	static int[] nums, operators;


    static void input() {
    	FastReader scan = new FastReader();
    	
    	N = scan.nextInt();
    	nums = new int[N + 1];
    	operators = new int[5];
    	
    	for(int i = 1; i <= N; i++) nums[i] = scan.nextInt();
    	for(int i = 1; i < 5; i++) operators[i] = scan.nextInt();
    	
    	max = Integer.MIN_VALUE;
    	min = Integer.MAX_VALUE;
    }
    
    public static int calculator(int operand1, int operator, int operand2) {
    	switch(operator) {
	    	case 1:
	    		return operand1 + operand2;
	    	case 2: 
	    		return operand1 - operand2;
	    	case 3:
	    		return operand1 * operand2;
	    	default:
	    		return operand1 / operand2;
    	}
    }
    
    public static void rec_func(int k, int value) {
    	//모두 다 골랐을 때, 만족하는 최솟값, 최댓값을 저장한다.
    	if (k == N) {
    		min = Math.min(min, value);
    		max = Math.max(max, value);
    	} else {
    		for(int i = 1; i < 5; i++) {
    			//현재 사용할 수 있는 연산자 갯수가 남아있는지
    			if (operators[i] == 0) continue;
    			
    			operators[i]--;
    			rec_func(k + 1, calculator(value, i, nums[k + 1]));
    			operators[i]++;
    		}
    	}
    }


    public static void main(String[] args) {
    	input();
    	
    	rec_func(1, nums[1]);
    	sb.append(max).append(' ').append(min);
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
