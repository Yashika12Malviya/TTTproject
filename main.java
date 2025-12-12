import  Board.board;
import Player.player;
import Game.Game;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("First project -> TicTacToe");

        board b = new board(3, '-');
        b.printboardconfig();

//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter the Name of the player : ");
//        String name = in.nextLine();
//        System.out.print("Enter the Symbol of the player : ");
//        char symbol = in.nextLine().charAt(0);

        player p1 = new player();
        p1.setPlayerNameSymbol("ravi", 'X');
        p1.getPlayerNameandSymbol();

        player p2 = new player();
        p2.setPlayerNameSymbol("akash", '0');
        p2.getPlayerNameandSymbol();

        Game game = new Game(new player[]{p1, p2}, b);
        game.play();

}
}
