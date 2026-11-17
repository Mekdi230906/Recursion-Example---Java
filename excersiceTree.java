import java.util.Arrays;
public class excersiceTree {
    public static void main(String[] args) {
        Node root = new Node(50);

        root.left = new Node(25);
        root.right = new Node(75);

        // root.left.left = new Node(10);
        // root.left.right = new Node(35);
        // root.right.left = new Node(60);
        // root.right.right = new Node(90);

        // root.left.left.left = new Node(5);
        // root.left.right.right = new Node(40);
        // root.right.left.left = new Node(55);

        // root.left.left.left.right = new Node(7);

        Node a = new Node(22);
        a.left = new Node(20);
        a.right = new Node(30);
        
        Node b = new Node(22);
        b.left = new Node(15);
        b.right = new Node(30);

        //Node c = new Node();
        int[] d = {1,2,3,4,5,6};

        //add(root, 152);
        //System.out.println(newBinTree(d));
        newBinTree(d);
        inorder(root);
        //System.out.println(equality(b, a));
        
    }

    //ex 2
    public static Node add(Node root, int key){
        if(root == null){
            return root = new Node(key);
        }
        if(root.data == key){
            return root;
        }
        else if(root.data < key){
            return root.right = add(root.right, key);
        }
        else{
            return root.left = add(root.left, key);
        }
    }


    //ex 3
    // public static void newBinTree(int[] array, Node empty, int index){
    //     int key = array.length /2;
    //     int[] first_half = new int[key];
    //     int[] second_half = new int[array.length - key];
    //     first_half = Array.copyOfRange(array, 0, key);
    //     second_half = Array.copyOfRange(array, key, array.length);
    //     empty = new Node(key); 
    //     if(array[index] > array.length){
    //         return;
    //     }
    //     if(array[index] < empty.data){
    //         empty.left = newBinTree(first_half, empty.left, index + 1);
    //     }
    //     else{
    //         empty.right = newBinTree(first_half, empty.right, index + 1);
    //     }
    //     return;
    // }

    // public static void newBinTree(int[] array, Node empty){
    //     int key = array.length /2;
    //     int[] first_half = new int[key];
    //     int[] second_half = new int[array.length - key];
    //     first_half = Array.copyOfRange(array, 0, key);
    //     second_half = Array.copyOfRange(array, key, array.length);
    //     empty = new Node(key);
    //     int counter = 0; 
    //     for(int i = 0; i < array.length; i++){
    //         if(array[i] != key){
    //             add(empty, array[i]);
    //         }
    //     }
    //     return;
    // }

    public static void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.println(root.data + " ");
            inorder(root.right);
        }
        return;
    }

    public static void newBinTree(int[] array){
        int hi = array.length -1 ;
        int mid = array.length / 2;
        Node BinTree = new Node(array[mid]);
        BinTree.left = build(BinTree.left, array, 0, mid -1 );
        BinTree.right = build(BinTree.right, array, mid + 1, hi);
        inorder(BinTree);
        return;
        
    }

    public static Node build(Node root, int[] array, int low, int hi){
        if(root == null){ // root will be null, that us why newBinTree will give 4 as an output
          int midpoint = array.length / 2;
        root = new Node(array[midpoint]);
        root.left = build(root.left, array, low, midpoint);
        root.right = build(root.right, array, midpoint, hi);   
        }
        return root;
    }

    //ex 4
    public static Node maxKey(Node root){
        if(root.right == null) return root;
        else{
            return maxKey(root.right);
        }
    }

    //ex 5
    public static int maxNum(Node root){
        if(root == null){
            return -1;
        }
        if(root.right == null){
            return root.data;
        }
        else{
            return maxNum(root.right);
        }
    }

    //ex 6
    //a
    public static int size(Node root){
        int count = 1;
        if(root. right == null && root.left == null) return count;
        if(root.left != null){
            count += size(root.left);
        }
        if(root.right != null){
            count += size(root.right);
        }
        return count;
    }

    //b
    public static int numLeaves(Node root){
        int count = 1;
        if(root. right == null && root.left == null) return count;
        if(root.left != null){
            count = size(root.left);
        }
        if(root.right != null){
            count = size(root.right);
        }
        return count;
    }

    //c
    public static int sum(Node root){
        int count = 0;
        
        //if(root. right == null && root.left == null) return count;
        if(root != null){
            
            count = root.data;
            if (root.left != null)
            {
                count+= sum(root.left);
                //count+= temp;
            }
            //count += sum(root.left); //this is not working
            if (root.right != null)
            {
                count += sum(root.right);
               // count+= temp;
            }
        }
       
        return count;
    }

    //d
    public static Boolean isBST(Node root){
        if(root.left == null && root.right == null){
            return true;
        }
        // if(root.left.data > root.data || root.right.data < root.data){
        //     return false;
        // }
        if(root.left != null){
            if(root.left.data > root.data)return false;
            return isBST(root.left);
        }
        if(root.right != null){
            if(root.right.data < root.data) return false;
            return isBST(root.right);
        }
        else return true;
    }
    
    //e
    public static int numLeftChild(Node root){
        int count = 0;
        if(root == null){
            return 0;
        }
        if(root.left != null && root.right == null){
            count +=  1;
        }
        if(root.left != null){
            count += numLeftChild(root.left);
        }
        if(root.right != null){
            count += numLeftChild(root.right);
        }

        return count;
    }

    //f
    public static int countOccur(Node root, int target){
        int count = 0;
        if(root == null){
            return 0;
        }
        if(root.data == target){
            count ++;
        }
        if(root.left != null){
            count += countOccur(root.left, target);
        }
        if(root.right != null){
            count += countOccur(root.right, target);
        }
        return count;
    }

    //g 
    public static Boolean hasDups(Node root, int target){
        int count = countOccur(root, target);
        boolean result = false;
        if(count > 1){
            return true;
        }
        else{
            return false;
        }
    }

    //h
    public static void mirror(Node root){
        
    }

    //i // not working very well
    public static String oddNodes(Node root){
        String result = "";
        if(root == null){
            return "";
        }
        if(root.left != null){
            if(root.data % 2 != 0) result += String.valueOf(root.data) + ", ";
            result += oddNodes(root.left);
            
        }
        if(root.right != null){
            if(root.data % 2 != 0) result += String.valueOf(root.data) + ", ";
            result += oddNodes(root.right);
        }
        return result;

    }

    // ex 7 



    //ex 8 
    public static int level(Node root, int target){
        int count = 0;
        if(root == null){
            return -1;
        }
        if(root.data == target){
            return count;
        }
        else if(root.data > target){
            int temp = level(root.left, target) + 1;
            count+= temp;
            return count;
        }
        else{
            int temp = level(root.right, target) + 1;
            count+= temp;
            return count;
        }
    }


    //ex 10 
    public static Boolean equality(Node origin, Node compare){
        boolean result;
        if(origin == null && compare == null){
            result = true;
            return result;
        }
        else if(origin == null || compare == null){
            result = false;
            return result;
        }
        if(origin.data != compare.data){
            result = false;
            return result;
        }
        else if(origin.left != null && compare.left != null){
            return result = equality(origin.left, compare.left);
        }
        else{
            return result = equality(origin.right, compare.right);
        }
    }

    
}
