import java.util.ArrayList;
import java.util.List;

public class MinSubArray {
    public static List<Integer> getShortestSubsequence(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        int minLength = Integer.MAX_VALUE;

        int[] prefixSum = new int[arr.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = prefixSum[j + 1] - prefixSum[i];
                if (sum % k == 0 && (j - i + 1) < minLength) {
                    minLength = j - i + 1;
                    result.clear();
                    for (int x = i; x <= j; x++) {
                        result.add(arr[x]);
                    }
                }
            }
        }
        if (result.isEmpty()) {
            return new ArrayList<>();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(getShortestSubsequence(arr, k));
    }
}
