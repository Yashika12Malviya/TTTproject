package Game;
import Player.player;
import Board.board;
import java.util.*;


public class Game {
    player[] players;
    board board;
    int turn;
    int NoOfMoves;
    boolean gameOver;
    String zeros;
    String cross;

    public Game(player[] players, board board) {
        this.players = players;
        this.board = board;
        this.turn = 0;
        this.NoOfMoves = 0;
        this.gameOver = false;

        StringBuilder z = new StringBuilder();
        StringBuilder c = new StringBuilder();

        for (int i = 0; i < board.size; i++) {
            z.append('0');
            c.append('X');
        }
        this.zeros = z.toString();
        this.cross = c.toString();

    }

    public void printBoardConfi() {
        int sz = board.size;
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                System.out.print(board.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void play() {
      printBoardConfi();
      int sz = board.size;

      while (!gameOver){
          NoOfMoves++;
          int idx = getIndex();

          int row = idx/sz;
          int col = idx%sz;

          board.matrix[row][col] = players[turn].getPlayerSymbol();

          if(NoOfMoves >= sz*sz){
              System.out.println("Game Draw");
              return;
          }

          if(NoOfMoves >= 2*sz-1 && checkCombination() == true){
              gameOver = true;
              printBoardConfi();
              System.out.println("Winner is : " + players[turn].getPlayerName());
              return;
          }

          turn = (turn+1) % 2;
          printBoardConfi();
      }
    }

    public int getIndex() {

        while (true) {
            System.out.println("Player : " + players[turn].getPlayerName() + " give one position ");
            Scanner in = new Scanner(System.in);
            int pos = in.nextInt() - 1;

            int sz = board.size;

            int row = pos / sz;
            int col = pos % sz;

            //checking if the position is invalid
            if (row < 0 || row >= sz || col < 0 || col >= sz) {
                System.out.println("Invalid position");
                continue;
            }
            //checking for the vacant position
            if (board.matrix[row][col] != '-') {
                System.out.println("Already Occupied Position");
                continue;
            }
            return pos;
        }
    }

    public boolean checkCombination() {
        int sz = board.size;

        //row wise
        for (int i = 0; i < sz; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sz; j++) {
                sb.append(board.matrix[i][j]);
            }
            String pattern = sb.toString();
            if ((pattern.equals(zeros)) || (pattern.equals(cross))) {
                return true;
            }
        }
        //columnwise
        for (int i = 0; i < sz; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sz; j++) {
                sb.append(board.matrix[j][i]);
            }
            String pattern = sb.toString();
            if ((pattern.equals(zeros)) || (pattern.equals(cross))) {
                return true;
            }
        }
        //Diagonally
        int i = 0;
        int j = 0;
        StringBuilder sb =  new StringBuilder();
        while(i < sz){
            sb.append(board.matrix[i][j]);
            i++;
            j++;
        }
        String pattern = sb.toString();
        if(pattern.equals(zeros) || pattern.equals(cross)){
            return true;
        }

        i = 0; j = sz-1;

         sb =  new StringBuilder();
        while(i < sz && j >= 0){
            sb.append(board.matrix[i][j]);
            i++;
            j--;
        }
        pattern = sb.toString();
        if(pattern.equals(zeros) || pattern.equals(cross)){
            return true;
        }
        return false;
    }
}
