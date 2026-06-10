import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] result = mergeOverlappingIntervals(intervals);

        System.out.println(Arrays.deepToString(result));
    }

    private static int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> answer = new ArrayList<>();

        for (int[] interval : intervals) {
            if (answer.isEmpty() || interval[0] > answer.get(answer.size() - 1)[1]) {
                answer.add(interval);
            } else {
                answer.get(answer.size() - 1)[1] = Math.max(answer.get(answer.size() - 1)[1], interval[1]);
            }
        }

        return answer.toArray(new int[answer.size()][]);
    }
}