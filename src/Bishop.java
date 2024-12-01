public class Bishop extends ChessPiece {

    public Bishop(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean canMove(int toX, int toY, ChessBoard board) {
        return Math.abs(toX - x) == Math.abs(toY - y);
    }

    @Override
    public boolean isAttacking(int toX, int toY, ChessBoard board) {
        boolean canMove = canMove(toX, toY, board);
        return canMove;
    }
}
