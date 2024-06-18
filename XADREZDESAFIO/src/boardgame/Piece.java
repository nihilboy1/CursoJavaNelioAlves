package boardgame;

public abstract class Piece{
    protected Position position;
    private Board board;

    public Piece(Board board){
        this.board = board;
        position = null;
    }

    protected Board getBoard(){
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position){
        return possibleMoves()[position.getRow()][position.getColumn()];
    }


    public boolean isThereAnyPossibleMove(){
        boolean[][] boolMatrix = possibleMoves();
        for(int i = 0; i < boolMatrix.length; i++){
            for(int j = 0; j < boolMatrix.length; j++){
                if(boolMatrix[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

}
