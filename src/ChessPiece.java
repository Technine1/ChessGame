public abstract class ChessPiece {
    private String color;
    private int x, y;

    public ChessPiece(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Абстрактный метод для проверки возможных ходов
    public abstract boolean canMove(int toX, int toY);

    // Метод для проверки атаки
    public boolean isAttacking(int targetX, int targetY, ChessBoard board) {
        // Атака для большинства фигур будет то же самое, что и проверка хода
        return canMove(targetX, targetY);
    }

    // Общий метод для перемещения фигуры (будет использоваться в ChessBoard)
    public void move(int x, int y) {
        setPosition(x, y);
    }
}

