package longestWordInDictionary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";
        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                res = word.length() > res.length() ? word : res;
                set.add(word);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestWordInDictionary longestWordInDictionary = new LongestWordInDictionary();
        System.out.println(longestWordInDictionary.longestWord(new String[]{}));
        System.out.println(longestWordInDictionary.longestWord(new String[]{"a", "ab", "abc", "d", "da", "dad"}));
        System.out.println(longestWordInDictionary.longestWord(new String[]{"a", "as", "asd", "d", "da", "dbd"}));
    }
}
