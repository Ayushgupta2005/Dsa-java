package strings;

public class magicalString {
    public int magicalString(int n) {

        if(n==1 || n==2 || n==3){
            return 1;
        }


        int i =2;

        StringBuilder str = new StringBuilder();
        str.append("122");
        
        boolean a=true;

        while(str.length()<n){

            if(str.charAt(i)=='2' && a==true){
                str.append("11");
                a=!a;
                i++;
            }
            else if(str.charAt(i)=='2' && a==false){
                str.append("22");
                a=!a;
                i++;
            }
            else if(str.charAt(i)=='1' && a==false){
                str.append('2');
                i++;
                a=!a;
            }
            else{
                str.append('1');
                a=!a;
                i++;
            }

        }

        int count =0;

        for(int k=0; k<n; k++){
            if(str.charAt(k)=='1'){
                count ++;
            }
        }
        return count;
        
    }
}
    
