package google.firstUniqueCharacterInAString;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] freqs = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            freqs[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (freqs[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String input1 = "google";
        String input2 = "Morning";
        String input3 = "Helloheo";
        String input4 = "dd";
        FirstUniqueCharacterInAString obj = new FirstUniqueCharacterInAString();
        System.out.println(obj.firstUniqChar(input1) == 4);
        System.out.println(obj.firstUniqChar(input2) == 0);
        System.out.println(obj.firstUniqChar(input3) == 0);
        System.out.println(obj.firstUniqChar(input4) == -1);

    }
}
