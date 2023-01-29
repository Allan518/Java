import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class StrongestFriendshipGroup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            arr.get(a).add(b);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                HashSet<Integer> set = new HashSet<>();
                while(true){
                }

            }

        }
    }

}
