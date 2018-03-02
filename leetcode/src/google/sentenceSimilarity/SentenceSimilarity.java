package google.sentenceSimilarity;

public class SentenceSimilarity {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
/*        Set<String[]> set = new HashSet<>();
        for (String[] pair : pairs) {
            set.add(pair);
            System.out.println(pair[0] + ", " + pair[1]);
            System.out.println(set.contains(pair));
            System.out.print(set.contains(new String[]{pair[0], pair[1]}));
        }*/
        int numOfEquals = 0;
        for (int i = 0; i < words1.length; ++i) {
            if (words1[i].equals(words2[i])) {
                numOfEquals++;
            } else {
                for (String[] pair : pairs) {
                    if ((pair[0].equals(words1[i]) && pair[1].equals(words2[i])) || (pair[0].equals(words2[i]) && pair[1].equals(words1[i]))) {
                        numOfEquals++;
                        break;
                    }
                }
            }
        }
        return numOfEquals == words1.length;
    }

    public static void main(String[] args) {
        String[] words1 = new String[]{"great", "acting", "skills"};
        String[] words2 = new String[]{"fine", "drama", "talent"};
        String[][] pairs = new String[][]{{"great", "fine"}, {"acting", "drama"}, {"skills", "talent"}};
        SentenceSimilarity obj = new SentenceSimilarity();
        System.out.println(obj.areSentencesSimilar(words1, words2, pairs) == true);

        System.out.println(obj.areSentencesSimilar(new String[]{"great"}, new String[]{"great"}, new String[][]{}) == true);

        System.out.println(obj.areSentencesSimilar(new String[]{"great"}, new String[]{"great"}, pairs) == true);

        System.out.println(obj.areSentencesSimilar(new String[]{"good"}, new String[]{"great"}, new String[][]{}) == false);

        System.out.println(obj.areSentencesSimilar(new String[]{"great"}, new String[]{"good"}, pairs) == false);

    }
}
