package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece [] [] GetPieces() {
        ChessPiece [][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i<board.getRows(); i++) {
            for (int j=0; j<board.getColumns(); j++) {
                mat[i] [j] = (ChessPiece)board.piece(i, j);
            }
        }
        return mat;
    }
    private void placeNewPiace(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup(){
        placeNewPiace('b', 6, new Rook(board, Color.WHITE));
        placeNewPiace('e', 8, new King(board, Color.BLACK));
        placeNewPiace('e', 1, new King(board, Color.WHITE));
    }
}
