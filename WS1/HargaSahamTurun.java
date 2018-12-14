import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class HargaSahamTurun {

            public class Hasil{
              int s,e,m;

              public Hasil(int s,int e, int m){
                this.s = s;
                this.e = e;
                this.m = m;
              }
              public int getS(){
                return s;
              }
              public int getE(){
                return e;
              }
              public int getM(){
                return m;
              }
              public static Comparator<Hasil> urutM = new Comparator<Hasil>(){
                public int compare(Hasil h1, Hasil h2){

                  int min1= h1.getM();
                  int min2= h2.getM();

                  return min1-min2;
                }
              };
            }
            ArrayList<Hasil> tampung = new ArrayList<Hasil>();
            HargaSahamTurun () {
              try {
                    BufferedReader br = new BufferedReader (
                      new InputStreamReader(System.in));
                    String par[] = br.readLine().split( " " );
                    int N = Integer.parseInt(par[0]);
                    int k = Integer.parseInt(par[1]);
                    //inisialisasi program anda disini
                    int min_terbesar =0;
                    int min_sekarang =0;
                    int min_sebelumnya =0;
                    int awal=0, akhir = 0,awal_o=0;;
                    int[][] hasil = new int[k+10][3];
                    // ArrayList[][] saham = new ArrayList[k+1][3];
                    int j =0;
                    for (int i = 0; i < N; i++)
                        {
                        int x = Integer.parseInt(br.readLine());
                        //perintah-perintah untuk pencarian rentang
                        if (x==0) {
                          continue;
                        }
                          min_sekarang += x;
                          if (min_sekarang < min_terbesar){
                            min_sebelumnya=min_terbesar;
                            min_terbesar = min_sekarang;
                            akhir = i;
                            awal_o = awal;
                          }else if(min_sekarang >= 0){
                            awal = i+1;
                            min_sekarang = 0;
                          }
                          if (awal_o > awal) {
                          //
                            // saham[j][0]= new ArrayList();
                            // saham[j][0].add(min_sebelumnya);
                            // saham[j][1].add(awal_o);
                            // saham[j][2].add(akhir);
                            tampung.add(new Hasil(awal_o,akhir,min_sebelumnya));
                            // j=j+1;
                          }
                        }
                        Collections.sort(tampung,Hasil.urutM);//akhir fungsi sort
                        // bagian mencetak rentang terkecil ke k
                        for(Hasil str:tampung){
                          System.out.println(str);
                        }
                        // System.out.printf("%s %s %s %s",awal_o,akhir,min_terbesar,min_sebelumnya);
                        // for (int l =0;l<k ;l++ ) {
                        //   System.out.println(hasil[l][2]+" "+hasil[l][1]+" "+hasil[l][0]);
                        // }
                  }
                  catch (Exception e) { System.out.println(e); }
            }

            public static void main(String[] args) {
                          new HargaSahamTurun();
            }
}
