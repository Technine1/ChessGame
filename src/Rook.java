public class Rook extends ChessPiece {

    public Rook(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean canMove(int toX, int toY, ChessBoard board) {
        return x == toX || y == toY;
    }

    @Override
    public boolean isAttacking(int toX, int toY, ChessBoard board) {
        return canMove(toX, toY, board);
    }
}
