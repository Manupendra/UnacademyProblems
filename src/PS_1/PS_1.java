package PS_1;

public class PS_1 {

    static int buy_sell(int[] price){
        int min_price=Integer.MAX_VALUE;
        int max_profit=0;
        for (int i = 0; i < price.length; i++) {
            if (price[i]<min_price) {
                min_price=price[i];
            }
            max_profit=Math.max(max_profit,price[i]-min_price);
        }
        return max_profit;
    }

    static void patterns(int n){
        //no of stars
        int nst=n/2;
        //no of spaces
        int nsp=1;

        for (int i = 1; i <=n; i++) {
            //print stars
            for (int j = 0; j < nst; j++) {
                System.out.print("*");
            }
            //spaces
            for (int j = 0; j < nsp; j++) {
                System.out.print(" ");
            }
            //stars
            for (int j = 0; j < nst; j++) {
                System.out.print("*");
            }
            System.out.println();
            if(i<=n/2) {
                nst--;
                nsp += 2;
            }else{
                nst++;
                nsp -= 2;
            }
        }
    }
    public static void main(String[] args) {
        /*n=7
            *** ***
            **   **
            *     *

            *     *
            **   **
            *** ***
         */
        //patterns(7);
        System.out.println(buy_sell(new int[]{7,6,4,3,1}));
    }
}
