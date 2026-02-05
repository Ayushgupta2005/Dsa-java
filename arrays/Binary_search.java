class Binary_search{
    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5};

        int i=0;
        int j= arr.length-1;
        int x=2;

        while (i<=j){
            int mid = (i+j)/2;
            if (arr[mid]==x){
                System.out.println(mid);
                return;
            }
            else{
                if(x>arr[mid]){
                    i=mid+1;
                }
                else{
                    j=mid-1;
                }
            }
        }

    }
}
/*
Problem: Binary Search
Approach: Iterative binary search
Time: O(log n)
Space: O(1)
*/
