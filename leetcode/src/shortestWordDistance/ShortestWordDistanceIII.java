package shortestWordDistance;

public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index1 = -1;;
        int index2 = -1;
        int min = Integer.MAX_VALUE;
        int i = 0;
        for (String word : words) {
            if (!word1.equals(word2)) {
                if (word.equals(word1)) {
                    if (index2 != -1) {
                        min = Math.min(min, i - index2);
                    }
                    index1 = i;
                } else if (word.equals(word2)) {
                    if (index1 != -1) {
                        min = Math.min(min, i - index1);
                    }
                    index2 = i;
                }
            } else {
                if (word.equals(word1)) {
                    if (index1 != -1) {
                        min = Math.min(min, i - index1);
                    }
                    index1 = i;
                }
            }
            i++;
        }
        return min;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"hello", "miss", "good", "morning", "bye", "good", "morning", "evening", "bye"};
        ShortestWordDistanceIII obj = new ShortestWordDistanceIII();
        System.out.println(obj.shortestWordDistance(words, "good", "bye"));
        System.out.println(obj.shortestWordDistance(words, "bye", "bye"));
    }
}
