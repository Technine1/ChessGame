public class ChessGame {
    private ChessBoard board;

    public ChessGame() {
        board = new ChessBoard(); // создаем доску с фигурами
    }

    public boolean isCheck(String color) {
        ChessPiece king = board.getKing(color); // Получаем короля
        if (king == null) {
            throw new IllegalStateException("Король не найден на доске для цвета: " + color);
        }

        for (ChessPiece piece : board.getPieces()) {
            if (!piece.getColor().equals(color) && piece.isAttacking(king.getX(), king.getY(), board)) {
                return true; // Если противник атакует короля
            }
        }
        return false; // Если король не под угрозой
    }

    public boolean isCheckmate(String color) {
        if (!isCheck(color)) {
            return false; // Если не в шахе, то не может быть мата
        }

        // Для простоты, проверяем все возможные ходы короля
        ChessPiece king = board.getKing(color);
        if (king == null) {
            throw new IllegalStateException("Король не найден на доске для цвета: " + color);
        }

        // Получаем все возможные ходы короля
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

        for (int i = 0; i < 8; i++) {
            int newX = king.getX() + dx[i];
            int newY = king.getY() + dy[i];

            // Проверяем, что новый ход находится на доске
            if (newX >= 0 && newY >= 0 && newX < 8 && newY < 8) {
                if (!king.isAttacking(newX, newY, board)) {
                    return false; // Если есть хотя бы один ход, то не мат
                }
            }
        }
        return true; // Если все ходы блокированы, то мат
    }

    public static void main(String[] args) {
        ChessGame game = new ChessGame();

        // Пример проверки шаха и мата
        if (game.isCheck("white")) {
            System.out.println("Белый в шахе!");
        }

        if (game.isCheckmate("black")) {
            System.out.println("Черный в мате!");
        }
    }
}