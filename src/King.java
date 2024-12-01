public class King extends ChessPiece {
    public King(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean canMove(int toX, int toY, ChessBoard board) {
        // Король двигается на одну клетку в любом направлении
        return Math.abs(toX - this.x) <= 1 && Math.abs(toY - this.y) <= 1;
    }

    @Override
    public boolean isAttacking(int toX, int toY, ChessBoard board) {
        return canMove(toX, toY, board); // Король атакует, если может туда сходить
    }
}
