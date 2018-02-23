package shortestShortestWordDistanceIIII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {
    Map<String, List<Integer>> map = new HashMap<>();
    public ShortestWordDistanceII(String[] words) {
        for (int i = 0; i < words.length; ++i) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < list1.size(); ++i) {
            for (int j = 0; j < list2.size(); ++j) {
                minDis = Math.min(minDis, Math.abs(list1.get(i) - list2.get(j)));
            }
        }
        return minDis;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        ShortestWordDistanceII obj = new ShortestWordDistanceII(words);
        int param1 = obj.shortest("coding",  "practice");
        System.out.println(param1 == 3);

        int param2 = obj.shortest("makes", "coding");
        System.out.println(param2 == 1);
    }
}
