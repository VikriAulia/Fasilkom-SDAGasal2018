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


    public int findMax() {
        if (root == null) {
            return -1;
        }
//        return cariMAX(root);
        return cariMAX2(root);
    }

    public int cariMAX(Node node) {//reference algorima https://www.geeksforgeeks.org/find-maximum-or-minimum-in-binary-tree/
        int max = Integer.MIN_VALUE;
        int value;
        int left, right;
        if (root != null) {
            value = root.value;
            left = cariMAX(root.leftChild);
            right = cariMAX(root.rightChild);

            if (left > right) {
                max = left;
            } else {
                max = right;
            }

            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    public int cariMAX2(Node node) {
        int max = node.value;
        if (node.leftChild != null) {
            max = Math.max(max, cariMAX2(node.leftChild));
        }
        if (node.rightChild != null) {
            max = Math.max(max, cariMAX2(node.rightChild));
        }
        return max;
    }

    private Node find1(Node node, Node searchNode) {
// TODO: Implement find here
        Node dummy = new Node(-1), nuller = null, search = null;//menyuimpan data node sebelum null dan node dummy untuk return -1
        if (node == null) {
            return dummy;
        }
        while (node != null) {
            if (node.compareTo(searchNode) == 0) {//cari kamar dg ukuran sama
                return node;
            } else if (node.compareTo(searchNode) > 0) {

                Node dummy1 = find1(node.rightChild, searchNode);
                if (dummy1.value == -1) {
                    return node;
                } else {
                    return dummy1;
                }
            } else {

                if (node.rightChild == null) {
                    return (new Node(-1));

                } else {

                    return find1(node.rightChild, searchNode);
                }

            }
        }
        return nuller;
    }

    public int find(int value) {
        if (root == null) {
            return -1;
        }
        if (root.value == value) {
            return value;
        }
        return find(root, value);

    }

    int find(Node node, int n) {//https://www.geeksforgeeks.org/largest-number-bst-less-equal-n/
        // Base Case 
        if (node == null) {
            return -1;
        }
  
        if (node.value == n) {
            return n; //jika ketemu sama return nilai yg sama
        } 
        // Jika nilai node lebih kecil cari di kanan child kanan
        else if (node.value < n) {
            if (node.rightChild == null) {
                return -1;
            } else {
                return find(node.rightChild, n);
            }
        }
        //jika value node lebih kecil cari di child kiri
        else {
            int kiri = find(node.leftChild, n);
            if (kiri == -1) {
                return node.value;
            } else {
                return kiri;
            }

        }
    }
}
