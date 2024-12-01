import java.util.ArrayList;
import java.util.List;

public class ChessBoard {
    private List<ChessPiece> pieces;

    public ChessBoard() {
        pieces = new ArrayList<>();
        // Инициализация фигур
        pieces.add(new Rook("white", 0, 0));
        pieces.add(new Horse("white", 1, 0));  // Заменили Knight на Horse
        pieces.add(new Bishop("white", 2, 0));
        pieces.add(new Queen("white", 3, 0));  // Если нужно, добавьте класс Queen
        pieces.add(new King("white", 4, 0));
        pieces.add(new Bishop("white", 5, 0));
        pieces.add(new Horse("white", 6, 0));  // Заменили Knight на Horse
        pieces.add(new Rook("white", 7, 0));

        pieces.add(new Rook("black", 0, 7));
        pieces.add(new Horse("black", 1, 7));  // Заменили Knight на Horse
        pieces.add(new Bishop("black", 2, 7));
        pieces.add(new Queen("black", 3, 7));  // Добавим и для черных фигур
        pieces.add(new King("black", 4, 7));
        pieces.add(new Bishop("black", 5, 7));
        pieces.add(new Horse("black", 6, 7));  // Заменили Knight на Horse
        pieces.add(new Rook("black", 7, 7));
    }

    public ChessPiece getPieceAt(int x, int y) {
        for (ChessPiece piece : pieces) {
            if (piece.getX() == x && piece.getY() == y) {
                return piece;
            }
        }
        return null;
    }

    public void printBoard() {
        String[][] board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = ".";
            }
        }

        for (ChessPiece piece : pieces) {
            board[piece.getY()][piece.getX()] = piece.getClass().getSimpleName().charAt(0) + "";  // Просто первая буква класса
        }

        // Выводим доску
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Проверка на шах
    public boolean isCheck(String color) {
        ChessPiece king = getKing(color);
        for (ChessPiece piece : pieces) {
            ChessBoard board = null;
            if (!piece.getColor().equals(color) && piece.isAttacking(king.getX(), king.getY(), board)) {
                return true;
            }
        }
        return false;
    }

    // Получить короля
    public ChessPiece getKing(String color) {
        for (ChessPiece piece : pieces) {
            if (piece instanceof King && piece.getColor().equals(color)) {
                return piece;
            }
        }
        return null;
    }

    public void getPieces() {
    }
}