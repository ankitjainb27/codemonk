package com.iitr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by AnkitJain on 27/05/16.
 */

/*
You are given an array A of size N,and Q queries to deal with.For each query,you are given an integer X,and you're
supposed to find out if X is present in the array A or not.

        Input:
        The first line contains two integers,N and Q,denoting the size of array A and number of queries.The second line
        contains N space separated integers,denoting the array of elements Ai.The next Q lines contain a single integer
        X per line.

        Output:
        For each query,print YES if the X is in the array,otherwise print NO.

        Constraints:
        1<=N,Q<=105
        1<=Ai<=109
        1<=X<=109
*/


public class Discover_the_Monk {

    public static void main(String[] args) {
        // write your code here
        Discover_the_Monk monk = new Discover_the_Monk();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        boolean[] output;
        int[] values;
        int[] X;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] cal = line.split("\\s+");

        int N = Integer.parseInt(cal[0]);
        int Q = Integer.parseInt(cal[1]);
        X = new int[Q];
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cal = line.split("\\s+");
        values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(cal[i]);
        }
        output = new boolean[Q];
        for (int i = 0; i < Q; i++) {
            try {
                line = br.readLine();
                X[i] = Integer.parseInt(line);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        monk.quick_sort(values, 0, N - 1);
        //System.out.print(Arrays.toString(values));
        for (int i = 0; i < Q; i++) {
            output[i] = monk.binary_search_recursive(values, X[i], 0, N - 1);
            output[i] = monk.binary_search_iterative(values, X[i], 0, N - 1);

            //output[i] = monk.linear_search(values, X[i]);
        }
        for (int o = 0; o < Q; o++) {
            if (output[o]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
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


    private boolean binary_search_recursive(int[] values, int find, int start, int end) {

        if (start <= end) {
            int mid = (start + end) / 2;
            if (values[mid] == find) {
                return true;
            } else if (find > values[mid]) {
                start = mid + 1;
                return binary_search_recursive(values, find, start, end);
            } else {
                end = mid - 1;
                return binary_search_recursive(values, find, start, end);
            }
        } else {
            return false;
        }
    }

    private boolean binary_search_iterative(int[] values, int find, int start, int end) {

        while (start <= end) {
            int mid = (start + end) / 2;
            if (values[mid] == find) {
                return true;
            } else if (find > values[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;

    }

    private boolean linear_search(int[] values, int i) {
        for (int j = 0; j < values.length; j++) {
            if (values[j] == i) {
                return true;
            }
        }
        return false;
    }

}
