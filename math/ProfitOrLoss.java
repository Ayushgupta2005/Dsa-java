import java.util.*;

public class ProfitOrLoss {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter cost price ");
        float cp = scanner.nextFloat();
        System.out.println("enter Selling price");
        float sp = scanner.nextFloat();

        if (sp>cp){
            System.out.println("profit ");
            float profit = sp - cp;
            float profit_p = (profit * 100)/cp;
            System.out.println("profit percentage" + profit_p);
        }
        else if (sp<cp){
            System.out.println("Loss  ");
            float profit = cp - sp;
            float loss_p = (profit * 100)/cp;
            System.out.println(" Loss percentage" + loss_p);

        }
        else{
            System.out.println("No Profit nor Loss");
        }


    }
    
}
