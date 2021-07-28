package leetcode;

/**
 * @author yang
 * 2021年07月17日 22:25:00
 */
public class 题79单词搜索 {
    public static void main(String[] args) {
        char[][] board = {{'a', 'b', 'c', 'e'},{'s','f','c','s'},{'a','d','e','e'}};
        String word = "see";
        System.out.println(exist(board,word));
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (getRes(board,word,0,i,j)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean getRes(char[][] board, String word,int index,int i,int j) {
        if (index >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 ||j >= board[0].length) {
            return false;
        }

        if (board[i][j] == '0' || word.charAt(index) != board[i][j] ) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '0';
        boolean top = getRes(board,word,index+1,i-1,j);
        boolean down = getRes(board,word,index+1,i+1,j);
        boolean left = getRes(board,word,index+1,i,j-1);
        boolean right = getRes(board,word,index+1,i,j+1);
        board[i][j] = temp;
        return top||down||left||right;
    }
}
