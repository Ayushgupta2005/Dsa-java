// two sum brute force approach (Leetcode Q-1 arrays)

public class Two_sum1 {
    public static void main(String[] args) {
        
    

    int arr[]={2,7,11,15};
    int target =9;

    int n[] = new int[2];

    for (int i=0; i<arr.length; i++){
        for (int j=i+1; j<arr.length; j++){
            if (arr[i]+ arr[j]==target){
                n[0]=i;
                n[1]=j;
            }
        }
    }

    for (int i=0; i<n.length; i++){
        System.out.print(n[i]+ " ");
    }

    }
    
}
