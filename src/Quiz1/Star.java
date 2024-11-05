package Quiz1;
import java.util.Scanner;

// 퀴즈 1-1 : 별찍기
public class Star {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print('*');
            }
            for (int j = 1; j <= (num - i) * 2; j++) {
                System.out.print(' ');
            }
            for (int j = 1; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
        for (int i = num - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print('*');
            }
            for (int j = 1; j <= (num - i) * 2; j++) {
                System.out.print(' ');
            }
            for (int j = 1; j <= i; j++) {
                System.out.print('*');
            }
            if (i != 1) {System.out.println();}
        }
    }
}
