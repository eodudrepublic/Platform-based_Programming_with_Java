package Quiz3;

import java.util.ArrayList;
import java.util.List;

public class Pr10990 implements LineFactory {
    int input;

    public Pr10990(int input) {
        this.input = input;
    }

    @Override
    public int numOfLines() {
        return input;
    }

    @Override
    public Line create(int lineNum) {
        List<Content> contents = new ArrayList<>();

        if (lineNum == 1) {
            contents.add(new Characters('-', input - 1));
            contents.add(new Characters('x', 1));
            contents.add(new Characters('-', input - 1));
        } else {
            contents.add(new Characters('-', input - lineNum));
            contents.add(new CharactersWithStars(new Characters('-', 2 * lineNum - 3)));
            contents.add(new Characters('-', input - lineNum));
        }

        return new Line(contents);
    }

    public static class CharactersWithStars implements Content {
        private final Content content;

        public CharactersWithStars(Content content) {
            this.content = content;
        }

        @Override
        public void print() {
            System.out.print("x");
            content.print();
            System.out.print("x");
        }
    }
}
