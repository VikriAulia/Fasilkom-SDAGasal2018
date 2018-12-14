/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author vikri
 */
public class SDA18191T {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws IOException{
        //deklarasi faribel
        String A = "A";
        String B = "B";
        
        //memulai ambil input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split(" ");
        int S = Integer.parseInt(line[0]); //jarak milea dan dilan
        int N = Integer.parseInt(line[1]);//jumlah transportasi
        int U = Integer.parseInt(line[2]);//permindahan milea
        String line1[] = br.readLine().split(" ");
        int V[] = new int[line1.length];
        for(int i = 0; i<line1.length; i++)//inpur transportasi dilan
            V[i] = Integer.parseInt(line1[i]);
        String P = br.readLine();
        if(P.equals(A)){
        System.out.println(banyak_Cara(S,V,U,V[0]));
        }else if (P.equals(B)){
        new SDA18191T().caraTercepat(S,V,U);
        }
    }
        public static int banyak_Cara(int s,int Kendaraan[],int m,int kecPertama){
         //posisi dilan
        
        if (s==0)//n adalah jarak dilan dengan milea. jika 0 maka mereka bertemu
        {
            return 1;
        }
            if (s < 0)//dilan terlalu cepat
            return 0;
        
            int temu = 0;
            
            for(int kendara=0;kendara<Kendaraan.length;kendara++){
                if(Kendaraan[kendara]<=s){   //greedy jika kendaraan melebihi jarak maka tidak akan dihitung 
                temu += banyak_Cara(s-Kendaraan[kendara]-m,Kendaraan,m,kendara);//recursife akan me-return nilai 1 setiap bertemu dan di tambah ke variabel temu
                }
            }
        return temu;
        }
   
        
        public void caraTercepat(int s,int Kendaraan[], int m) 
    { 
        // menggunakna dynamic programing
        // tabel [i] akan menyimpan 
        // nilai minimal setiap titik temu yang mungkin

        //ArrayList[][] list= new ArrayList[s+1][s+1];
        
        int table[] = new int[s + 1]; 
  
        // Base case jika s = 0
        table[0] = 0; 
  
        // inisiasi semua value tabel jadi tidak terbatas
        for (int i = 1; i <= s; i++) 
        table[i] = Integer.MAX_VALUE; 
  
        // hitung pergerakan minimal untuk setiap titik temu dari 1 ke s
        for (int i = 1; i <= s; i++) 
        { 
            for (int j = 0; j < Kendaraan.length; j++) 
            if (Kendaraan[j] <= i) //hitung terhadap kecepatan kendaraan yang kecil dari i
            { 
//                list[i][j] = new ArrayList();
//                list[i][j].add(Kendaraan[j]);
                int sub_res = table[i - Kendaraan[j]]; 
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                       //list.add(i,j);
                       table[i] = sub_res + 1; 
                         
                  
            } 
              
        }
        int temu = table[s]*m; //menghitung pergerakan milea yaitu jumlah minimal pindah kendaraan dilan * kecepatan milea
        System.out.println(table[s-temu]); //tempat bertemu adalah jarak dikurangi pergerakan milea
        //System.out.println();
    } 
}
