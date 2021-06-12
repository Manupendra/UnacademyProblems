package PopularInterviewQuestion2;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Lexicographical_number {
    static void nextPermutation(int arr[]) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i + 1] <= arr[i]) {
            i--;
        }
        if (i >= 0) {
            int j = arr.length - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }
        rev(arr, i + 1);
        for (int val : arr
        ) {
            System.out.print(val + " ");
        }
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void rev(int arr[], int start) {
        int i = start;
        int j = arr.length - 1;
        while (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    static void slidingWindow(int[] arr, int k) {
        int n = arr.length;

        //For storing the index
        Deque<Integer> qi = new LinkedList<Integer>();
        int i;
        for (i = 0; i < k; i++) {
            while (!qi.isEmpty() && arr[i] >= arr[qi.peekLast()]) {
                qi.removeLast();
            }
            qi.addLast(i);
        }

        //for rest of the elements
        for (; i < n; i++) {
            System.out.print(arr[qi.peek()] + " ");
            //Max value which is out of range
            while (!qi.isEmpty() && qi.peek() <= i-k ){
                qi.removeFirst();
            }
            //
            while(!qi.isEmpty() && arr[i]>=arr[qi.peekLast()])
                qi.removeLast();

            qi.addLast(i);

        }
        //printing for last element in dequeue
        System.out.print(arr[qi.peekLast()]);
    }

    static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        //nextPermutation(new int[]{1,2,3,4,5});
        /*int[][] res = mergeIntervals(new int[][]{{1, 9}, {2, 5}, {19, 20}, {10, 11}, {12, 20}, {0, 3}, {0, 1}, {0, 2}});
        for (int[] r : res) {
            for (int val : r) {
                System.out.print(val + " ");
            }
            System.out.println();
        }*/
        slidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
}
