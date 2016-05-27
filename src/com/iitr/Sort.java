package com.iitr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by AnkitJain on 25/05/16.
 */
public class Sort {

    public static void main(String[] args) throws Exception {
        Sort sort = new Sort();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        int[][] output;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int T = Integer.parseInt(line);
        output = new int[T][];
        for (int k = 0; k < T; k++) {
            int[] values;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }


            int N = Integer.parseInt(line);
            output[k] = new int[N];

            values = new int[N];
            int i = 0;
            int u = 0;
            try {
                line = br.readLine();
                String[] cal = line.split("\\s+");
                for (String str :
                        cal) {
                    values[i++] = Integer.parseInt(str);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            sort.quick_sort(values, 0, N - 1);
            //sort.merge_sort(values, 0, N-1);
            //sort.insertion_sort(values, N);
            //sort.selection_sort(values, N);
            //sort.bubble_sort(values, N);
            output[k] = values;


        }
        for (int o = 0; o < T; o++) {
            for (int l = 0; l < output[o].length; l++) {
                System.out.print(output[o][l] + " ");
            }
            System.out.print("\n");
        }
    }

    private void merge_sort(int[] values, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge_sort(values, start, mid);
            merge_sort(values, mid + 1, end);
            merge(values, start, mid, end);
        }

    }

    public void quick_sort(int[] values, int start, int end) {
        if (start < end) {
            int pivot_position = rand_partition(values, start, end);
            quick_sort(values, start, pivot_position);
            quick_sort(values, pivot_position + 1, end);
        }
    }

    private int rand_partition(int[] values, int start, int end) {
        int random = start + ((int) Math.random() * (end - start + 1));
        swap(values, start, random);
        return partition(values, start, end);
    }

    private int partition(int[] values, int start, int end) {
        int i = start + 1;
        for (int j = start + 1; j <= (end); j++) {
            if (values[j]< values[start]) {
                swap(values, j, i);
                i += 1;
            }
        }
        swap(values, start, i - 1);
        return i - 1;
    }

    private void swap(int[] values, int position1, int position2) {
        int temp = values[position1];
        values[position1] = values[position2];
        values[position2] = temp;
    }

    private void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

		/* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

		/*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


		/* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

		/* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

		/* Copy remaining elements of L[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private void insertion_sort(int[] values, int n) {

        for (int i = 1; i < n; i++) {
            int max_index = values[i];
            int j;
            for (j = i; j > 0; j--) {
                if (max_index > values[j - 1]) {
                    values[j] = values[j - 1];
                } else {
                    break;
                }
            }
            values[j] = max_index;
        }
    }

    private void selection_sort(int[] values, int n) {
        int temp;
        for (int i = 0; i < n - 1; i++) {
            int max_index = i;
            for (int j = i + 1; j < n; j++) {
                if (values[max_index] < values[j]) {
                    max_index = j;
                }
            }
            temp = values[i];
            values[i] = values[max_index];
            values[max_index] = temp;
        }
    }

    public void bubble_sort(int[] values, int n) {
        int temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (values[j] < values[j + 1]) {
                    temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
    }
}

