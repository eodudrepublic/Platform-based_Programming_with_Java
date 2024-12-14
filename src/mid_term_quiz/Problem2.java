package mid_term_quiz;

import java.util.Scanner;

class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        Tower tower = new MultiDiscsTower(n);
        System.out.println(tower.move());
    }
}
interface Tower {
    int move();
}