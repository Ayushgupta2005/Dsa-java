package strings;
// Given two binary strings a and b, return their sum as a binary string.
public class ReturnBinary {
    public String addBinary(String a, String b) {

        StringBuilder str = new StringBuilder();

        int i = a.length()-1;
        int j= b.length()-1;
        int carry =0;

        while(i>=0 || j>=0 || carry >0){
            int sum=0;

            if(i>=0){
                sum = sum + a.charAt(i)-'0';
                i--;           }
            if (j>=0){
                sum = sum + b.charAt(j) -'0';
                j--;
            }
            sum = sum+carry;

            str.append(sum%2);

            if(sum>1){
                carry =1;
            }
            else{
                carry =0;
            }


        }
        String str2 = str.reverse().toString();

        return str2;
        
    }
}