package mid_term;
// 제외

import java.util.Scanner;
final class Problem3 {
    private Triangle triangle;
    public Problem3(int n) {
        // row 와 col 은 보드의 좌측 상단점이 된다.
        int row = 0, col = 0;
        if (n == 1) triangle = new OneStarTriangle(row, col);
        else triangle = new CompositeTriangle(n, row, col);
    }
    public void solve(Board board) {
        triangle.write(board);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        Board board = new Board(n);
        Problem3 p = new Problem3(n);
        p.solve(board);
        board.print();
    }
}
class Board {
    char[][] board;
    public Board(int n) {
        int row = (int) (Math.pow(2, n) - 1);
        int col = (int) (Math.pow(2, n + 1) - 3);
        board = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = '-';
            }
        }
    }
    public void write(int row, int col) {
        board[row][col] = 'x';
    }
    public void print() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : board) {
            for (char c : row)
                sb.append(c);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}