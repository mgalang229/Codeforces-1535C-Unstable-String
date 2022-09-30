import java.util.Scanner;

public class AnotherSol {
    public static void main(String args[]) {
        Scanner fs = new Scanner(System.in);
        int T = fs.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            char[] s = fs.next().toCharArray();
            int n = s.length;
            //classical dp approach
            long[][] dp = new long[n+1][2];
            dp[0][0] = dp[0][1] = 0;
            long ans = 0;
            for (int i = 1; i <= n; i++) {
                if (s[i-1] == '?') {
                    dp[i][0] = dp[i-1][1] + 1;
                    dp[i][1] = dp[i-1][0] + 1;
                } else if (s[i-1] == '0') {
                    dp[i][0] = dp[i-1][1] + 1;
                    dp[i][1] = 0;
                } else {
                    dp[i][1] = dp[i-1][0] + 1;
                    dp[i][0] = 0;
                }
                ans += Math.max(dp[i][0], dp[i][1]);
            }
            System.out.println(ans);
        }
        fs.close();
    }
}
