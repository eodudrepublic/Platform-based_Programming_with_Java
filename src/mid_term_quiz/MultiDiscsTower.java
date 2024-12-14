package mid_term_quiz;

public class MultiDiscsTower implements Tower {
    private int n;

    public MultiDiscsTower(int n) {
        this.n = n;
    }

    @Override
    public int move() {
        if (n <= 0) return 0;

        // dp[i]는 i개의 원판을 옮기는데 필요한 최대 이동 횟수
        int[] dp = new int[n + 1];

        // 기본 케이스: 1개의 원판은 A->B->C로 2번 이동
        dp[1] = 2;

        // 2개 이상의 원판에 대해 계산
        for (int i = 2; i <= n; i++) {
            // i개의 원판을 옮기기 위해서는:
            // 1. i-1개의 원판을 최대한 많이 움직여서 적절한 위치로 이동
            // 2. i번째 원판을 A->B->C로 이동
            // 3. 나머지 원판들을 다시 최대한 많이 움직여서 최종 위치로 이동
            dp[i] = 3 * dp[i-1] + 2;
        }

        return dp[n];
    }
}