package arrays.MultiDimentional_Arrays;

/*
 * Problem: Nearest Available Drone (LeetCode 4024)
 *
 * For each drone, check if the target is within its range (Manhattan
 * distance <= range). Among all reachable drones, track the one with the
 * smallest distance; strict '<' naturally keeps the smaller index on ties.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class NearestAvailableDrone {

    public int nearestDrone(int[][] drones, int[] target) {

        int x2= target[0];
        int y2=target[1];

        int min=Integer.MAX_VALUE;
        int ans=-1;

        for(int i=0; i<drones.length; i++){
            int x1 = drones[i][0];
            int y1= drones[i][1];
            int c= drones[i][2];

            int a =Math.abs(x1-x2);
            int b=Math.abs(y1-y2);
            if(a+b<=c){
                if(a+b<min){
                    min=a+b;
                    ans=i;
                }
            }

        }
        return ans;

    }

    public static void main(String[] args) {
        NearestAvailableDrone obj = new NearestAvailableDrone();

        System.out.println(obj.nearestDrone(new int[][]{{0,0,8},{2,2,9}}, new int[]{3,4})); // Expected: 1
        System.out.println(obj.nearestDrone(new int[][]{{0,0,1}}, new int[]{5,5}));         // Expected: -1
    }
}
