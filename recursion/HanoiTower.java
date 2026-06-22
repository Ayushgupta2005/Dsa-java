package recursion;

public class HanoiTower {

    public static int minSteps(int n){
        return (int) (Math.pow(2,n)-1);

    }

    public static void hanoi(int n, char a, char b, char c){
        if(n==0){
            return;
        }

        hanoi(n-1,a,c,b);
        System.out.print(a+"--->" + c+ "  ");
        hanoi(n-1,b,a,c);
    }
    public static void main(String[] args) {

        int n=3;
        hanoi(n,'A','B','C');

        int min =minSteps(n);
        System.out.println(min);
    }
    
}
