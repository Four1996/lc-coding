package leetcode;

/**
 * @author panhao
 * @date 2021年05月08日 5:02 下午
 */
public class Exist_n1900 {
    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i=0;i< row;++i){
            for (int j=0;j<col;++j){
                if (dfs(board,word,0,i,j)) return true;
            }
        }
        return false;
    }

    static boolean dfs(char[][] board, String word, int word_index, int i, int j) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(word_index))
            return false;
        if (word_index == word.length() - 1) return true;

        board[i][j] = '\0';
        boolean res = false;
        res = dfs(board, word, word_index + 1, i + 1, j) ||
                dfs(board, word, word_index + 1, i - 1, j) ||
                dfs(board, word, word_index + 1, i, j - 1) ||
                dfs(board, word, word_index + 1, i, j + 1);
        board[i][j] = word.charAt(word_index);

        return res;

    }

    public static void main(String[] args) {
//        char[][] board={
//                {'A','B','C','E'},
//                {'S','J','C','S'},
//                {'A','D','E','E'},
//        };
        char[][] board={{'a'},{'a'}};
        String word="aaa";
        System.out.println(exist(board,word));
    }

}
