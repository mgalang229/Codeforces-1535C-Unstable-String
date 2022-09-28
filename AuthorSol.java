import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/*

a XOR a = 0
0 XOR a = a

character is either:
0, then left to right diagonal
1, then right to left diagonal

1
0?10

"0"
-1 -1
-1 -1

"0?"
0 -1
-1 -1

"0?1"
0 -1
2 -1

"0?10"
0 3
2 -1

 */

public class AuthorSol {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char[] s = fs.next().toCharArray();
			int[][] last = new int[2][2];
			for (int i = 0; i < 2; i++) {
				Arrays.fill(last[i], -1);
			}
			long ans = 0;
			for (int i = 0; i < s.length; i++) {
				int j = i - 1;
				int p = i & 1;
				//System.out.println("j = " + j);
				//System.out.println("p = " + p);
				if (s[i] != '1') {
					j = Math.min(j, Math.max(last[0][p^1], last[1][p]));
					//System.out.println("(!= 1) j = " + j);
					//System.out.println("last[0][" + (p^1) + "] = " + last[0][p^1]);
					//System.out.println("last[1][" + p + "] = " + last[1][p]);
				}
				if (s[i] != '0') {
					j = Math.min(j, Math.max(last[0][p], last[1][p^1]));
					//System.out.println("(!= 0) j = " + j);
					//System.out.println("last[0]["+ p + "] = " + last[0][p]);
					//System.out.println("last[1][" + (p^1) + "] = " + last[1][p^1]);
				}
				ans += i - j;
				//System.out.println("i - j = " + (i-j));
				if (s[i] != '?') {
					last[s[i]-'0'][p] = i;
					//System.out.println("[" + (s[i]-'0') + "][" + p + "] = " + i);
				}
				//System.out.println("------------");
			}
			System.out.println(ans);
		}
		out.close();
	}
	
	static final Random rnd = new Random();
	
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
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
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
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
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
