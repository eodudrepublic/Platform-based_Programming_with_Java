package Quiz1;
import java.util.Scanner;

// 퀴즈 1-4 : 하노이의 탑
public class Hanoi {

    // 하노이의 탑 재귀 함수
    public static void hanoi(int n, int from, int to, int aux) {
        // 원반이 1개인 경우 바로 옮기기
        if (n == 1) {
            System.out.println(from + " " + to);
            return;
        }

        // Step 1: n-1개의 원반을 from에서 aux로 이동
        hanoi(n - 1, from, aux, to);

        // Step 2: 마지막 원반을 from에서 to로 이동
        System.out.println(from + " " + to);

        // Step 3: n-1개의 원반을 aux에서 to로 이동
        hanoi(n - 1, aux, to, from);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 원반의 개수 입력 받기
        int N = scanner.nextInt();

        // 최소 이동 횟수는 2^N - 1
        int K = (int) (Math.pow(2, N) - 1);
        System.out.println(K);

        // 하노이 탑 함수 호출 (1번 기둥에서 3번 기둥으로 이동)
        hanoi(N, 1, 3, 2);

        scanner.close();
    }
}
