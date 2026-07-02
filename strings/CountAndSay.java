package strings;

public class CountAndSay {
    public static void main(String[] args) {
        String num = "332221";

        System.out.println(countAndSay(num));
    }

    private static String countAndSay(String num) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;

        for (int i = 1; i < num.length(); i++) {

            if (num.charAt(i) == num.charAt(i - 1)) {
                count++;
            } else {
                stringBuilder.append(count);
                stringBuilder.append(num.charAt(i - 1));
                count = 1;
            }
        }

        stringBuilder.append(count);
        stringBuilder.append(num.charAt(num.length() - 1));

        return stringBuilder.toString();
    }
}
