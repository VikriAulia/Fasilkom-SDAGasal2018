import java.io.*;

public class HargaSahamTurun1 {
            HargaSahamTurun1 () {
              try {
                    BufferedReader br = new BufferedReader (
                      new InputStreamReader(System.in));
                    String par[] = br.readLine().split( " " );
                    int N = Integer.parseInt(par[0]);
                    int k = Integer.parseInt(par[1]);
                    //inisialisasi program anda disini
                    int min_terbesar =2147483647;
                    int min_sekarang =2147483647;
                    int min_sebelumnya =2147483647;
                    int awal=0, akhir = 0,awal_o=0;;
                    int[][] hasil = new int[k][3];
                    int j =0;
                    for (int i = 0; i < N; i++)
                        {
                        int x = Integer.parseInt(br.readLine());
                        //perintah-perintah untuk pencarian rentang
                        // if (x==0) {
                        //   continue;
                        // }
                          if (min_sekarang > 0){
                            min_sekarang = x;
                            awal =i+1;
                          }else{
                            min_sekarang +=x;
                          }
                          if (min_sekarang < min_terbesar) {
                            akhir = i;
                            awal_o =awal;
                            min_sebelumnya = min_terbesar;
                            min_terbesar = min_sekarang;
                          // }else if (min_sebelumnya < min_sekarang) {
                          //
                          //   hasil[j][0]=awal_o;
                          //   hasil[j][1]=akhir;
                          //   hasil[j][2]=min_sebelumnya;
                          //   j++;
                          }
                        }
                        // bagian mencetak rentang terkecil ke k
                        System.out.printf("%s %s %s",awal,akhir,min_terbesar);
                        // for (int l =0;l<1 ;l++ ) {
                        //   System.out.println(hasil[l][0]+" "+hasil[l][1]+" "+min_terbesar);
                        // }
                  }
                  catch (Exception e) { System.out.println(e); }
            }

            public static void main(String[] args) {
                          new HargaSahamTurun();
            }
}
