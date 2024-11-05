package Quiz3;

public class Characters implements Content {
    private final int count;
    private final char character;

    public Characters(char character, int count) {
        this.character = character;
        this.count = count;
    }

    @Override
    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(character);
        }
    }
}