package strings;

import java.util.*;

public class PasswordStrength {

    public static int passwordStrength(String p) {

        HashSet<Character> set = new HashSet<>();

        boolean isSpecial = false;
        int count = 0;

        for (int i = 0; i < p.length(); i++) {

            char ch = p.charAt(i);

            if (Character.isLetter(ch)) {

                if (Character.isUpperCase(ch) && !set.contains(ch)) {
                    count = count + 2;
                    set.add(ch);
                }
                else if (Character.isLowerCase(ch) && !set.contains(ch)) {
                    count = count + 1;
                    set.add(ch);
                }
            }

            else if (Character.isDigit(ch) && !set.contains(ch)) {
                count = count + 3;
                set.add(ch);
            }

            else {
                if (!set.contains(ch)) {
                    count = count + 5;
                    set.add(ch);
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        int strength = passwordStrength(password);

        System.out.println("Password strength: " + strength);

        sc.close();
    }
}
