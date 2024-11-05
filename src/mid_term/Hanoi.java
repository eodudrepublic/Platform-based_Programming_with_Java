package mid_term;

public class Hanoi {
    private final int n;
    private final int from;
    private final int to;
    private final int buffer;

    public Hanoi(int _n) {
        n = _n;
        from = 1;
        to = 3;
        buffer = 2;
    }

    public Hanoi(int _n, int _from, int _to, int _buffer) {
        n = _n;
        from = _from;
        to = _to;
        buffer = _buffer;
    }

    public void moveDisks() {
        if (n == 1) {
            System.out.println(from + " " + to);
        } else {
            Hanoi first = new Hanoi(n - 1, from, buffer, to);
            Hanoi third = new Hanoi(n - 1, buffer, to, from);
            first.moveDisks();
            System.out.println(from + " " + to);
            third.moveDisks();
        }
    }

    public void print() {
        int moveCount = (int) Math.pow(2, n) - 1;
        if(n < 20) {
            System.out.println(moveCount);
            moveDisks();
        } else {
            System.out.println(moveCount);
        }
    }

    public static void main(String[] args) {
        Hanoi tower = new Hanoi(2);
        tower.print();
    }
}