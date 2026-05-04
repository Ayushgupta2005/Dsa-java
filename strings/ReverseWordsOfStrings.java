package strings;

public class ReverseWordsOfStrings {

    public static void reverse(int i, int j, char[] arrr){
        while(i < j){
            char temp = arrr[i];
            arrr[i] = arrr[j];
            arrr[j] = temp;

            i++;
            j--;
        }
    }

    public static void main(String[] args) {

        String str ="Bishal is a bad boy";

        int i=0;
        int j=0;

        char arr[] = str.toCharArray();

        while(j<arr.length){
            if(j==arr.length-1){
                reverse(i,j,arr);
                j++;
            }
            else if(arr[j]==' '){
                reverse(i,j-1,arr);
                i=j+1;
                j++;
            }
            else{
                j++;
            }
        }

        System.out.println(new String(arr));
    }
}
    