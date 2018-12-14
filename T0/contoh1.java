public class contoh1 {

   public static void main(String[] args) {
       System.out.println("***** SEQUENTIAL SEARCH *****"+"\n" );


       int data[] = {12, 22, 34, 78, 98 , 45 }; //isi array
       int key = 98; //nilai yang dicari
       int N = 6; //batas array


       //menampilkan data Array
       System.out.print("isi data adalah: ");
       for (int i = 0; i < data.length; i++) {

           System.out.print(data[i] + " ");
       }
       System.out.println("");


       for (int i = 0; i <= N; i++) {
           if (key == data[i]) { //nilai data yang dicari sama dengan data yang dicari
               System.out.print("Data "+key+" berada pada index ke - " + i);
               break; //stop perulangan
           }
       }
       System.out.println("\n");
       System.out.println();
       System.out.println(" ***** Terima Kasih ***** ");
   }

}
