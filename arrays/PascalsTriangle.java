/*
TASK 1 : Find the element in the particular place
public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(findElement(5, 3));
    }

    private static long findElement(int r, int c) {
        int n = r - 1;
        int k = c - 1;

        long result = 1;

        for (int i = 0; i < k; i++) {
            result = result * (n - i);
            result = result / (i + 1);
        }

        return result;
    }
}*/

/* 
// TASK 2 - Print any row of pascal's triangle
public class PascalsTriangle {
    public static void main(String[] args) {
        pascalsTriangle(5);
    }

    private static void pascalsTriangle(int num) {
        int answer = 1;
        System.out.print(answer+" ");

        for (int i = 1; i < num; i++) {
            answer = answer * (num - i);
            answer = answer / i;

            System.out.print(answer+" ");
        }

    }
}*/ 

import java.util.List;
import java.util.ArrayList;

public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = generate(numRows);
        System.out.println(result);
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
 
            List<Integer> currentRow = new ArrayList<>();

            for (int col = 0; col <= row; col++) {

                if (col == 0 || col == row) {
                    currentRow.add(1);
                } else {
                    int value = result.get(row - 1).get(col - 1)
                            + result.get(row - 1).get(col);

                    currentRow.add(value);
                }
            }

            result.add(currentRow);
        }

        return result;
    }
}