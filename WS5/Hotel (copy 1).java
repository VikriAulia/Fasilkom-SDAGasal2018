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

    @Override
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
// TODO: Implement insertion reference https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/

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
//        return cariMAX(root);
        return cariMAX2(root);
    }

    public int cariMAX(Node node) {//reference algorima https://www.geeksforgeeks.org/find-maximum-or-minimum-in-binary-tree/
		int max=Integer.MIN_VALUE;
		int value=0;
		int left,right;
		if(root != null)  
		{
			value=root.value;
			left=cariMAX(root.leftChild);
			right=cariMAX(root.rightChild);
 
			if(left>right)
			{
				max=left;
			}
			else
			{
				max=right;
			}
 
			if(max < value)
			{
				max=value;
			}
		}
        return max;
    }
    public int cariMAX2(Node node){
        int max = node.value;
    if(node.leftChild != null) {
        max = Math.max(max, cariMAX2(node.leftChild));
    }
    if(node.rightChild != null) {
        max = Math.max(max, cariMAX2(node.rightChild));
    }
    return max;
    }

    private Node find(Node node, Node searchNode) {
// TODO: Implement find here
        Node ujungKiri = node, ujungKanan = node, dummy = new Node(-1);//menyuimpan data node sebelum null dan node dummy untuk return -1
        while (node != null) {
            if (node.compareTo(searchNode) == 0) {//cari kamar dg ukuran sama
                return node;
            } else if (node.compareTo(searchNode) > 0) {
                dummy = find(node.rightChild,searchNode);
                if(dummy.value == -1){
                    return node;
                }else{
                    return dummy;
                }
//                if (node.leftChild != null) {
//                    ujungKiri = node.leftChild;//simpan node sebelum null    
//                }
//                node = node.leftChild;
            } else {
                
                
                if (node.rightChild != null) {
                    ujungKanan = node.rightChild;
                    return find(node.rightChild,searchNode);
                }else{
                    dummy.value = -1;
                    return dummy;
                }
                
                
            }
        }
        // jika kamar yang ukuran sama tidak ketemu bandingkan current yg merupakan
        // akhir child dengan ukuran kamar
//        if (ujungKiri.compareTo(searchNode) > 0) { //jika kiri lebih besar  
//            return ujungKiri;
//        } else if (ujungKanan.compareTo(searchNode) > 0) { //jika kanan lebih besar
//            return ujungKanan;
//        }
        return dummy;//jika yg dicari lebih kecil dari ujungkiri/kanan
    }

    public int find(int value) {
        if (root == null) {
            return -1;
        }
        if (root.value == value) {
            return value;
        }
        return find(root, new Node(value)).value;
    }
}
