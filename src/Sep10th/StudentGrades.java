package Sep10th;
import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        int[][] grades = new int[4][3];
        for (int i = 0; i < 4; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println((i + 1) + "번 학생의 성적을 입력하세요 :");
            System.out.print("국어 점수: ");
            grades[i][0] = scanner.nextInt();
            System.out.print("영어 점수: ");
            grades[i][1] = scanner.nextInt();
            System.out.print("수학 점수: ");
            grades[i][2] = scanner.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += grades[i][j];
            }
            System.out.println((i + 1) + "번 학생의 총점: " + sum + ", 평균: " + sum / 3.0);
        }
    }
}
