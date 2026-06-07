public class Power {
    public static void main(String[] args) {
        double x = 2.00000;
        int num = 10;

        System.out.println(findPower(x, num));
    }

    private static double findPower(double x, int num) {
        double answer = 1.0;
        long n = num;

        if (n < 0) {
            n = -1 * n;
        }

        while (n > 0) {
            if (n % 2 == 1) {
                answer = answer * x;
                n = n - 1;
            } else {
                x = x * x;
                n = n / 2;
            }
        }

        if (n < 0) {
            answer = (double) (1.0) / (double) (answer);
        }

        return answer;
    }
}
