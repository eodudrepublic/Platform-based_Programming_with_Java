package Quiz3;

public interface LineFactory {
    int numOfLines();
    Line create(int lineNum);
}