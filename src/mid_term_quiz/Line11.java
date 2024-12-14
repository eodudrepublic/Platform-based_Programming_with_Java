package mid_term_quiz;

import java.util.ArrayList;
import java.util.List;

public class Line11 implements LineFactory {
    private final int n;
    public Line11(int n) {
        this.n = n;
    }

    @Override
    public List<Line> createLines() {
        List<Line> lines = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            lines.add(new Line1(i, n));
        }
        return lines;
    }

    private static class Line1 implements Line {
        private int n;
        private int m;

        public Line1(int n, int m) {
            this.n = n;
            this.m = m;
        }
        @Override
        public void print() {
            for (int i = 0; i < m - n; i ++) {
                System.out.print("-");
            }
            for (int i = 0; i < n; i ++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}