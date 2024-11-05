package Quiz3;

import java.util.ArrayList;
import java.util.List;

public class SidePegsTower implements Tower {
    List<Tower> towers = new ArrayList<>();
    private int numOfDisks;

    public SidePegsTower(int numOfDisks) {
        this.numOfDisks = numOfDisks;

        if (numOfDisks <= 0) {
            // 이동할 디스크가 없습니다.
        } else if (numOfDisks == 1) {
            // 기저 사례: A와 C에서 B로 디스크를 이동
            towers.add(new SingleDiscTower("A", "B"));
            towers.add(new SingleDiscTower("C", "B"));
        } else {
            // 객체 분해 구조에 따라 타워 구성
            towers.add(new SidePegsTower(numOfDisks - 2));
            towers.add(new SingleDiscTower("C", "A"));
            towers.add(new MultiDiscsTower(numOfDisks - 2, "B", "C", "A"));
            towers.add(new SingleDiscTower("C", "B"));
            towers.add(new MultiDiscsTower(numOfDisks - 1, "A", "B", "C"));
            towers.add(new SingleDiscTower("A", "B"));
            towers.add(new MultiDiscsTower(numOfDisks - 1, "C", "A", "B"));
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

interface Tower {
    int move();
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
        // 한 개의 디스크를 이동하는 데는 1번의 이동이 필요합니다.
        return 1;
    }
}

class MultiDiscsTower implements Tower {
    private int numOfDisks;
    private String from;
    private String to;
    private String aux;

    public MultiDiscsTower(int numOfDisks, String from, String to, String aux) {
        this.numOfDisks = numOfDisks;
        this.from = from;
        this.to = to;
        this.aux = aux;
    }

    @Override
    public int move() {
        if (numOfDisks <= 0) {
            return 0;
        } else if (numOfDisks == 1) {
            // 한 개의 디스크를 이동하는 경우
            return 1;
        } else {
            // 재귀적으로 이동 횟수 계산
            MultiDiscsTower firstPart = new MultiDiscsTower(numOfDisks - 1, from, aux, to);
            SingleDiscTower moveLargestDisk = new SingleDiscTower(from, to);
            MultiDiscsTower secondPart = new MultiDiscsTower(numOfDisks - 1, aux, to, from);
            return firstPart.move() + moveLargestDisk.move() + secondPart.move();
        }
    }
}
