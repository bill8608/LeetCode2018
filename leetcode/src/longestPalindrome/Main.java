package longestPalindrome;

public class Main {
    public static void main(String[] args) {
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        System.out.println(obj.longestPalindrome(""));
        System.out.println(obj.longestPalindrome(null));
        System.out.println(obj.longestPalindrome("abab"));
        System.out.println(obj.longestPalindrome("bb"));
    }
}