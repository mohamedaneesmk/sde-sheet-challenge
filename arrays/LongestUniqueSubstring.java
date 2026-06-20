import java.util.HashMap;

public class LongestUniqueSubstring {
    public static void main(String[] args) {
        String string = "abcab";
        System.out.println(findLongestUniqueSubstring(string));
    }

    private static int findLongestUniqueSubstring(String string) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < string.length(); right++) {
            char ch = string.charAt(right);

            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);
            int windowSize = right - left + 1;
            maxLength = Math.max(maxLength, windowSize);
        }

        return maxLength;
    }
}