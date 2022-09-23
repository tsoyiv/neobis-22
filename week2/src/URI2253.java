import java.util.Scanner;

public class URI2253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String password;
        boolean isSize;
        boolean isUpperCase;
        boolean isLowerCase;
        boolean isDigit;
        boolean isSpace;

        while (sc.hasNextLine()) {
            password = String.valueOf(sc.nextLine().toCharArray());
            isSize = false;
            isUpperCase = false;
            isLowerCase = false;
            isDigit = false;
            isSpace = false;

            for (char index : password.toCharArray()) {
                if (6 <= password.length() && password.length() <= 32) {
                    isSize = true;
                }
                if (Character.isUpperCase(index)) {
                    isUpperCase = true;
                } else if (Character.isLowerCase(index)) {
                    isLowerCase = true;
                } else if (Character.isDigit(index)) {
                    isDigit = true;
                } else {
                    isSpace = true;
                }

            }
            if (!isSpace && isUpperCase && isLowerCase && isDigit && isSize) {
                System.out.println("Senha valida.");
            } else {
                System.out.println("Senha invalida.");
            }
        }
    }
}