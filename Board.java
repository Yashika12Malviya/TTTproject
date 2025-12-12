package Board;

public class board {
    public int size;
    public char[][] matrix;


    public board(int size, char symbol){
        this.size = size;
        matrix = new char[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                matrix[i][j] = symbol;
            }
        }
    }
     public void printboardconfig(){
        int si = this.size;

        for(int i = 0; i < si; i++){
            for(int j = 0;j < si; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}


