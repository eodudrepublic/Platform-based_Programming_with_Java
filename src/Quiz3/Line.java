package Quiz3;

import java.util.List;

public class Line {
    private final List<Content> charactersList;

    public Line(List<Content> charactersList) {
        this.charactersList = charactersList;
    }

    public void print() {
        for (Content characters : charactersList) {
            characters.print();
        }
        System.out.println();
    }
}