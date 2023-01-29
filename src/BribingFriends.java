import java.util.Scanner;

public class BribingFriends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int money = sc.nextInt();
        int cones = sc.nextInt();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int popularity = sc.nextInt();
            int moneyCost = sc.nextInt();
            int coneCost = sc.nextInt();
            int num = Math.min(moneyCost, money / coneCost);
            moneyCost -= num;
            int temp = Math.min(money - moneyCost, popularity);
            max += temp;
            money -= moneyCost;
            cones -= num * coneCost;
        }
        System.out.println(max);
    }
}
