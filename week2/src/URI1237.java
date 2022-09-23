import java.util.Scanner;

public class URI1237 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first;
        String second;

        int counter;
        int max;

        while (sc.hasNextLine()) {
            first = sc.nextLine();
            second = sc.nextLine();
            max = 0;

            for (int i = 0; i < first.length(); i++) {
                for (int j = 0; j < second.length(); j++) {
                    int temp1 = i;
                    int temp2 = j;
                    counter = 0;
                    while (temp1 < first.length() && temp2 < second.length() && first.charAt(temp1) == second.charAt(temp2)) {
                        temp1++;
                        temp2++;
                        counter++;
                    }
                    if (max < counter) {
                        max = counter;
                    }
                }
            }
            System.out.println(max);
        }
    }
}