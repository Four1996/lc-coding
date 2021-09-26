package leetcode;

/**
 * @program: first
 * @description: 判断单词是否能放入填字游戏内
 * @author: panhao
 * @date: 2021-09-26 14:38
 **/
public class placeWordInCrossword_n5883 {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int row= board.length,col=board[0].length;
        int len=word.length();
        char[] chars = word.toCharArray();
        for (int i = 0; i < row; i++) {
            int cur=0;
            for (int j = 0; j < col; j++) {
                if (board[i][j]=='#'){
                    cur=0;
                    continue;
                }else if (board[i][j]==' '){
                    cur++;
                }else {
                    if (board[i][j]!=chars[cur]){

                    }
                }
            }
        }
        return false;
    }
}
