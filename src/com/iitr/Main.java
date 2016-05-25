package com.iitr;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        // write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        boolean[] output;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int T = Integer.parseInt(line);
        output = new boolean[T];
        for (int k = 0; k < T; k++) {
            output[k] = false;
            Integer[] values;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] cal = line.split("\\s+");

            int N = Integer.parseInt(cal[0]);
            int X = Integer.parseInt(cal[1]);
            values = new Integer[N];

            for (int i = 0; i < N; i++) {
                try {
                    line = br.readLine();
                    values[i] = Integer.parseInt(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            int sum = 0;
            for (int p = 0; p < N; p++) {
                for (int i = p; i < N; i++) {
                    sum = sum + values[i];
                    if (sum > X) {
                        break;
                    }
                    if (sum == X) {
                        output[k] = true;
                        break;
                    }
                }
                sum = 0;
            }

        }
        for (int o = 0; o < T; o++) {
            if (output[o]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
