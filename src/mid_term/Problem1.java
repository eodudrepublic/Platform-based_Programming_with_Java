package mid_term;
// 제외
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        Pattern pattern = new Pattern(new Line12(n));
        pattern.print();
    }
}
class Pattern {
    List<Line> lines = new ArrayList<>();
    public Pattern(LineFactory factory) {
        lines.addAll(factory.createLines());
    }
    public void print() {
        for (Line line : lines) {
            line.print();
        }
    }
}
interface Line {
    void print();
}
interface LineFactory {
    List<Line> createLines();
}