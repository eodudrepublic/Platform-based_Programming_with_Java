package mid_term;
// 제외

class OneStarTriangle implements Triangle {
    private int row;
    private int col;
    public OneStarTriangle(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public void write(Board board) {
        board.write(row, col);
    }
}

class CompositeTriangle implements Triangle {
    private int n;
    private int row;
    private int col;
    public CompositeTriangle(int n, int row, int col) {
        this.n = n;
        this.row = row;
        this.col = col;
    }
    public void write(Board board) {
        int size = (int) Math.pow(2, n - 1);
        Triangle triangle = new OneStarTriangle(row, col);
        triangle.write(board);
        triangle = new CompositeTriangle(n - 1, row, col + size);
        triangle.write(board);
        triangle = new CompositeTriangle(n - 1, row + size, col + size);
        triangle.write(board);
    }
}

interface Triangle {
    void write(Board board);
}