import java.util.Scanner;

public class URI2242 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String vowels = "aeuoyi";
        String laughSequence = sc.next();
        StringBuilder reverse = new StringBuilder();
        StringBuilder s = new StringBuilder();

        for (int i = 0, j = laughSequence.length() - 1; j >= 0; i++, j--) {
            if (vowels.contains(laughSequence.charAt(j) + "")) {
                reverse.append(laughSequence.charAt(j));
            }
            if (vowels.contains(laughSequence.charAt(i) + "")) {
                s.append(laughSequence.charAt(i));
            }
        }
        if (s.toString().equals(reverse.toString())) {
            System.out.println("S");
        } else {
            System.out.println("N");
        }
    }
}