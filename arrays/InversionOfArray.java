/*
 * BRUTE FORCE
 * public class InversionOfArray {
 * public static void main(String[] args) {
 * int[] arr = { 4, 3, 2, 1 };
 * System.out.println(inversionOfArray(arr));
 * }
 * 
 * private static int inversionOfArray(int[] arr) {
 * int len = arr.length;
 * int count = 0;
 * 
 * for (int i = 0; i < len - 1; i++) {
 * for (int j = i + 1; j < len; j++) {
 * if (arr[i] > arr[j]) {
 * count++;
 * }
 * }
 * }
 * 
 * return count;
 * }
 * }
 */

// BETTER SOLUTION
/*
 * public class InversionOfArray {
 * public static void main(String[] args) {
 * int[] arr = { 4, 3, 2, 1 };
 * System.out.println(inversionOfArray(arr));
 * }
 * 
 * private static int inversionOfArray(int[] arr) {
 * int count = 0;
 * 
 * for (int i = 0; i < arr.length; i++) {
 * int smaller = 0;
 * for (int j = i + 1; j < arr.length; j++) {
 * if (arr[i] > arr[j]) {
 * smaller++;
 * }
 * }
 * 
 * count += smaller;
 * }
 * 
 * return count;
 * }
 * }
 */

// Optimal Approach (Merge Sort)
public class InversionOfArray {
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 1 };
        System.out.println(inversionOfArray(arr));
    }

    private static int inversionOfArray(int[] arr) {
        count = 0;
        mergeSort(arr, 0, arr.length - 1);

        return count;
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                count += (mid - left + 1);
                temp[k++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        while (right <= high) {
            temp[k++] = arr[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }
}