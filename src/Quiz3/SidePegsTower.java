package Quiz3;

import java.util.ArrayList;
import java.util.List;

interface Tower {
    int move();
}

public class SidePegsTower implements Tower {
    private List<Tower> towers = new ArrayList<>();
    private int numOfDisks;

    public SidePegsTower(int numOfDisks) {
        this.numOfDisks = numOfDisks;

        if (numOfDisks <= 0) {
            // 이동할 디스크가 없음
        } else if (numOfDisks == 1) {
            // 기저 사례: 양쪽의 디스크를 중앙으로 이동
            towers.add(new SingleDiscTower("A", "B"));
            towers.add(new SingleDiscTower("C", "B"));
        } else {
            // Image 4의 분해도에 따른 7단계 이동
            towers.add(new SidePegsTower(numOfDisks - 2));           // n-2개 디스크 처리
            towers.add(new SingleDiscTower("C", "A"));               // 한 개를 C에서 A로
            towers.add(new MultiDiscsTower(numOfDisks - 2, "B", "C", true));  // n-2개를 B에서 C로
            towers.add(new SingleDiscTower("C", "B"));               // 한 개를 C에서 B로
            towers.add(new MultiDiscsTower(numOfDisks - 1, "A", "B", false)); // n-1개를 A에서 B로
            towers.add(new SingleDiscTower("A", "B"));               // 한 개를 A에서 B로
            towers.add(new MultiDiscsTower(numOfDisks - 1, "C", "B", false)); // n-1개를 C에서 B로
        }
    }

    @Override
    public int move() {
        int totalMoves = 0;
        for (Tower tower : towers) {
            totalMoves += tower.move();
        }
        return totalMoves;
    }
}

class SingleDiscTower implements Tower {
    private String from;
    private String to;

    public SingleDiscTower(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public int move() {
        return 1;
    }
}

class MultiDiscsTower implements Tower {
    private int numOfDisks;
    private String from;
    private String to;
    private boolean isIntermediate; // 중간 이동인지 최종 이동인지 구분

    public MultiDiscsTower(int numOfDisks, String from, String to, boolean isIntermediate) {
        this.numOfDisks = numOfDisks;
        this.from = from;
        this.to = to;
        this.isIntermediate = isIntermediate;
    }

    @Override
    public int move() {
        if (numOfDisks <= 0) return 0;
        if (numOfDisks == 1) return 1;

        if (isIntermediate) {
            // 중간 이동(B에서 C로)의 경우
            return (1 << (numOfDisks - 1)); // 2^(n-1)
        } else {
            // 최종 이동(A에서 B로 또는 C에서 B로)의 경우
            return (1 << numOfDisks) - 1; // 2^n - 1
        }
    }
}