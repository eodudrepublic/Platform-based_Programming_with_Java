package Quiz3;

import java.util.ArrayList;
import java.util.List;

public class Pr10991 implements LineFactory {
    int input;

    public Pr10991(int input) {
        this.input = input;
    }

    @Override
    public int numOfLines() {
        return input;
    }

    @Override
    public Line create(int lineNum) {
        // 과제에선 Quiz3.Content 대신 Characters를 사용해야 함
        List<Content> contents = new ArrayList<>();

        if (lineNum == 1) {
            contents.add(new Characters('-', input - 1));
            contents.add(new Characters('x', 1));
            contents.add(new Characters('-', input - 1));
        } else {
            contents.add(new Characters('-', input - lineNum));
            for (int i = 0; i < 2 * lineNum - 1; i++) {
                if (i % 2 == 0) {
                    contents.add(new Characters('x', 1));
                } else {
                    contents.add(new Characters('-', 1));
                }
            }
            contents.add(new Characters('-', input - lineNum));
        }

        return new Line(contents);
    }
}
