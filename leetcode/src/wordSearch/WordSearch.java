package wordSearch;

public class WordSearch {
    private final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board.length; ++j) {
                if (dfs(board, i, j, isVisited, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, boolean[][] isVisited, String word, int pos) {
        if (pos == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isVisited[i][j] == true) {
            return false;
        }
        if (isVisited[i][j] == true) {
            return false;
        }
        if (board[i][j] != word.charAt(pos)) {
            return false;
        }
        isVisited[i][j] = true;
        boolean res = dfs(board, i + 1, j, isVisited, word, pos + 1) ||
                dfs(board, i - 1, j, isVisited, word, pos + 1) ||
                dfs(board, i, j + 1, isVisited, word, pos + 1) ||
                dfs(board, i, j - 1, isVisited, word, pos + 1);
        isVisited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, "ABCCED") == true);
        System.out.println(wordSearch.exist(board, "RTGY") == false);
        System.out.println(wordSearch.exist(board, "BCDB") == false);
        System.out.println(wordSearch.exist(board, "ABFSA") == true);
    }
}
