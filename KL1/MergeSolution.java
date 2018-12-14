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
public class MergeSolution {

    /**
     * @param args the command line arguments
     */
    void merge(int arr[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    void sort(int arr[], int l, int r) {
        if (l < r) {

            int m = (l + r) / 2;


            sort(arr, l, m);
            sort(arr, m + 1, r);


            merge(arr, l, m, r);
        }
    }


    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] in1 = reader.readLine().split(" ");
        String[] in2 = reader.readLine().split(" ");
        int[] array1 = new int[in1.length];
        for (int i = 0; i < in1.length; i++) {
            array1[i] = Integer.parseInt(in1[i]);
        }
        int[] array2 = new int[in2.length];
        for (int i = 0; i < in2.length; i++) {
            array2[i] = Integer.parseInt(in2[i]);
        }
        int[] array3 = new int[array1.length + array2.length];
      int count = 0;

        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
            count++;
        }
        for (int j = 0; j < array2.length; j++) {
            array3[count++] = array2[j];
        }
        MergeSolution ob = new MergeSolution();
        ob.sort(array3, 0, array3.length - 1);
        printArray(array3);
    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static int[] merge(int[] arr1, int[] arr2) {
// Implementasikan solusi Anda di sini
      int[] c = new int[arr1.length + arr2.length];
      int count = 0;

        for (int i = 0; i < arr1.length; i++) {
            c[i] = arr1[i];
            count++;
        }
        for (int j = 0; j < arr2.length; j++) {
            c[count++] = arr2[j];
        }

        MergeSolution ob = new MergeSolution();
        ob.sort(c, 0, c.length - 1);
        return c;
    }
}
