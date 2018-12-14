/**
 * 
 */

/**
 * @author vikri
 *
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;

/* Class Graph memiliki properti int JUMLAH_VERTEX, merupakan jumlah vertex pada graf
*
* Vertex pada graf dilabeli menggunakan bilangan bulat 0 sampai dengan JUMLAH_VERTEX-1.
*
* Adjacency List direpresentasikan menggunakan array of ArrayList. Index pada array
merepresentasikan vertex i. ArrayList berisi bilangan-bilangan bulat, merepresentasikan
vertex yang terhubung dengan vertex i.
*
*
* Contoh: Berikut ini merupakan representasi graf dengan 4 buah vertex
* (3) (0)
|
array[0] => 1 2
*
\
/
\
|
array[1] => 0 2
*
\
/
\
|
array[2] => 0 1 3
*
\
/
\
|
array[3] => 2
*
(2)---------(1)
|
*/
class Graph {
	private static int JUMLAH_VERTEX;
	private static ArrayList<Integer> adjList[];
	private static boolean visited[];
	private boolean[][] adjacencyMatrix;

	Graph(int v) {
		JUMLAH_VERTEX = v;
		adjList = new ArrayList[v];
		visited = new boolean[v];
		for (int i = 0; i < JUMLAH_VERTEX; i++) {
			adjList[i] = new ArrayList();
			visited[i] = false;
		}
	}

	void adjMatrixOf() {
		boolean[][] adjacencyMatrix = new boolean[JUMLAH_VERTEX][JUMLAH_VERTEX];
		for (int i = 0; i < JUMLAH_VERTEX; i++) {
			for (int j = 0; j < JUMLAH_VERTEX; j++) {
				adjacencyMatrix[i][j] = true;
				adjacencyMatrix[j][i] = true;
			}
		}
	}

	int getJmlVertex() {
		return JUMLAH_VERTEX;
	}

	void addEdge(int v, int w) {
		adjList[v].add(w);
		adjList[w].add(v);
	}

	boolean cekCycle(int sebelumnya, int vertexSekarang, boolean[] visited) {
		visited[vertexSekarang] = true; // ganti jadi true

		for (int i = 0; i < adjList[vertexSekarang].size(); i++) {
			// kunjungi yg terhubung kecuali dirinya sendiri
			int vertex = adjList[vertexSekarang].get(i);
			// periksa vertex berikutnya dari vertex saat ini
			if (vertex != sebelumnya) {
				// jika bukan dirinya sendiri
				if (visited[vertex]) {// cek apakah vertex saat ini pernah dikunjungi, jika true
					return true; //base case
					// intinya jika semua vertex telah visited, tapi 
					// vertex sebelumnya tidak sama dengan vertex saat ini
					// maka berati cycle ( siklis )
				} else // rekrusive
				{
					if (cekCycle(vertexSekarang, vertex, visited))return true;
					
				}
			}
		}
		return false;
	}
	
	boolean detectCycle() {
		boolean hasil = false;
		// implementasi program Anda
		for (int i = 0; i < JUMLAH_VERTEX; i++) {// kunjungi tiap Vertex ,DFS
			if (visited[i] != true) {
				if (cekCycle(-1, i, visited))
					return true;
			}
		}
		return hasil;
	}


	/*
	 * Method untuk mencetak representasi adjacency list dari sebuah graf (untuk
	 * gambaran saja)
	 */
	void printGraph() {
		for (int i = 0; i < JUMLAH_VERTEX; i++) {
			Iterator<Integer> itr = adjList[i].listIterator();
			System.out.print(i + " => ");
			while (itr.hasNext()) {
				System.out.print(itr.next() + " ");
			}
			System.out.println("");
		}
	}
}

class GraphDemo {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int jmlGraf = Integer.parseInt(reader.readLine());
		String[] in;
		int jmlVertex;
		int jmlEdge;
		Graph graf;
		boolean[] out = new boolean[jmlGraf];
		for (int x = 0; x < jmlGraf; x++) {
			// Silakan modifikasi jika diperlukan
			in = reader.readLine().split(" ");
			jmlVertex = Integer.parseInt(in[0]);
			jmlEdge = Integer.parseInt(in[1]);
			graf = new Graph(jmlVertex);
			for (int j = 0; j < jmlEdge; j++) {
				in = reader.readLine().split(" ");
				int a = Integer.parseInt(in[0]);
				int b = Integer.parseInt(in[1]);
				graf.addEdge(a, b);
			}
//			graf.printGraph(); // untuk memeriksa isi graph
			out[x] = graf.detectCycle();
		}
		for (boolean i : out) {
			System.out.println(i);
		}

	}
}
