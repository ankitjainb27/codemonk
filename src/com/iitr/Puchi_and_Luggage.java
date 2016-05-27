package com.iitr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by AnkitJain on 26/05/16.
 */
public class Puchi_and_Luggage {
    public static void main(String[] args) throws Exception {
        Puchi_and_Luggage sort = new Puchi_and_Luggage();
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
        output = new int[T][];
        for (int k = 0; k < T; k++) {
            int[] values;
            int[] row_sum;
            int[] col_sum;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }


            int N = Integer.parseInt(line);
            values = new int[N];
            output[k] = new int[N];
            row_sum = new int[N];
            col_sum = new int[N];
            for (int g = 0; g < N; g++) {
                try {
                    line = br.readLine();
                    values[g] = Integer.parseInt(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            int min = values[N - 1];
            for (int i = 0; i < N; i++) {
                int count = 0;
                for (int j = i + 1; j < N; j++) {
                    if (values[i] > values[j]) {
                        count += 1;
                    }
                }
                output[k][i] = count;
            }
        }
        for (int o = 0; o < T; o++) {
            for (int i = 0; i < output[o].length; i++) {
                System.out.print(output[o][i] + " ");
            }
            System.out.print("\n");
        }
    }

}
