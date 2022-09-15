import java.util.Scanner;

public class URI1145 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int firstNum = sc.nextInt();
        int lastNum = sc.nextInt();

        for (int i = 1; i <= lastNum; i++) {
            System.out.print(i);
            if (i % firstNum == 0) {
                System.out.println("");
            } else {
                System.out.print(" ");
            }
        }
    }
}