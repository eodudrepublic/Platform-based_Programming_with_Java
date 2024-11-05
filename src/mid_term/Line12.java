import java.util.ArrayList;
import java.util.List;

public class Line12 implements LineFactory {
    private final int n;
    public Line12(int n) {
        this.n = n;
    }

    public List<Line> createLines() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lines.add(new Line2(i, n));
        }
        return lines;
    }

    private static class Line2 implements Line {
        private int n;
        private int m;

        public Line2(int n, int m) {
            this.n = n;
            if (m==1) {
                this.m = 1;
            } else {
                this.m = m * 2;
            }
        }
        @Override
        public void print() {
            if (n % 2 == 0) {
                for (int i = 0; i < m; i ++) {
                    if (i % 2 == 0) {
                        System.out.print("x");
                    } else {
                        System.out.print("-");
                    }
                }
            } else {
                for (int i = 0; i < m; i ++) {
                    if (i % 2 == 0) {
                        System.out.print("-");
                    } else {
                        System.out.print("x");
                    }
                }
            }
            System.out.println();
        }
    }
}
