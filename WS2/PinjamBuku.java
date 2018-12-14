import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class PinjamBuku {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new
InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int n = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine());
        LinkedHashMap<String, LinkedList<String>> antrianBuku = new LinkedHashMap <String, LinkedList<String>>();
        for (int i = 0; i < n; i++) {
              String book = tokenizer.nextToken();
        // do something with book here
        antrianBuku.put(book, new LinkedList<String>());

      }
        int m = Integer.parseInt(reader.readLine());

        tokenizer = new StringTokenizer(reader.readLine());
        LinkedHashMap<String, int[]> pengunjung = new LinkedHashMap<String, int[]>();
        for (int i = 0; i < m; i++) {
              String name = tokenizer.nextToken();
        // do something with name here
        pengunjung.put(name, new int[2]);
        }

        int q = Integer.parseInt(reader.readLine());

        for (int i = 0; i < q; i++) {
              String commands[] = reader.readLine().split(" ");

              if (commands[0].equals("pengunjung")) {
                  String book = commands[1];
                  String name = commands[2];
        // do something with pengunjung here
                  if(pengunjung.get(name)[0]==0){
                    if (antrianBuku.get(book).isEmpty()) {
                      pengunjung.get(name)[0]=1;
                      pengunjung.get(name)[1]+= 1;
                      antrianBuku.get(book).add(name);
                    }else{
                      pengunjung.get(name)[0] = 1;
                      antrianBuku.get(book).add(name);
                    }
                  }
        }
              if (commands[0].equals("KEMBALIKAN")) {
                  String book = commands[1];
                  //do something
                  if (!antrianBuku.get(book).isEmpty()) {
                    pengunjung.get(antrianBuku.get(book).removeFirst())[0] = 0;
                    if (!antrianBuku.get(book).isEmpty()) {
                      pengunjung.get(antrianBuku.get(book).getFirst())[1] += 1;

                    }
                  }

                }
        }
        for (String key:pengunjung.keySet()) {
          System.out.print(pengunjung.get(key)[1]+" ");
        }
}
}
// do something with KEMBALIKAN here
