package isSubsequence;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s == null) {
            return true;
        }
        int indexS = 0;
        int indexT = 0;
        while (indexT < t.length()) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
            }
            if (indexS == s.length()) {
                return true;
            }
            indexT++;
        }
        return false;
    }

    public boolean isSubsequenceDP(String s, String t) {
        if (t == null || t.length() == 0){
            return s == null || s.length() == 0;
        }

        if (s == null || s.length() == 0){
            return true;
        }

        int m = s.length();
        int n = t.length();

        boolean[][] dp = new boolean[m][n];

        //initial first col
        if (s.charAt(0) == t.charAt(0)){
            dp[0][0] = true;
        }

        for (int i = 1 ; i < m ; i++){
            dp[i][0] = false;
        }

        //initial first row
        for (int i = 1 ; i < n ; i++){
            dp[0][i] = dp[0][i-1] || (s.charAt(0) == t.charAt(i));
        }

        for (int i = 1 ; i < m ; i++){
            for (int j = 1 ; j < n ; j++){
                if (s.charAt(i) == t.charAt(j)){
                    dp[i][j] = (dp[i-1][j-1] || dp[i][j-1]);
                    //all others to be true and continue;
                    if (dp[i][j]){
                        for (int k = j + 1 ; k < n ; k++){
                            dp[i][k] = true;
                        }
                        continue;
                    }
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println("Two-pointer solution:");
        System.out.println(isSubsequence.isSubsequence("sdf", "serdiu8f"));
        System.out.println(isSubsequence.isSubsequence("sdmf", "serdiu8f"));

        System.out.println("\nDynamic Programming solution:");
        System.out.println(isSubsequence.isSubsequenceDP("sdf", "serdiu8f"));
        System.out.println(isSubsequence.isSubsequenceDP("sdmf", "serdiu8f"));
    }
}
