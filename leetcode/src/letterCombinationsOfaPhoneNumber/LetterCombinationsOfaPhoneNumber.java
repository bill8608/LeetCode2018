package letterCombinationsOfaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfaPhoneNumber {
    private static final Map<Integer, String> map = new HashMap<Integer, String>();
    public List<String> letterCombinations(String digits) {
        map.put(0, "");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        List<String> res = new ArrayList<>();
        helper(digits, res, new StringBuilder(), map, 0);
        return res;
    }
    public void helper(String digits, List<String> res, StringBuilder item, Map<Integer, String> map, int pos) {
        if (pos == digits.length()) {
            res.add(item.toString());
            return;
        }
        String s = map.get(digits.charAt(pos) - '0');
        for (char cs : s.toCharArray()) {
            item.append(cs);
            helper(digits, res, item, map, pos + 1);
            item.deleteCharAt(item.length() - 1);
        }

    }

    public static void main(String[] args) {
        LetterCombinationsOfaPhoneNumber obj = new LetterCombinationsOfaPhoneNumber();
        List<String> res = new ArrayList<>();
        res = obj.letterCombinations("23");
        for(String s : res) {
            System.out.println(s);
        }
    }
}
