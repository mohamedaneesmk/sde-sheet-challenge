import java.util.HashMap;

public class CountSubArraysWithGivenXOR {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 4 };
        int k = 6;

        System.out.println(countSubarrays(arr, k));
    }

    private static int countSubarrays(int[] arr, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int xor = 0;

        int count = 0;

        map.put(0, 1);

        for (int num : arr) {

            xor ^= num;

            int required = xor ^ x;

            count += map.getOrDefault(required, 0);

            map.put(
                    xor,
                    map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }
}
