
/**
 * 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author vikri
 * @author 1706124182
 */
public class SoalSusah {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String inputs[] = reader.readLine().split(" ");

		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);

		// TODO: Implement this
		ArrayList<CustomPriorityQueue> prioritasPerorangan = new ArrayList<CustomPriorityQueue>();
		for (int i = 0; i < N; i++) {
			inputs = reader.readLine().split(" ");
			String nama = inputs[0];
			int type = Integer.parseInt(inputs[1]);
			int minimal = Integer.parseInt(inputs[2]);
			prioritasPerorangan.add(i,new CustomPriorityQueue(nama, type, minimal) );
		}

		// TODO: Implement this like this	
		for (int i = 0; i < M; i++) {
			inputs = reader.readLine().split(" ");
			int index = Integer.parseInt(inputs[0]);
			int poin = Integer.parseInt(inputs[1]);
			int waktu = Integer.parseInt(inputs[2]);
			Persoalan soal = new Persoalan(poin, waktu);
			CustomPriorityQueue ini = prioritasPerorangan.get(index);
			ini.insert(soal);
		}

		// TODO: Implement this like this using ctrl + space
		for (int i = 0; i < N; i++) {
			CustomPriorityQueue current = prioritasPerorangan.get(i);

			// TODO: Implement this
			 System.out.println(current.getNama()+": "+ current.countMinimalValue());
		}

	}

}

class Persoalan {
	private int poin;
	private int waktu;

	public Persoalan(int poin, int waktu) {
		this.poin = poin;
		this.waktu = waktu;
	}

	public int getPoin() {
		return this.poin;
	}

	public int getWaktu() {
		return this.waktu;
	}
}

class SoalPoinComparator implements Comparator<Persoalan> {

	// TODO: Implement this
	// sumber algoritma dari hasil membaca soal dan 
	// contoh penggunaan comparator dari GeeksforGeeks
	public int compare(Persoalan p1, Persoalan p2) {
		if (p1.getPoin()<p2.getPoin()) {
			return 1;
		}else if(p1.getPoin()>p2.getPoin()) {
			return -1;
		}
		return 0;
	}
}

class SoalWaktuComparator implements Comparator<Persoalan> {

	// TODO: Implement this
	// sumber algorima dari hasil membaca soal dan
	// contoh penggunaan comparator dari GeeksforGeeks
	public int compare(Persoalan p1, Persoalan p2) {
		if (p1.getWaktu()>p2.getWaktu()) {
			return 1;
		}else if(p1.getWaktu()<p2.getWaktu()) {
			return -1;
		}
		return 0;
	}
}

// Implementasi PQ menggunakan unsorted array method
class CustomPriorityQueue {
	private ArrayList<Persoalan> array;
	private int size;
	private String nama;
	private int type;
	private int nilaiMinimal;

	public CustomPriorityQueue(String nama, int type, int nilaiMinimal) {
		this.array = new ArrayList<Persoalan>();
		this.size = 0;
		this.nama = nama;
		this.type = type;
		this.nilaiMinimal = nilaiMinimal;
	}

	public boolean empty() {
		return size == 0;
	}

	// TODO: Implement this
	public void insert(Persoalan soal) {
	//diatur masuknya 
	//ide algoritmanya seperti insert HeapTree , 
	//kemudian di putar otak agar bisa sort generic type
	
	array.add(soal);
	size++;
	Collections.sort(array, this.getComparator()); 
}
	public Comparator<Persoalan> getComparator() {
		if (this.type == 1) {
			return new SoalPoinComparator();
		}

		return new SoalWaktuComparator();
	}

	public Persoalan remove() {
		  if (size == 0) {
		   return null;
		  }

		  int idx = 0;
		  Persoalan result = this.array.get(0);
		  this.array.set(0, this.array.get(size - 1));
		  this.array.remove(size - 1);
		  size--;

		  Comparator < Persoalan > comparator = this.getComparator();

		  while (idx < size) {
		   int l = 2 * idx + 1;
		   int r = 2 * idx + 2;
		   Persoalan val = this.array.get(idx);
		   int dest = -1;

		   if (l < size) {
		    if (comparator.compare(this.array.get(l), val) > 0) {
		     val = this.array.get(l);
		     dest = l;
		    }
		   }

		   if (r < size) {
		    if (comparator.compare(this.array.get(r), val) > 0) {
		     val = this.array.get(r);
		     dest = r;
		    }
		   }

		   if (dest == -1) {
		    break;
		   }

		   Persoalan temp = this.array.get(idx);
		   this.array.set(idx, val);
		   this.array.set(dest, temp);
		   idx = dest;
		  }

		  return result;
		 }

	// TODO: Implement this
	public int countMinimalValue() {
//		
		int ygdioutput = 0;
		int hitung = 0;
//		if(type==1) {
//			int nilai = 0;
//			int i = 0;
//			int j = size;
//			while (j>0&&nilai<=nilaiMinimal) {
//				Persoalan current = array.get(i);
//				nilai += current.getPoin();
//				ygdioutput += current.getWaktu();
//				i++;
//				j--;
//			}
//			if (nilai<nilaiMinimal) {
//				return -1;
//			}else {
//				return ygdioutput;
//			}
//		}else {
//			int poin = 0;
//			int i = 0;
//			int j = size;
		try {
			while (hitung < nilaiMinimal) {
				Persoalan current = remove();
				if (type==1) {
					ygdioutput+=current.getWaktu();
					nilaiMinimal-=current.getPoin();
				}else {
					ygdioutput+=current.getPoin();
					nilaiMinimal-=current.getWaktu();
				}
			}
			return ygdioutput;
		}catch (NullPointerException e) {
			// TODO: handle exception
			return -1;
		}
//			while (j>0) {
//				while (nilai<nilaiMinimal) {
//					
//					nilai += current.getPoin();
//					ygdioutput += current.getWaktu();
//					i++;
//					j--;
//				}
//			}
//			return nilai;
//		}
		
	}

	public String getNama() {
		return this.nama;
	}
}