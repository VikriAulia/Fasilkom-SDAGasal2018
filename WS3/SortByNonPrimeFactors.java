/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author vikri
 */
public class SortByNonPrimeFactors {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        Number[] numbers = new Number[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = new Number(Integer.parseInt(reader.readLine()));
        }

        bubbleSort(numbers);
        printHasilSorting(numbers);
    }

    public static int compare(Number a, Number b) {
        return a.compareTo(b);
    }

    static private void printHasilSorting(Number[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                System.out.print(' ');
            }
            System.out.print(arr[i].num);
        }
        System.out.println();
    }

    static private void bubbleSort(Number[] arr) {
        int N = arr.length;
        boolean swap;
        Number temp;
        for (int i = 0; i < N - 1; i++) {
            //swap = false;//algoritma dari GeekForCode
            for (int j = 0; j < N - i - 1; j++) {
                // @TODO: Implementasikan bubble sort Anda disini
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //swap = true;
                }
            }
            //jika tidak ada element yang di swap maka break;
//            if (swap == false) {
//                break;
//            }
        }
    }
}

class Number implements Comparable<Number> {

    // @TODO: lengkapi class dengan instance variable, constructor, dan method yang sesuai dan menurut anda diperlukan
    HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
    int num;
    int fp;
    public Number(int num) {
        this.num = num;
        hmap.put(num, findNonPrimeFactors(num));
        fp = findNonPrimeFactors(num);
    }

    int findNonPrimeFactors(int bilangan) {
        // @TODO: lengkapi method ini untuk mencari faktor non prima dari sebuah bilangan
        int f = 0;
        for (int i = 4; i <= bilangan; i++) {//dimulai dari 4, menghindari faktor yang bilangan prima
            if (bilangan % i == 0 && i != 1) {//habis bagi
                for (int j = 2; j <= i / 2; j++) {
                    if (i % j == 0) {//non prima
                        f++;
                        break;
                    }
                }
            }
        }
        return f;
    }

    @Override
    public int compareTo(Number other) {


        if(this.fp>other.fp||(this.fp==other.fp && this.num>other.num)){//pengecekan jika numnya sekarang lebih besar dari nomer berikutnya
            return 1;//lakukan swap
        }

        return 0;//tidak lakukan swap


        // @TODO: lengkapi method untuk sorting sesuai dengan spesifikasi soal

    }

}
