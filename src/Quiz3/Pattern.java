package Quiz3;

public class Pattern {
    private final Line[] lines;

    public Pattern(LineFactory factory) {
        int numOfLines = factory.numOfLines();
        lines = new Line[numOfLines];
        for (int i = 0; i < numOfLines; i++) {
            lines[i] = factory.create(i+1);
        }
    }

    public void print() {
        for (Line line : lines) {
            line.print();
        }
    }
}
