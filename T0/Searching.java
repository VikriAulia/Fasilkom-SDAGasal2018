import java.io.*;

public class Searching {
        long X[];
        int N;
Searching() {
            try {
                BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		            N = Integer.parseInt(br.readLine());//input jumlah data bandwith yang akan di input
                X = new long[N+1];
                X[0] = 0;
		               for (int i = 1; i <= N; i++){//menerima data bandwith
            		   X[i] =  X[i-1]+Integer.parseInt(br.readLine());
                 }
                   int M = Integer.parseInt(br.readLine());//menerima jumlah pertanyaan
                   for(int i = 1; i <= M; i++) {//looping tiap pertanyaan
			                 String v[] = br.readLine().split(" ");
			                 cari2(Integer.parseInt(v[0]), Integer.parseInt(v[1]));
                   }
                }
            catch (Exception e) { System.out.println(e); }
	}
	public static void main(String[] args) {
        new Searching();
        }
          void cari(int l, long V) { //linear
            long t =V+X[l];
            for (int i =l ;i <= N ;i++ ) {
              if(t<=X[i]){
                System.out.println(i);
                return;
              }
            }
            System.out.println("TIDAK ADA");
          }
          void cari2(int l, long V){ //pakai binary Searching
            long t =V+X[l];
            int high = X.length-1;
            int low = l;
            int mid = (low+high)/2;
            if(t <X[low]){//jika t kecil dari X awal
              System.out.println("TIDAK ADA");
              return;
            }
            if(t > X[high]){//jika t besar dari x akhir
              System.out.println("TIDAK ADA");
              return;
            }
            while (low <= high) {//binary Searching
              if (X[mid]<t) {
                low = mid + 1;
              }else if  (X[mid] == t){
                System.out.println(mid);
                return;
              }else{
                high = mid -1;
              }
              mid = (low+high)/2;//membetulkan isi nilai mid
            }
            if ((X[low]-t)<(t-X[high])) {//jika tidak ditemukan binary search maka data antara X awal - X Akhir
            System.out.println(low);
            }else{
            System.out.println(high+1);
            }
            }
          }
