import java.util.Scanner;

public class URI1165 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numbOfTests = sc.nextInt();

        for (int i = 0; i < numbOfTests; i++) {
            int inputNum = sc.nextInt();
            int checkingSumForPrimeNumber = 0;

            for (int j = 1; j <= inputNum; j++) {
                if (inputNum % j == 0) {
                    checkingSumForPrimeNumber += j;
                }
            }
            if (checkingSumForPrimeNumber == (inputNum + 1)) {
                System.out.println(inputNum + " eh primo");
            } else {
                System.out.println(inputNum + " nao eh primo");
            }
        }
    }
}