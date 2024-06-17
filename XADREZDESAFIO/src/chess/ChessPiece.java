package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece{
    private Color color;

    // ele obriga a passar um board porque a classe pai exige um board
    public ChessPiece(Board board, Color color){
        super(board);
        this.color = color;
    }

    public Color getColor(){
        return color;
    }


}