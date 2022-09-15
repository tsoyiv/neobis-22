import java.util.Scanner;

public class URI1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTests = sc.nextInt();

        String words;
        char[] a;
        for (int i = 0; i < numberOfTests; i++) {
            words = sc.next();
            a = words.toCharArray();
            int shift = sc.nextInt();

            for (int j = 0; j < a.length; j++) {
                if (a[j] - 65 < shift) {
                    for (int k = 0; k < shift; k++) {
                        if (a[j] == 'A') {
                            a[j] = 'Z';
                        } else {
                            a[j]--;
                        }
                    }
                } else {
                    a[j] -= shift;
                }
            }
            System.out.println(a);
        }
    }
}