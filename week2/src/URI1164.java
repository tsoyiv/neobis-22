import java.util.Scanner;

public class URI1164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numbOfTests = sc.nextInt();

        for (int i = 0; i < numbOfTests; i++) {
            int inputNumber = sc.nextInt();
            int sum = 0;

            for (int j = 1; j < inputNumber; j++) {
                if (inputNumber % j == 0) {
                    sum += j;
                }
            }
            if (sum == inputNumber) {
                System.out.println(inputNumber + " eh perfeito");
            } else {
                System.out.println(inputNumber + " nao eh perfeito");
            }
        }
    }
}
