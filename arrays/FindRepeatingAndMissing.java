import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRepeatingAndMissing {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3 },
                { 2, 2 }
        };

        int[] result = findRepeatingAndMissing(matrix);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findRepeatingAndMissing(int[][] matrix) {
        // Step 1: build frequency map from 2D grid
        int n = matrix.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int num = matrix[row][col];
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        // Step 2: find repeated and missing
        int repeated = -1, missing = -1;
        for (int x = 1; x <= n * n; x++) {
            int count = map.getOrDefault(x, 0);
            if (count == 2)
                repeated = x;
            if (count == 0)
                missing = x;
        }

        return new int[] { repeated, missing };
    }
}
