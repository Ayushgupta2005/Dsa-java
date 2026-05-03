package MultiDimentional_Arrays;

public class SpiralMatrix {
    public static void main(String[] args) {
        

    int arr[][] = {{1,2,3,4,5,6}, {7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30}};

    int fc =0;
    int fr=0;
    int lc= arr[0].length-1;
    int lr=arr.length-1;


    while(fr<=lr && fc<=lc){
        System.out.println();
        for(int i=fc; i<=lc; i++){
            System.out.print(arr[fr][i]+ " ");
        }
        fr++;

        if(fr>lr || fc>lc){
            break;
        }
        else {
            System.out.println();
            for(int i=fr; i<=lr; i++){
                System.out.print(arr[i][lc]+ " ");
            }
            lc--;
        }
        if(fr>lr || fc>lc){
            break;
        }
        else{
            System.out.println();
            for(int i=lc; i>=fc; i--){
                System.out.print(arr[lr][i]+ " ");
            }
            lr--;
        }
        if(fr>lr || fc>lc){
            break;
        }
        else{
            System.out.println();
            for(int i=lr; i>=fr; i--){
                System.out.print(arr[i][fc]+ " ");
            }
            fc++;
        }


    }
    
}
}
