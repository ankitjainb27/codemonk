package com.iitr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by AnkitJain on 25/05/16.
 */
public class Monk_in_the_Grass_Fields {

    public static void main(String[] args) throws Exception {
        Monk_in_the_Grass_Fields sort = new Monk_in_the_Grass_Fields();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        int[][] output;
        int[] final_output;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int T = Integer.parseInt(line);
        final_output = new int[T];
        for (int k = 0; k < T; k++) {
            int[][] values;
            int[] row_sum;
            int[] col_sum;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] cal = line.split("\\s+");
            int N = Integer.parseInt(cal[0]);
            int K = Integer.parseInt(cal[1]);
            values = new int[N][];

            row_sum = new int[N];
            col_sum = new int[N];
            for (int g = 0; g < N; g++) {
                try {
                    values[g] = new int[N];
                    line = br.readLine();
                    cal = line.split("\\s+");
                    for (int m = 0; m < N; m++) {
                        values[g][m] = Integer.parseInt(cal[m]);
                        row_sum[g] = row_sum[g] + values[g][m];
                        col_sum[m] = col_sum[m] + values[g][m];
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            /*for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(values[i][j] + " ");
                }
                System.out.print("\n");
            }
*/
           /* for (int i = 0; i < N; i++) {
                System.out.print(row_sum[i] + "**");
            }
            System.out.print("\n");
            for (int i = 0; i < N; i++) {
                System.out.print(col_sum[i] + "**");
            }
            System.out.print("\n");
           */
            int add_all_row = 0;
            int add_all_col = 0;
            for (int i = 0; i < K; i++) {
                sort.quick_sort(row_sum, 0, N - 1);
                sort.quick_sort(col_sum, 0, N - 1);
                if ((row_sum[0] + add_all_row) < (col_sum[0] + add_all_col)) {
                    final_output[k] = final_output[k] + row_sum[0] + add_all_row;
                    row_sum[0] = row_sum[0] + N;
                    add_all_col += 1;
                } else if ((row_sum[0] + add_all_row) > (col_sum[0] + add_all_col)) {
                    final_output[k] = final_output[k] + col_sum[0] + add_all_col;
                    col_sum[0] = col_sum[0] + N;
                    add_all_row += 1;
                } else {
                    boolean con = true;
                    int b = 0;
                    while (con) {
                        int row_same_count = 0;
                        int col_same_count = 0;
                        for (int j = b + 1; j < N; j++) {
                            if (row_sum[j] == row_sum[b]) {
                                row_same_count += 1;
                            } else {
                                break;
                            }
                        }
                        for (int j = b + 1; j < N; j++) {
                            if (col_sum[j] == col_sum[b]) {
                                col_same_count += 1;
                            } else {
                                break;
                            }
                        }
                        System.out.print(row_same_count + "--" + col_same_count + "\n");
                        if (row_same_count > col_same_count) {
                            final_output[k] = final_output[k] + row_sum[b] + add_all_row;
                            row_sum[b] = row_sum[b] + N;
                            add_all_col += 1;
                            con = false;
                        } else if (row_same_count < col_same_count) {
                            final_output[k] = final_output[k] + col_sum[b] + add_all_col;
                            col_sum[b] = col_sum[b] + N;
                            add_all_row += 1;
                            con = false;
                        } else {
                            b++;
                        }
                    }
                }
            }
           /* int add_all_row = 0;
            int add_all_col = 0;
            for (int i = 0; i < K; i++) {
                sort.quick_sort(row_sum, 0, N - 1);
                sort.quick_sort(col_sum, 0, N - 1);
                if ((row_sum[0]) < (col_sum[0])) {
                    final_output[k] = final_output[k] + row_sum[0] + add_all_row;
                    row_sum[0] = row_sum[0] + N;
                    for (int j = 0; j < N; j++) {
                        col_sum[j] += 1;
                    }
                } else {
                    final_output[k] = final_output[k] + col_sum[0] + add_all_col;
                    col_sum[0] = col_sum[0] + N;
                    for (int j = 0; j < N; j++) {
                        row_sum[j] += 1;
                    }

                }
            }*/


          /*  for (int i = 0; i < N; i++) {
                System.out.print(row_sum[i] + "**");
            }
            System.out.print("\n");
            for (int i = 0; i < N; i++) {
                System.out.print(col_sum[i] + "**");
            }
            System.out.print("\n");
          */  //sort.merge_sort(values, 0, N-1);
            //sort.insertion_sort(values, N);
            //sort.selection_sort(values, N);
            //sort.bubble_sort(values, N);
            //output[k] = values;


        }
        for (int o = 0; o < T; o++) {
            System.out.print(final_output[o] + " ");
            System.out.print("\n");
        }
    }


    private void quick_sort(int[] values, int start, int end) {
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
            if (values[j] < values[start]) {
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


    private void merge_sort(int[] values, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge_sort(values, start, mid);
            merge_sort(values, mid + 1, end);
            merge(values, start, mid, end);
        }

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

