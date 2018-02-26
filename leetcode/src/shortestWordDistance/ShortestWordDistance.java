package shortestWordDistance;

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;;
        int index2 = -1;
        int min = Integer.MAX_VALUE;
        int i = 0;
        for (String word : words) {
            if (word.equals(word1)) {
                if (index2 != -1) {
                    min = Math.min(min, i - index2);
                }
                index1 = i;
            }
            if (word.equals(word2)) {
                if (index1 != -1) {
                    min = Math.min(min, i - index1);
                }
                index2 = i;
            }
            i++;
        }
        return min;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"hello", "miss", "good", "morning", "bye", "good", "morning", "evening", "bye"};
        ShortestWordDistance obj = new ShortestWordDistance();
        System.out.println(obj.shortestDistance(words, "good", "bye"));
        System.out.println(obj.shortestDistance(words, "morning", "hello"));
    }
}
