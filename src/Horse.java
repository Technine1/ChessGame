public class Horse extends ChessPiece {

    public Horse(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean canMove(int toX, int toY, ChessBoard board) {
        int dx = Math.abs(toX - this.x);
        int dy = Math.abs(toY - this.y);
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }

    @Override
    public boolean isAttacking(int toX, int toY, ChessBoard board) {
        return canMove(toX, toY, board);
    }
}
