package mid_term_quiz;

abstract class Triangle {
    protected int row, col;
    protected int height, width;

    public Triangle(int row, int col) {
        this.row = row;
        this.col = col;
    }

    abstract public void write(Board board);
}

class OneStarTriangle extends Triangle {
    public OneStarTriangle(int row, int col) {
        super(row, col);
        this.height = 1;
        this.width = 1;
    }

    @Override
    public void write(Board board) {
        board.write(row, col);
    }
}

class CompositeTriangle extends Triangle {
    private final int n;

    public CompositeTriangle(int n, int row, int col) {
        super(row, col);
        this.n = n;
        this.height = (int) Math.pow(2, n) - 1;
        this.width = (int) Math.pow(2, n + 1) - 3;
    }

    @Override
    public void write(Board board) {
        if (n == 1) {
            board.write(row, col);
            return;
        }

        if (n == 2) {
            // n=2는 특별 처리 (안이 채워진 상태)
            for (int j = 0; j < 5; j++) board.write(row, col + j);       // xxxxx
            for (int j = 1; j < 4; j++) board.write(row + 1, col + j);   // -xxx-
            board.write(row + 2, col + 2);                               // --x--
            return;
        }

        boolean isUpward = n % 2 == 1;
        int mid = width / 2;

        // 큰 삼각형의 테두리만 그리기
        if (isUpward) {
            // 정점
            board.write(row, col + mid);

            // 양쪽 변
            for (int i = 1; i < height; i++) {
                board.write(row + i, col + mid - i);  // 왼쪽
                board.write(row + i, col + mid + i);  // 오른쪽
            }

            // 바닥
            for (int j = 0; j < width; j++) {
                board.write(row + height - 1, col + j);
            }

            // 이전 삼각형 배치 (n-1)
            int prevHeight = (int) Math.pow(2, n-1) - 1;
            int prevWidth = (int) Math.pow(2, n) - 3;
            int innerRow = row + prevHeight;  // +1 제거
            int innerCol = col + mid - (prevWidth / 2);
            Triangle inner = new CompositeTriangle(n-1, innerRow, innerCol);
            inner.write(board);

        } else {
            // 맨 윗줄
            for (int j = 0; j < width; j++) {
                board.write(row, col + j);
            }

            // 양쪽 변
            for (int i = 1; i < height; i++) {
                board.write(row + i, col + i);  // 왼쪽
                board.write(row + i, col + width - 1 - i);  // 오른쪽
            }

            // 이전 삼각형 배치 (n-1)
            int prevHeight = (int) Math.pow(2, n-1) - 1;
            int prevWidth = (int) Math.pow(2, n) - 3;
            int innerRow = row + 1;
            int innerCol = col + (width - prevWidth) / 2;
            Triangle inner = new CompositeTriangle(n-1, innerRow, innerCol);
            inner.write(board);
        }
    }
}