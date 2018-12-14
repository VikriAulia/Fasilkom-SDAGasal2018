/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vikri
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Collections;

public class WS4 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String postorder = reader.readLine();
        String inorder = reader.readLine();
        StringTokenizer stPostorder = new StringTokenizer(postorder);
        ArrayList<String> post = new ArrayList<>();
        while (stPostorder.hasMoreTokens()) {
            String token = stPostorder.nextToken();
            post.add(token);
        }
        StringTokenizer stInorder = new StringTokenizer(inorder);
        ArrayList<String> in = new ArrayList<>();
        while (stInorder.hasMoreTokens()) {
            String token = stInorder.nextToken();
            in.add(token);
        }
        BinaryTree tree = new BinaryTree();
        //@TODO : Do something

        Node root = tree.buildTree(in, post, n);
        ArrayList<String> path = new ArrayList<String>();
//        System.out.println(tree.adaPath(root, path, "Diary")); //tes untuk cek apakah diary ketemu
        tree.adaPath(root, path, "Diary");
        Collections.reverse(path); // untuk membalik isi list path yang didapat dari method adaPath
//        System.out.println(path); // untuk tes cek isi path
        for (int i = 0; i < path.size(); i++) {
            System.out.println(path.get(i));
        }
//        System.out.println("Isi ");
//        tree.preOrder(root); //untuk test lihat isi tree
//        tree.findDiary(); 
    }
}

class Node {

    String data;
    Node left, right, parent;

    public Node(String data) {
        this.data = data;
        left = right = parent = null;
    }

    public String getData() {
        return data;
    }
}

class Index {

    int index;
}

class BinaryTree {
// Tambahkan attribut yang kalian butuhkan

//    static int index;
    Node buildTreeFromPostIn(ArrayList<String> in, ArrayList<String> post, int start, int end, Index pIndex) {
//@TODO : Implementasi pembuatan binary tree dari array inorder dan postorder
// Silahkan tambahkan/hilangkan paramater
// source code ide pembuatan tree dari inOrder dan postOrder dari https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
        //Base case
        if (start > end) {
            return null;
        }

//pilih current node dari postorder menggunakan post
//index dan kurangi post index            
        Node node = new Node(post.get(pIndex.index));
        (pIndex.index)--;

        /* Jika index ini tidak punya child maka return*/
        if (start == end) {
            return node;
        }

//else cari index dari node ini di Inorder        
        int iIndex = search(in, start, end, node.data);

//menggunakan index Inorder, buat left dan right subtree
        node.right = buildTreeFromPostIn(in, post, iIndex + 1, end, pIndex);
        node.left = buildTreeFromPostIn(in, post, start, iIndex - 1, pIndex);

        return node;
    }

// menginisialisasi pembuataan binary tree
    Node buildTree(ArrayList<String> in, ArrayList<String> post, int n) {
//        index = n - 1; 
        Index pIndex = new Index();
        pIndex.index = n - 1;
        return buildTreeFromPostIn(in, post, 0, n - 1, pIndex);
    }
// Mencari folder diary

//    Node find(String namaFolder) {
////@TODO: implementasi proses pencarian folder Diary. Pencarian bisa dilakukan dengan
////        traversal atau cara lainnya
//        return;
//    }
// Mencetak folder apa saja yang harus dibuka
//    void findDiary() {
//        Node dairy = find("Diary");
////@TODO: lengkapi method untuk menghasilkan outpus sesuai soal
//    }
    public Boolean adaPath(Node root, List<String> path, String data) { //Method pencarian path "Diary" ke root
        if (root == null) {
            return false;
        }
        if (root.getData().equals(data)) { // "Diary" ada di root /parent
            path.add(root.data);
            return true;
        }
        boolean left_cek = adaPath(root.left, path, data);// cek di child kiri dan kanan rekursive
        boolean right_cek = adaPath(root.right, path, data);
        if (left_cek || right_cek) {
            path.add(root.data);
            return true;
        }

        return false;
    }

//    fungsi mencari index dari value di arr start ke end
    int search(ArrayList<String> arr, int strt, int end, String value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr.get(i).equals(value)) {
                break;
            }
        }
        return i;
    }

    /* fungsi ini cuma untuk tes melihat isi tree menggunakan preOrder*/
    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}
