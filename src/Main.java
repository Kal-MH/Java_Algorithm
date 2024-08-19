import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Scanner sc = new Scanner(System.in);
	
	static int N, C;
	static int[] A;
	
	public static void input() {
		N = sc.nextInt();
		C = sc.nextInt();
		
		A = new int[N + 1];
		for(int i = 1; i <= N; i++) A[i] = sc.nextInt();
	}
	
	public static boolean determination(int mid) {
		int cnt = 1, last = A[1];
		
		for(int i = 2; i <= N; i++) {
			if (A[i] - last < mid) continue;
			
			cnt++;
			last = A[i];
		}
		
		return cnt >= C;
	}
	
	public static void pro() {
		Arrays.sort(A, 1, N + 1);
		
		int L = 0, R = 1000000000, ans = 0;
		
		while (L <= R) {
			int mid = (L + R) / 2;
			
			if (determination(mid)) {
				ans = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		input();
		pro();
	}
}