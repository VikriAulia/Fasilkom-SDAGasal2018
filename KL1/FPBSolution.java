/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 *
 * @author vikri
 */
public class FPBSolution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] in = reader.readLine().split(" ");
        int[] arr = new int[in.length];
        for (int i = 0; i < in.length; i++) {
            arr[i] = Integer.parseInt(in[i]);
        }
        System.out.print(findFPB(arr));
    }

    static int fpb(int a, int b) {
        if (a == 0) {
            return b;
        }
        return fpb(b % a, a);
    }

    static int FPB(int a, int b) {
        int d;

        d = a % b;

        while (d != 0) {

            a = b;

            b = d;

            d = a % b;
        }

        return b;

    }

    static int findFPB(int arr[]) {
// Implementasikan solusi Anda di sini
        int f = 0;
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            temp = FPB(arr[i], arr[i + 1]);
        }
        if (temp > f) {
            f = temp;
        }
        return f;
    }

}
