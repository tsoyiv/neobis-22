import java.util.Scanner;

public class URI1176 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numbOfTests = sc.nextInt();

        for (int i = 0; i < numbOfTests; i++) {

            int counter = 0;
            int[] arr = new int[61];
            int inputNumb = sc.nextInt();
            arr[0] = 0;
            arr[1] = 1;

            for (int j = 2; j < inputNumb; j++) {
                arr[j] = arr[j - 1] + arr[j - 2];
                counter++;
            }
            if (inputNumb == 0) {
                System.out.printf("Fib(%d) = %d%n", 0, 0);
            } else {
                System.out.printf("Fib(%d) = %d%n", inputNumb, (counter + 1));
            }
        }
    }
}
