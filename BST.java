import java.util.*;
class Node       // node class
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
class BSTree      // bst class
{
    private Node root;
    public BSTree()
    {
        root = null;
    }
    void create()       //Create BStree
    {
        Scanner sc = new Scanner(System.in);
        char ch;
        do
        {
            int d;
            char dir;
            System.out.print("Enter data to be added : ");
            d = sc.nextInt();
            Node nn = new Node(d);
            Node temp = root;
            if(root == null)
            {
                root = nn;
            }
            else
            {
                while(true)
                {
                    if(d < temp.data)
                    {
                        if(temp.left == null)
                        {
                            temp.left = nn;
                            break;
                        }
                        else
                            temp = temp.left;
                    }
                    else
                    {
                        if(temp.right == null)
                        {
                            temp.right = nn;
                            break;
                        }
                        else
                            temp = temp.right;
                    }
                }
                
            }
            System.out.print("Do you want to add one more node? (y/n)");
            ch = sc.next().charAt(0);
        }while(ch == 'y' || ch == 'Y');
    }
    void recursiveInorderhelper(Node root)
    {
        if(root == null)
            return;
        recursiveInorderhelper(root.left);
        System.out.println(root.data + " ");
        recursiveInorderhelper(root.right);
    }
    void recursiveInorder()     //Recursive inorder function
    {
        recursiveInorderhelper(root);
    }

    void descendinghelper(Node root)
    {
        if(root == null)
            return;
        descendinghelper(root.right);
        System.out.println(root.data + " ");
        descendinghelper(root.left);
    }
    void descending()   
    {
        descendinghelper(root);
    }
    int findMin()
    {
        if(root == null)
            return Integer.MIN_VALUE;
        Node temp = root;
        while(temp.left != null)
            temp = temp.left;
        return temp.data;
    }
    int findMax()
    {
        if(root == null)
            return Integer.MAX_VALUE;
        Node temp = root;
        while(temp.right != null)
            temp = temp.right;
        return temp.data;
    }
    int helperHeight(Node root)
    {
        if(root == null)
            return -1;
        return 1 + Math.max(helperHeight(root.left), helperHeight(root.right));
    }
    void height()
    {
        int v = helperHeight(root);
        if(v == -1)
            System.out.println("Empty Tree!");
        else
            System.out.println("Height is : " + v);
    }
    int countLeafHelper(Node root)
    {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return countLeafHelper(root.left) + countLeafHelper(root.right);
    }
    void countLeaf()
    {
        int v = countLeafHelper(root);
        if(v == 0)
            System.out.println("Empty Tree!");
        else
            System.out.println("Leaf Nodes count is : " + v);
    }
    void displayLevelWise()
    {
        if(root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(q.size() != 0)
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                Node c = q.remove();
                System.out.print(c.data + " ");
                if(c.left != null)
                    q.add(c.left);
                if(c.right != null)
                    q.add(c.right);
            }
            System.out.println();
        }
    }
    Node displayParentHelper(Node root, int d)
    {
        if(root == null)
            return null;
        if((root.left != null && root.left.data ==  d) || (root.right != null && root.right.data == d))
            return root;
        if(root.data > d)
            return displayParentHelper(root.left, d);
        else
            return displayParentHelper(root.right, d);    
    }
    void displayParent()
    {
        Scanner sc = new Scanner(System.in);
        int d;
        System.out.print("Enter data whose parent is to be found : ");
        d = sc.nextInt();
        Node ptr = displayParentHelper(root, d);
        if(ptr == null)
            System.out.println("Value doesnt exist or is root !");
        else    
            System.out.println(ptr.data + " ");
    }
}
public class LAB2
{
    public static void main(String args[])
    {
        BSTree t = new BSTree();
        int choice;
        char y;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("**************************************");
            System.out.println("\n\n1.Create a Binary Search Tree \n2.Display the recursive Inorder \n3.Display the minimum node\n4.Display the maximum node\n5.Display the tree level wise \n6.Display the tree in descending order \n7.Count Leaf Nodes \n8.Height of Tree \n9. Find Parent");
            System.out.println("\n*************************************");
            System.out.print("\nEnter your choice : ");
            choice = sc.nextInt();
            switch(choice)
            {
            case 1:
                    t.create();
                    break;
                case 2:
                    System.out.println("\nThe Recursive Inorder is : ");
                    t.recursiveInorder();
                    break;
                case 3:
                    int j = t.findMin();
                    System.out.println("\nMinimum element is : " + j);
                    break;
                case 4:
                    int k = t.findMax();
                    System.out.println("\nMaximum element is : " + k);
                    break;
                case 5:
                    System.out.println("\nLevel wise display : ");
                    t.displayLevelWise();
                    break;
                case 6:
                    t.descending();
                    break;
                case 7:
                    t.countLeaf();
                    break;
                case 8:
                    t.height();
                    break;
                case 9:
                    t.displayParent();
                    break;
                }
            System.out.print("Do you want to continue? (y/n)");
            y = sc.next().charAt(0);
        }while(y == 'y' || y == 'Y');
    }
}

/*  TIME COMPLEXITY :
    1. CREATE n elements : O(n * h)
    2. MIN : O(logn)   worst case : O(n)
    3. MAX : O(logn)   worst case : O(n)
    4. LEVEL WISE DISPLAY : O(n)
    5. DESCENDING : O(n)
    6. COUNT LEAF NODES : O(logn)      worst case : O(n)
    7. HEIGHT OF BST : O(logn)   worst case : O(n)
    8. FIND PARENT : O(logn)      worst case : O(n)

*/


/*
C:\Users\Yogesh\Desktop\labs\dsa2>java LAB2
**************************************


1.Create a Binary Search Tree
2.Display the recursive Inorder
3.Display the minimum node
4.Display the maximum node
5.Display the tree level wise
6.Display the tree in descending order
7.Count Leaf Nodes
8.Height of Tree
9. Find Parent

*************************************

Enter your choice : 1
Enter data to be added : 4
Do you want to add one more node? (y/n)y
Enter data to be added : 1
Do you want to add one more node? (y/n)y
Enter data to be added : 67
Do you want to add one more node? (y/n)y
Enter data to be added : 15
Do you want to add one more node? (y/n)n
Do you want to continue? (y/n)y
**************************************


1.Create a Binary Search Tree
2.Display the recursive Inorder
3.Display the minimum node
4.Display the maximum node
5.Display the tree level wise
6.Display the tree in descending order
7.Count Leaf Nodes
8.Height of Tree
9. Find Parent

*************************************

Enter your choice : 2

The Recursive Inorder is :
1
4
15
67
Do you want to continue? (y/n)y
**************************************


1.Create a Binary Search Tree
2.Display the recursive Inorder
3.Display the minimum node
4.Display the maximum node
5.Display the tree level wise
6.Display the tree in descending order
7.Count Leaf Nodes
8.Height of Tree
9. Find Parent

*************************************

Enter your choice : 3

Minimum element is : 1
Do you want to continue? (y/n)y
**************************************


1.Create a Binary Search Tree
2.Display the recursive Inorder
3.Display the minimum node
4.Display the maximum node
5.Display the tree level wise
6.Display the tree in descending order
7.Count Leaf Nodes
8.Height of Tree
9. Find Parent

*************************************

Enter your choice : 4

Maximum element is : 67
Do you want to continue? (y/n)y
**************************************


1.Create a Binary Search Tree
2.Display the recursive Inorder
3.Display the minimum node
4.Display the maximum node
5.Display the tree level wise
6.Display the tree in descending order
7.Count Leaf Nodes
8.Height of Tree
9. Find Parent

*************************************

Enter your choice : 5

Level wise display :
4
1 67
15
Do you want to continue? (y/n)y
**************************************


1.Create a Binary Search Tree
2.Display the recursive Inorder
3.Display the minimum node
4.Display the maximum node
5.Display the tree level wise
6.Display the tree in descending order
7.Count Leaf Nodes
8.Height of Tree
9. Find Parent

*************************************

Enter your choice : 6
67
15
4
1
Do you want to continue? (y/n)y
**************************************


1.Create a Binary Search Tree
2.Display the recursive Inorder
3.Display the minimum node
4.Display the maximum node
5.Display the tree level wise
6.Display the tree in descending order
7.Count Leaf Nodes
8.Height of Tree
9. Find Parent

*************************************

Enter your choice : 7
Leaf Nodes count is : 2
Do you want to continue? (y/n)y
**************************************


1.Create a Binary Search Tree
2.Display the recursive Inorder
3.Display the minimum node
4.Display the maximum node
5.Display the tree level wise
6.Display the tree in descending order
7.Count Leaf Nodes
8.Height of Tree
9. Find Parent

*************************************

Enter your choice : 8
Height is : 2
Do you want to continue? (y/n)y
**************************************


1.Create a Binary Search Tree
2.Display the recursive Inorder
3.Display the minimum node
4.Display the maximum node
5.Display the tree level wise
6.Display the tree in descending order
7.Count Leaf Nodes
8.Height of Tree
9. Find Parent

*************************************

Enter your choice : 9
Enter data whose parent is to be found : 15
67
Do you want to continue? (y/n)y
**************************************


1.Create a Binary Search Tree
2.Display the recursive Inorder
3.Display the minimum node
4.Display the maximum node
5.Display the tree level wise
6.Display the tree in descending order
7.Count Leaf Nodes
8.Height of Tree
9. Find Parent

*************************************

Enter your choice : 9
Enter data whose parent is to be found : 0
Value doesnt exist or is root !
Do you want to continue? (y/n)y
**************************************


1.Create a Binary Search Tree
2.Display the recursive Inorder
3.Display the minimum node
4.Display the maximum node
5.Display the tree level wise
6.Display the tree in descending order
7.Count Leaf Nodes
8.Height of Tree
9. Find Parent

*************************************

Enter your choice : 9
Enter data whose parent is to be found : 4
Value doesnt exist or is root !
Do you want to continue? (y/n)n
*/
