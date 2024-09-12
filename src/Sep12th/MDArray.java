package Sep12th;

import java.util.Scanner;

// 퀴즈 1-3 : 다차원 배열 -> 연산
public class MDArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 배열 크기 입력 (N, M)
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // 2D 배열 입력
        int[][] array = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        // 쿼리 개수 입력
        int K = scanner.nextInt();

        // 각 쿼리에 대한 처리
        for (int q = 0; q < K; q++) {
            int i = scanner.nextInt() - 1;  // 쿼리의 시작 행 (1-based -> 0-based)
            int j = scanner.nextInt() - 1;  // 쿼리의 시작 열 (1-based -> 0-based)
            int x = scanner.nextInt() - 1;  // 쿼리의 끝 행 (1-based -> 0-based)
            int y = scanner.nextInt() - 1;  // 쿼리의 끝 열 (1-based -> 0-based)

            // 지정된 범위(i, j)부터 (x, y)까지의 합 계산
            int sum = 0;
            for (int row = i; row <= x; row++) {
                for (int col = j; col <= y; col++) {
                    sum += array[row][col];
                }
            }

            // 결과 출력
            System.out.println(sum);
        }

        scanner.close();
    }
}
