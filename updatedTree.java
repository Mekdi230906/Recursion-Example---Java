public class updatedTree {
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

       System.out.println(add(7));
        //System.out.println(remove(root, 7));
        //System.out.println(search(root, 7));
        //System.out.println(inorder(root));
        //printInorder(root);
        InorderPrint(root);
       // System.out.println(sumNodes(root));

       
        
    }

    //challenge 1: Count the nodes in a binary tree
    public static int countNodes(Node input){
        int count = 1; //for the root
        if(input.left != null){
            count = count + countNodes(input.left);
        }
        if(input.right != null){
            count = count + countNodes(input.right);
        }
        return count;
    }


    //challenge 2: Sum all the nodes
    public static int sumNodes(Node input){
        int count = input.data; //for the root
        if(input.left != null){
            int temp = sumNodes(input.left);
            count += temp;
            // we can use directly
            //count += sumNodes(input.left);
        }
        if(input.right != null){
            int temp = sumNodes(input.right);
            count += temp;
        }
        return count;
    }

    //challenge 3: Search for a value
    public static Boolean search(Node input, int target){
        if(input == null){ // if you do not put this as the first argument, it will cause an error
            return false;
        }
        if(input.data == target){
            return true;
        }
        if(input.data < target){
            return search(input.right, target);
        }
        else{
            return search(input.left, target);
        } 
    }

    public static Node searchNode(Node input, int target){
        if(input == null){
            return null;
        }
        if(input.data == target){
            return input;
        }
        else if(input.data < target){
            return searchNode(input.right, target);
        }
        else{
            return searchNode(input.left, target);
        }

    }

    //challenge 4: find the height of a binary tree
    public static int height(Node input){
        int count_main = 1; //for the root
        int count_left, count_right;
        count_left = count_right = 0;
        if(input.left != null){
            count_left += height(input.left);
        }
        if(input.right != null){
            count_right += height(input.right);
        }
        if(count_left > count_right){
            return count_main += count_left;
        }
        else{
            return count_main += count_right;
            //or we can use 
            //return 1 + Math.max(count_left, count_right);
        }
    }

     
    
    //challenge 5: add data
    /* 
    public Node<E>  add(Node<Integer> input , E item){
        if(input == null){
            addReturn = true;
            return new Node<Integer>(item);
        }
        else if(input.data == item){
            addReturn = false;
            return input;
        }
        else if(item.compareTo(input.data) < 0){
            input.left = add(input.left, item);
            return input;
        }
        else{
            input.right = add(input.right, item);
            return input;
        }
    }
        */

    /* 
    public Boolean add(E item){
        root = add(root, item);
        return addReturn;
    }
        */
    ///* 
    public static Node adding(Node root, int input){
        //boolean addReturn;
        if(root == null){
            addReturn = true;
            return new Node(input);
        }
        else if(root.data == input){
            //System.err.println("equal");
            addReturn = false;
            return root;
        }
        else if(root.data > input){
            //System.err.println("smaller");
            //adding(root.left, input);
            //return root.left = adding(root.left, input);
            root.left = adding(root.left, input);
        }
        else{
            //System.err.println("bigger");
            //adding(root.right, input);
            //return root.right = adding(root.right, input);
            root.right = adding(root.right, input);
        }
        return root;
    }

    public static Boolean add(int input){
        //int sum_before = sumNodes(root);
        adding(root, input);
        //int sum_after = sumNodes(root);
        if(addReturn == false){
            return addReturn;
        }
        else{
            return addReturn;
        }

    }

        //*/

    /* 
    public static Node adding(Node root, int input){
        if(root == null){
            return new Node(input);
        }
        if(root.data > input){
            root = adding(root.left, input);
        }
        else{
            root = adding(root.right, input);
        }
        return root;
    }
    */




    //additional method
    /* 
    public static int biggest(Node root, int main_count){
        main_count = root.data;
        int comparison_left, comparison_right;
        if(root.right == null){
            System.err.println("3.1");
            return main_count;
        }
        comparison_left = root.left.data;
        comparison_right = root.right.data;
        if(comparison_left > comparison_right){
            if(comparison_left > main_count){
                System.out.println("1.1");
                return biggest(root.left, comparison_left);
            }
            else{
                System.out.println("1.2");
                 return biggest(root.left, main_count);
            }
        }else{
            if(comparison_right > main_count){
                System.out.println("2.1");
                return biggest(root.left, comparison_right);
            }
            else{
                System.out.println("2.2");
                return biggest(root.right, main_count);
            }
        }
    }
    */

        ///* 
    public static int biggest(Node root, int main_count){
        //main_count = root.data;
        if(root.right == null){
            System.out.println("3.1");
            return main_count;
        }
        if(root.right.data > main_count){
            System.out.println("2.1");
            return biggest(root.right, root.right.data);
        }
        
        else if(root.right.data < main_count){
            System.out.println("2.2");
            return biggest(root.right, main_count);
        }
        else{
            //System.err.println("3.1");
            return main_count;
        }
    }

    public static int findBig(Node root){
        return biggest(root, 0);
    }
         //*/
    
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
    

    //challenge 6: removing nodes from binary trees
    /* 
    public static Boolean remove(Node localRoot, int target){
        if(search(localRoot, target) == false){
            return false;
        }
        if(localRoot.data > target){
            return remove(localRoot.left, target);
        }
        else if(localRoot.data < target){
            return remove(localRoot.right, target);
        }
        else{
            if(localRoot.left == null && localRoot.right == null){
                localRoot = null;
                return true;
            }
            else if(height(localRoot) > 1){
                int replacement = findBig(localRoot);
                localRoot = new Node(replacement);
                remove(localRoot, replacement);
                return true;
            }
            else{
                //Node temp = localRoot.left.data;
                localRoot = new Node(localRoot.left.data);
                localRoot.left = null;
                return true;
                
            }
        }
    }
        */

    public static Node removing(Node localRoot, int target){
        if(search(localRoot, target) == false){
            addReturn = false;
            return null;
        }
        if(localRoot.data > target){
            return localRoot.left = removing(localRoot.left, target);
        }
        else if(localRoot.data < target){
            return localRoot.right = removing(localRoot.right, target);
        }
        else{
            if(localRoot.left == null && localRoot.right == null){
                addReturn = true;
                localRoot = null;
            }
            else if(height(localRoot) > 1){ //standarization
                addReturn = true;
                int replacement = findBig(localRoot);
                removing(localRoot, replacement);
                localRoot = new Node(replacement);
            }
            else{
                addReturn = true;
                localRoot = localRoot.left;
            }
            return localRoot;
        }
    }

    public static Boolean remove(Node root, int target){
        removing(root, target);
        if(addReturn == false){
            return false;
        }
        else{
            return true;
        }
    }


    //challenge 7: print inorder
    /* 
    public static ArrayList<Integer> inorderList(Node root){
        ArrayList<Integer> inorder = new ArrayList<>();
        if(root.left == null){
            inorder.add(root.data);
            return inorder;
        }
        else{
            inorderList(root.left);
            inorder.add(root.data);
        }
        if(root.right == null){
            inorder.add(root.data);
            return inorder;
        }
        else{
            inorderList(root.right);
            inorder.add(root.data);
        }
        return inorder;
    }
        */

    // public static int printData(Node root){
    //     return root.data;
    // }


    // public static ArrayList<Integer> inorderList(Node root){ // not working
    //     ArrayList<Integer> inorder = new ArrayList<>();
    //     while(root != null){
    //         inorderList(root.left);
    //         //System.out.print()
    //     }
    //     return inorder;
    // }

    // //from geeks for geeks 
    // public static void inorder(Node root){ //not working 
    //     if(root != null){
    //         inorder(root.left);
    //         System.out.println(root.data + " ");
    //         inorder(root.right);
    //     }
    //     return;
    // }

    public static void InorderPrint(Node root){
        if(root == null) return;
        InorderPrint(root.left);
        System.out.println(root.data + " ");
        InorderPrint(root.right);
    }

    // public static void printInorder(Node root){ // not working
    //     while(root == null){
    //         //System.out.println(root.data + " ");
    //         printInorder(root.left);
    //         System.out.println(root.data + " ");
    //         printInorder(root.right);
    //         break;
    //     }
    //     return;
    // }
}
