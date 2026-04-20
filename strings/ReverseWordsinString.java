package strings;


public class ReverseWordsinString {

    public static void main(String[] args) {
        String s = "name is Ayush";
        StringBuilder str = new StringBuilder();

        int j = s.length() - 1;

        while (j >= 0) {

            // skip spaces
            while (j >= 0 && s.charAt(j) == ' ') j--;

            int end = j;

            // find start of word
            while (j >= 0 && s.charAt(j) != ' ') j--;

            // append word
            str.append(s.substring(j + 1, end + 1)).append(" ");
        }

        System.out.println(str.toString().trim());
    }
}