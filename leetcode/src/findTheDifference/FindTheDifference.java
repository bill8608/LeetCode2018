package findTheDifference;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char c = s.length() > t.length() ? s.charAt(s.length() - 1) : t.charAt(t.length() -1);
        for (int i = 0; i < Math.min(s.length(), t.length()); ++i) {
            c ^= t.charAt(i);
            c ^= s.charAt(i);
        }
        return c;
    }

    public static void main(String[] args) {
        FindTheDifference obj = new FindTheDifference();
        System.out.println(obj.findTheDifference("abdcf", "abdrcf"));
    }
}
