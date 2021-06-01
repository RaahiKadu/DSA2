import java.util.*;
class Node
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
class Tree
{
    private Node root;
    public Tree()
    {
        root = null;
    }
    void create()       //Create tree
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
                    System.out.print("Enter direction to go from " + temp.data +" : ");
                    dir = sc.next().charAt(0);
                    if(dir == 'L' || dir == 'l')
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
        System.out.print(root.data + " ");
        recursiveInorderhelper(root.right);
    }
    void recursiveInorder()     //Recursive inorder function
    {
        recursiveInorderhelper(root);
        System.out.println();
    }
    void recursivePreorderhelper(Node root)
    {
        if(root == null)
            return;
        System.out.print(root.data + " ");
        recursivePreorderhelper(root.left);
        recursivePreorderhelper(root.right);
    }
    void recursivePreorder()     //Recursive preorder function
    {
        recursivePreorderhelper(root);
        System.out.println();
    }


    void recursivePostorderhelper(Node root)
    {
        if(root == null)
            return;
        recursivePostorderhelper(root.left);
        recursivePostorderhelper(root.right);
        System.out.print(root.data + " ");
    }
    void recursivePostorder()     //Recursive postorder function
    {
        recursivePostorderhelper(root);
        System.out.println();
    }
    void nonrecursivePreOrder()    //Non Recursive Preorder function
    {
        Stack<Node> s = new Stack<Node>();
        Node ptr = root;
        while(ptr != null || !s.empty())
        {
            while(ptr != null)
            {
                System.out.print(ptr.data + " ");
                s.push(ptr);
                ptr = ptr.left;
            }
            ptr = s.pop();
            ptr = ptr.right;
        }
        System.out.println();
    }

    void nonrecursiveInOrder()    //Non Recursive Inorder function
    {
        Stack<Node> s = new Stack<Node>();
        Node ptr = root;
        while(ptr != null || !s.empty())
        {
            while(ptr != null)
            {
                s.push(ptr);
                ptr = ptr.left;
            }
            ptr = s.pop();
            System.out.print(ptr.data + " ");
            ptr = ptr.right;
        }
        System.out.println();
    }
    void nonrecursivePostOrder()   //Non recursive post order function
    {
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        Node ptr;
        s1.push(root);
        while(!s1.empty())
        {
            ptr = s1.pop();
            s2.push(ptr);
            if(ptr.left != null)
                s1.push(ptr.left);
            if(ptr.right != null)
                s1.push(ptr.right);
        }
        while(!s2.empty())
        {
            System.out.print(s2.pop().data + " ");
        }
        System.out.println();
    }
}
public class LAB1
{
    public static void main(String args[])
    {
        Tree t = new Tree();
        int choice;
        char y;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("**************************************");
            System.out.println("\n\n1.Create a Binary Tree \n2.Display the recursive Inorder \n3.Display the recursive preorder \n4.Display the recursive postorder\n5.Display the non Recursive inorder \n6.Display the non recursive Preorder \n7.Display the non recursive Postorder");
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
                    System.out.println("\nRecursive Preorder is : ");
                    t.recursivePreorder();
                    break;
                case 4:
                    System.out.println("\nRecursive Postorder is : ");
                    t.recursivePostorder();
                    break;
                case 5:
                    System.out.println("\nNon Recursive Inorder is : ");
                    t.nonrecursiveInOrder();
                    break;
                case 6:
                    System.out.println("\nNon Recursive Preorder is : ");
                    t.nonrecursivePreOrder();
                    break;
                case 7:
                    System.out.println("\nNon Recursive Postorder is : ");
                    t.nonrecursivePostOrder();
                    break;
                }
            System.out.print("Do you want to continue? (y/n)");
            y = sc.next().charAt(0);
        }while(y == 'y' || y == 'Y');
    }
}

/*  TIME COMPLEXITY :
    1. CREATE : O(n)
    2. INORDER : O(n)
    3. PREORDER : O(n)
    4. POSTORDER : O(n)
*/
/*
OUTPUT: 
**************************************


1.Create a Binary Tree
2.Display the recursive Inorder
3.Display the recursive preorder
4.Display the recursive postorder
5.Display the non Recursive inorder
6.Display the non recursive Preorder
7.Display the non recursive Postorder

*************************************

Enter your choice : 1
Enter data to be added : 45
Do you want to add one more node? (y/n)y
Enter data to be added : 78
Enter direction to go from 45 : l
Do you want to add one more node? (y/n)y
Enter data to be added : 56
Enter direction to go from 45 : r
Do you want to add one more node? (y/n)y
Enter data to be added : 9
Enter direction to go from 45 : l
Enter direction to go from 78 : r
Do you want to add one more node? (y/n)y
Enter data to be added : 9
Enter direction to go from 45 : r
Enter direction to go from 56 : l
Do you want to add one more node? (y/n)y
Enter data to be added : 7
Enter direction to go from 45 : l
Enter direction to go from 78 : r
Enter direction to go from 9 : r
Do you want to add one more node? (y/n)y
Enter data to be added : 1
Enter direction to go from 45 : r
Enter direction to go from 56 : l
Enter direction to go from 9 : l
Do you want to add one more node? (y/n)y
Enter data to be added : 5
Enter direction to go from 45 : r
Enter direction to go from 56 : l
Enter direction to go from 9 : l
Enter direction to go from 1 : l
Do you want to add one more node? (y/n)n
Do you want to continue? (y/n)y
**************************************


1.Create a Binary Tree
2.Display the recursive Inorder
3.Display the recursive preorder
4.Display the recursive postorder
5.Display the non Recursive inorder
6.Display the non recursive Preorder
7.Display the non recursive Postorder

*************************************

Enter your choice : 2

The Recursive Inorder is :
78 9 7 45 5 1 9 56 
Do you want to continue? (y/n)y
**************************************


1.Create a Binary Tree
2.Display the recursive Inorder
3.Display the recursive preorder
4.Display the recursive postorder
5.Display the non Recursive inorder
6.Display the non recursive Preorder
7.Display the non recursive Postorder

*************************************

Enter your choice : 5

Non Recursive Inorder is :
78 9 7 45 5 1 9 56
Do you want to continue? (y/n)y
**************************************


1.Create a Binary Tree
2.Display the recursive Inorder
3.Display the recursive preorder
4.Display the recursive postorder
5.Display the non Recursive inorder
6.Display the non recursive Preorder
7.Display the non recursive Postorder

*************************************

Enter your choice : 3

Recursive Preorder is :
45 78 9 7 56 9 1 5 
Do you want to continue? (y/n)y
**************************************


1.Create a Binary Tree
2.Display the recursive Inorder
3.Display the recursive preorder
4.Display the recursive postorder
5.Display the non Recursive inorder
6.Display the non recursive Preorder
7.Display the non recursive Postorder

*************************************

Enter your choice : 6

Non Recursive Preorder is :
45 78 9 7 56 9 1 5
Do you want to continue? (y/n)y
**************************************


1.Create a Binary Tree
2.Display the recursive Inorder
3.Display the recursive preorder
4.Display the recursive postorder
5.Display the non Recursive inorder
6.Display the non recursive Preorder
7.Display the non recursive Postorder

*************************************

Enter your choice : 4

Recursive Postorder is :
7 9 78 5 1 9 56 45 
Do you want to continue? (y/n)y
**************************************


1.Create a Binary Tree
2.Display the recursive Inorder
3.Display the recursive preorder
4.Display the recursive postorder
5.Display the non Recursive inorder
6.Display the non recursive Preorder
7.Display the non recursive Postorder

*************************************

Enter your choice : 7

Non Recursive Postorder is :
7 9 78 5 1 9 56 45
Do you want to continue? (y/n)n
*/
