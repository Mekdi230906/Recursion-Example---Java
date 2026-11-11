public class tree {
    public static void main(String[] args) {
        Node root = new Node(50);

        root.left = new Node(25);
        root.right = new Node(75);

        root.left.left = new Node(10);
        root.left.right = new Node(35);
        root.right.left = new Node(60);
        root.right.right = new Node(90);

        root.left.left.left = new Node(5);
        root.left.right.right = new Node(40);
        root.right.left.left = new Node(55);

        root.left.left.left.right = new Node(7);
        System.out.println(countNodes(root));
        System.out.println(sumNodes(root));
        System.out.println(search(root, 10));
        System.out.println(height(root));
        
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


}
