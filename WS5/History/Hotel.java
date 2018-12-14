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
import java.io.InputStreamReader;
import java.io.IOException;

public class Hotel {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        BinarySearchTree bst = new BinarySearchTree();

        for (int i = 0; i < N; i++) {
            String inputs[] = reader.readLine().split(" ");
            if (Integer.parseInt(inputs[0]) == 1) {
                bst.insert(Integer.parseInt(inputs[1]));
            } else if (Integer.parseInt(inputs[0]) == 2) {
                System.out.println(bst.find(Integer.parseInt(inputs[1])));
            } else if (Integer.parseInt(inputs[0]) == 3) {
                System.out.println(bst.findMax());

            }
        }
    }
}

class Node implements Comparable<Node> {

    public Integer value;
    public Node leftChild;
    public Node rightChild;

    public Node(Integer value) {
        this.value = value;
        this.leftChild = this.rightChild = null;
    }

    public int compareTo(Node other) {
        return value.compareTo(other.value);
    }
}

class BinarySearchTree {

    private Node root;

    BinarySearchTree() {
        this.root = null;
    }

    private Node insert(Node node, Node newNode) {
// TODO: Implement insertion source https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/

        if (node == null) {
            node = newNode;
            return node;
        }

        if (newNode.compareTo(node) < 0) {
            node.leftChild = insert(node.leftChild, newNode);
        } else if (newNode.compareTo(node) > 0) {
            node.rightChild = insert(node.rightChild, newNode);
        }

        return node;
    }

    public void insert(int value) {
        this.root = insert(root, new Node(value));
    }

    private Node findMax(Node node) {
// TODO: implement find Max here

        if (node.rightChild != null) {
            return findMax(node.rightChild);
        }

        return node; //Sementara
    }

    public int findMax() {
        if (root == null) {
            return -1;
        }
//        return findMax(root).value;
        return cariMAX(root);
    }

    public int cariMAX(Node node) {//https://www.geeksforgeeks.org/find-maximum-or-minimum-in-binary-tree/
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int MAX = node.value;
        int hasilKiri = cariMAX(node.leftChild);
        int hasilKanan = cariMAX(node.rightChild);

        if (hasilKiri > MAX) {
            MAX = hasilKiri;
        }
        if (hasilKanan > MAX) {
            MAX = hasilKanan;
        }
        return MAX;
    }

    private Node find(Node node, Node searchNode) {
// TODO: Implement find here
        Node ujungKiri = node, ujungKanan = node, dummy = new Node(-1);//menyuimpan data node sebelum null dan node dummy untuk return -1
        while (node != null) {
            if (node.compareTo(searchNode) == 0) {//cari kamar dg ukuran sama
                return node;
            } else if (node.compareTo(searchNode) > 0) {
                if (node.leftChild != null) {
                    ujungKiri = node.leftChild;//sinpan node sebelum null    
                }

                node = node.leftChild;
            } else {
                if (node.rightChild != null) {
                    ujungKanan = node.rightChild;
                }
                node = node.rightChild;
            }
        }
        // jika kamar yang ukuran sama tidak ketemu bandingkan current yg merupakan
        // akhir child dengan ukuran kamar
        if (ujungKiri.compareTo(searchNode) > 0) { //jika kiri lebih besar  
            return ujungKiri;
        } else if (ujungKanan.compareTo(searchNode) > 0) { //jika current lebih kecil
            return ujungKanan;
        }
        return dummy;
    }

    public int find(int value) {
        if (root == null) {
            return -1;
        }
        if (root.value == value) {
            return value;
        }
        return find(root, new Node(value)).value;
//    return find2(root,value);
    }

    int find2(Node node, int n) {//https://www.geeksforgeeks.org/largest-number-bst-less-equal-n/
        if (node == null) {
            return -1;
        }
        if (node.value == n) {
            return n;
        }
        else if(node.value < n){
            int k = find2(root.rightChild,n);
            if (k == -1){
                return node.value;
            }else{
                return k;
            }
        }
        else if(node.value>n){
            return find2(node.leftChild,n);
        }
        return n;
    }
}