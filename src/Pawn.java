public class Pawn extends ChessPiece {

    public Pawn(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean canMove(int toX, int toY) {
        return false;
    }

    @Override
    public boolean canMove(int toX, int toY, ChessBoard board) {
        int direction = color.equals("white") ? 1 : -1;
        if (x == toX && (y + direction == toY || (y == (color.equals("white") ? 1 : 6) && y + 2 * direction == toY))) {
            return true;
        }
        return Math.abs(toX - x) == 1 && Math.abs(toY - y) == 1; // Пешка бьет по диагонали
    }

    @Override
    public boolean isAttacking(int toX, int toY, ChessBoard board) {
        return Math.abs(toX - x) == 1 && Math.abs(toY - y) == 1;
    }
}