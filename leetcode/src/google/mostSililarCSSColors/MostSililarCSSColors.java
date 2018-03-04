package google.mostSililarCSSColors;

public class MostSililarCSSColors {
    public String mostSililarCSSColors(String str) {
        char[] chs = str.toCharArray();
        String s = "0123456789abcdef";
        int max = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 16; ++k) {
                    int distance = helper(chs, s, i, j, k);
                    if (distance < max) {
                        max = distance;
                        res = "#" + s.charAt(i) + s.charAt(j) + s.charAt(k);
                    }
                }
            }
        }
        return res;
    }
    private int helper(char[] chs, String s, int i, int j, int k) {
        int A = s.indexOf(chs[1]) * 16 + s.indexOf(chs[2]);
        int B = s.indexOf(chs[3]) * 16 + s.indexOf(chs[4]);
        int C = s.indexOf(chs[5]) * 16 + s.indexOf(chs[6]);

        int powerA = (A - 16 * i - i) * (A - 16 * i - i);
        int powerB = (B - 16 * j - j) * (B - 16 * j - j);
        int powerC = (C - 16 * k - k) * (C - 16 * k - k);

        return powerA + powerB + powerC;
    }

    public static void main(String[] args) {
        MostSililarCSSColors obj = new MostSililarCSSColors();
        System.out.println(obj.mostSililarCSSColors("#09f166").equals("#1e6"));
    }
}
