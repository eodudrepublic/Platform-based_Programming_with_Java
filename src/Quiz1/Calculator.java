package Quiz1;
import java.util.Scanner;

// 퀴즈 1-2 : 계산기
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[100];  // 최대 100개의 값을 저장할 배열
        int index = 0;  // 현재 배열의 인덱스를 저장하는 변수

        while (true) {
            String command = scanner.next();  // 명령을 대문자로 변환하여 받음

            if (command.equals("QUIT")) {  // QUIT 명령 시 프로그램 종료
                System.out.print("Bye");
                break;
            }

            switch (command) {
                case "ADD":  // 숫자를 추가하는 경우
                    int number = scanner.nextInt();
                    boolean duplicate = false;

                    // 중복 체크
                    for (int i = 0; i < index; i++) {
                        if (arr[i] == number) {
                            System.out.println("The Same Number");
                            duplicate = true;
                            break;
                        }
                    }

                    // 중복이 아닌 경우 배열에 추가
                    if (!duplicate && index < arr.length) {
                        arr[index++] = number;
                    }
                    break;

                case "LIST":  // 배열에 저장된 값을 출력
                    if (index > 0) {
                        for (int i = 0; i < index; i++) {
                            System.out.print(arr[i] + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("No values in the list");
                    }
                    break;

                case "SUM":  // 저장된 값들의 합을 출력
                    int sum = 0;
                    for (int i = 0; i < index; i++) {
                        sum += arr[i];
                    }
                    System.out.println(sum);
                    break;

                case "MAX":  // 저장된 값 중 최댓값 출력
                    if (index > 0) {
                        int max = arr[0];
                        for (int i = 1; i < index; i++) {
                            if (arr[i] > max) {
                                max = arr[i];
                            }
                        }
                        System.out.println(max);
                    }
                    break;

                case "MIN":  // 저장된 값 중 최솟값 출력
                    if (index > 0) {
                        int min = arr[0];
                        for (int i = 1; i < index; i++) {
                            if (arr[i] < min) {
                                min = arr[i];
                            }
                        }
                        System.out.println(min);
                    }
                    break;

                case "AVG":  // 저장된 값들의 평균 출력
                    if (index > 0) {
                        int total = 0;
                        for (int i = 0; i < index; i++) {
                            total += arr[i];
                        }
                        double avg = (double) total / index;
                        System.out.println(avg);
                    }
                    break;

                default:  // 잘못된 명령 처리
                    System.out.println("Invalid Command");
            }
        }
        scanner.close();
    }
}
