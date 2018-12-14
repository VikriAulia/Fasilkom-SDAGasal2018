import java.io.*;

public class SourceSearching {
        long X[];
        int N;
        Searching()
        {
            try {
                BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            		N = Integer.parseInt(br.readLine());
                X = new long[N+1];
                X[0] = 0;
                	for (int i = 1; i <= N; i++)
            		    X[i] =  X[i-1]+Integer.parseInt(br.readLine());
              		int M = Integer.parseInt(br.readLine());
              		for(int i = 0; i < M; i++)
                  {
              			String v[] = br.readLine().split(" ");
              			cari(Integer.parseInt(v[0]), Integer.parseInt(v[1]));
                  }
                }
                catch (Exception e) { System.out.println(e); }
      	}
	public static void main(String[] args) {
               new Searching();
        }

        //-----------------------------------------------
        // isi method ini dengan algoritma pencarian yang sesuai
        // anda boleh menambahkan method tambahan untuk membantunya
        // tetapi tidak boleh mengubah satu barispun bagian template
     // di luar ini.

        void cari(int l, long V) {
          void cari(int l, long V){
            long k =X[l]+V;
            int akhir = N;
            int awal = l;
            int tengah = (low+high)/2;
            if(k < X[awal]){//jika t kecil dari X awal
              System.out.println("TIDAK ADA");
              break;
            }
            if(k > X[akhir]){//jika t besar dari x akhir
              System.out.println("TIDAK ADA");
              break;
            }
            while (awal <= akhir) {//binary Searching
              if (X[tengah]<k) {
                awal = akhir + 1;
              }else if  (X[tengah] == k){
                System.out.println(tengah);
                break;
              }else{
                akhir = tengah - 1;
              }
              tengah = (awal+akhir)/2;
            }
            if ((X[awal]-k)<(k-X[akhir])) {//kalo ga tidak ditemukan binary search maka data antara X awal - X Akhir
            System.out.println(awal);
            }else{
            System.out.println(akhir+1);
            }
            }

        }

        //---------------------------------------------------------------
}
