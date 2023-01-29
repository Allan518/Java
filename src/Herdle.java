import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class Herdle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] answer = new String[3];
        String[] guess = new String[3];
        for (int i = 0; i < 3; i++) {
            answer[i] = sc.next();
        }
        for (int i = 0; i < 3; i++) {
            guess[i] = sc.next();
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int green = 0;
        int yellow = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (answer[i].charAt(j) == guess[i].charAt(j)) {
                    green++;
                } else {
                    if (map1.containsKey(answer[i].charAt(j))) {
                        map1.put(answer[i].charAt(j), map1.get(answer[i].charAt(j)) + 1);
                    } else {
                        map1.put(answer[i].charAt(j), 1);
                    }
                    if (map2.containsKey(guess[i].charAt(j))) {
                        map2.put(guess[i].charAt(j), map2.get(guess[i].charAt(j)) + 1);
                    } else {
                        map2.put(guess[i].charAt(j), 1);
                    }
                }
            }
        }
        for (char c : map2.keySet()) {
            if (map1.containsKey(c)) {
                yellow += Math.min(map1.get(c), map2.get(c));
            }
        }
        PrintStream ps = new PrintStream(System.out);
        ps.println(green);
        ps.println(yellow);
    }
}
