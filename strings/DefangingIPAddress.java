package strings;

/*
 * Problem: Defanging an IP Address (LeetCode 1108)
 *
 * Replace every '.' in the address with "[.]".
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class DefangingIPAddress {
    public String defangIPaddr(String address) {
        StringBuilder str = new StringBuilder();

        for(int i=0; i<address.length(); i++){
            if(address.charAt(i)=='.'){
                str.append("[.]");
            }
            else{
                str.append(address.charAt(i));
            }
        }

        return str.toString();

    }

    public static void main(String[] args) {
        DefangingIPAddress obj = new DefangingIPAddress();
        System.out.println(obj.defangIPaddr("1.1.1.1"));         // Expected: 1[.]1[.]1[.]1
        System.out.println(obj.defangIPaddr("255.100.50.0"));    // Expected: 255[.]100[.]50[.]0
    }
}
