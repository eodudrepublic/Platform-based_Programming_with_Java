import static java.lang.Math.abs;

public class MultiDiscsTower implements Tower {
    private int n;
    private final int from;
    private final int to;
    private final int buffer;

    public MultiDiscsTower(int _n) {
        this.n = _n;
        from = 1;
        to = 3;
        buffer = 2;
    }

    public MultiDiscsTower(int _n, int _from, int _to, int _buffer) {
        n = _n;
        from = _from;
        to = _to;
        buffer = _buffer;
    }

    public int move() {
        if (n == 1) {
//            System.out.println("Move disc from " + from + " to " + to);
//            System.out.println(abs(from - to));
            return abs(from - to);
        } else {
            MultiDiscsTower first = new MultiDiscsTower(n - 1, from, buffer, to);
            MultiDiscsTower second = new MultiDiscsTower(1, from, to, buffer);
            MultiDiscsTower third = new MultiDiscsTower(n - 1, buffer, to, from);
            return first.move() + second.move() + third.move();
        }
    }
}
