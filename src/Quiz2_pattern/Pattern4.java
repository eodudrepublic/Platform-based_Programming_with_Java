package Quiz2_pattern;

public class Pattern4 {
    private final Line[] lines;

    public Pattern4(int totalLines) {
        lines = new Line[totalLines];
        for (int i = 0; i < totalLines; i++) {
            lines[i] = new Line(totalLines, i);
        }
    }

    public void print() {
        for (Line line : lines) {
            line.print();
        }
    }

    public static class Line {
        private final Characters first;
        private final Characters mid;
        private final Characters last;

        public Line(int totalLines, int currentLine) {
            first = new Characters("-", currentLine);
            mid = new Characters("x", totalLines - currentLine);
            last = new Characters("", 0);
        }

        public void print() {
            first.print();
            mid.print();
            last.print();
            System.out.println();
        }
    }

    public static class Characters {
        private final int count;
        private final String character;

        public Characters(String character, int count) {
            this.character = character;
            this.count = count;
        }

        public void print() {
            for (int i = 0; i < count; i++) {
                System.out.print(character);
            }
        }
    }
}