public class NQueen {
    public static void main(String[] args)
    {

        Boolean[][]board=new Boolean[4][4];
        for(int i=0;i< board.length;i++)
        {
            for(int j=0;j<board.length;j++) {
                board[i][j]=false;
            }
            }

        printNQueens(board,0,"");
    }

    public static int countNQueens(Boolean [][] board,int row)
    {
        if(row== board.length)
            return 1;

        int count=0;
      for(int column=0;column<board[row].length;column++)
      {
          if(isItSafe(board,row,column))
          {  board[row][column]=true;
              count=count+ countNQueens(board,row+1);
              board[row][column]=false;
          }
      }
      return count;

    }
    private static boolean isItSafe(Boolean[][] board, int row, int column) {

        //top
        for(int i=row;i>=0;i--)
        {
            if(board[i][column]==true)
                return false;
        }
        //left diagonal

        for(int i=row,j=column;i>=0 && j>=0;i--,j--)
        {
            if(board[i][j]==true)
            return false;

        }
        //right diagonal

        for(int i=row,j=column;i>=0 && j<board.length;i--,j++)
        {
            if(board[i][j]==true)
                return false;

        }

        return true;
    }
    public static void printNQueens(Boolean [][] board,int row,String result) {
        if (row == board.length)
            System.out.println(result);

        else {


            for (int column = 0; column < board[row].length; column++) {
                if (isItSafe(board, row, column)) {
                    board[row][column] = true;
                    printNQueens(board, row + 1, (result + "{" + row + 1 + "-" + column + 1 + "};"));
                    board[row][column] = false;
                }
            }


        }
    }




}
