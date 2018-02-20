package regularExpressionMatching;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return false;
        }
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; ++i) {
            dp[i][0] = false;
        }
        for (int j = 1; j <= n; ++j) {
            if (p.charAt(j - 1) == '*' && j > 1) {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (j >= 2) {
                        if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                        } else {
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                    if (j == 1) {
                        return false;
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        RegularExpressionMatching obj = new RegularExpressionMatching();
        System.out.println(obj.isMatch("aa", "a") == false);
        System.out.println(obj.isMatch("aa", "aa") == true);
        System.out.println(obj.isMatch("aaa", "aa") == false);
        System.out.println(obj.isMatch("aa", "a*") == true);
        System.out.println(obj.isMatch("aa", ".*") == true);
        System.out.println(obj.isMatch("ab", ".*") == true);
        System.out.println(obj.isMatch("aab", "c*a*b") == true);
    }
}
