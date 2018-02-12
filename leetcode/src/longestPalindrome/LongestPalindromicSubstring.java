package longestPalindrome;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String res = "";
        for (int i = 0; i < s.length(); ++i) {
            String oddRes = helper(s, i, i);
            if (oddRes.length() > res.length()) {
                res = oddRes;
            }
            String evenRes = "";
            if (i >= 1 && s.charAt(i) == s.charAt(i - 1)) {
                evenRes = helper(s, i - 1, i);
            }
            if (evenRes.length() > res.length()) {
                res = evenRes;
            }
        }
        return res;
    }
    public String helper(String s, int i, int j) {
        int index = 0;
        if (i == j) {
            while (i - index >= 0 && i + index < s.length()) {
                if (s.charAt(i - index) == s.charAt(i + index)) {
                    index++;
                } else {
                    break;
                }
            }
            return s.substring(i - index + 1, i + index);
        } else {
            while (i - index >= 0 && j + index < s.length()) {
                if (s.charAt(i - index) == s.charAt(j + index)) {
                    index++;
                } else {
                    break;
                }
            }
            return s.substring(i - index + 1, j + index);
        }
    }
}
