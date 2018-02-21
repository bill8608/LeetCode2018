package minimumWindowSubsequence;

public class MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        // S [0, ... , i]
        // T [0, ..., j]
        // dp[i][j] is starting index k of the shortest postfix of S[0, i], such that T[0, j] is a subsequence of S[k, i]
        // The goal is to find min(i - dp[i][n - 1]) for all i < m, where m is S.size() and n is T.size()
        // Initial condition: dp[i][0] = i if S[i] = T[0], else -1
        // Equations: If S[i] = T[j], dp[i][j] = max(dp[k][j-1]) for all k < i; else dp[i][j] = -1;
        int m = T.length();
        int n = S.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j + 1;
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        int start = 0;
        int len = n + 1;
        for (int j = 1; j <= n; ++j) {
            if (dp[m][j] != 0) {
                if (j - dp[m][j] + 1 < len) {
                    start = dp[m][j] - 1;
                    len = j - dp[m][j] + 1;                }
            }
        }
        return len == n + 1 ? "" : S.substring(start, start + len);
    }

    public static void main(String[] args) {
        MinimumWindowSubsequence obj = new MinimumWindowSubsequence();
        System.out.println(obj.minWindow("abcdedcde", "bde"));
    }
}
