public class Queen extends ChessPiece {

    public Queen(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean canMove(int toX, int toY, ChessBoard board) {
        return x == toX || y == toY || Math.abs(toX - x) == Math.abs(toY - y);
    }

    @Override
    public boolean isAttacking(int toX, int toY, ChessBoard board) {
        return canMove(toX, toY, board);
    }
}
