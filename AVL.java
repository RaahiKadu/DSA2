/*
Create a reasonably balanced tree to maintain names and 
telephone numbers of all the customers of a shopkeeper and
perform operations on it.              
*/
import java.util.*;
class Node
{
    Node left, right;
    String name, telephone;
    int h;
    public Node(String n, String t)       //parameterized constructor of class Node
    {
        name = n;
        telephone = t;
        left = right = null;
        h = 0;
    }
}
class AVL
{
    Node root;
    public AVL()
    {
        root = null;
    }
    int height(Node node)
    {
        if(node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
    int balanceFactor(Node node)
    {   
        int lh, rh, bf;
        if(node == null)
            return 0;
        lh = height(node.left);
        rh = height(node.right);
        bf = Math.abs(lh - rh);
        return bf;
    }
    Node LL(Node node)
    {    
        Node ptr;
        ptr = node.left;
        node.left = ptr.right;
        ptr.right = node;
        ptr.h = height(ptr);
        node.h = height(node);
        return ptr;
    }
    Node RR(Node node)
    {      
        Node ptr;
        ptr = node.right;
        node.right = ptr.left;
        ptr.left = node;
        ptr.h = height(ptr);
        node.h = height(node);
        return ptr;
    }
    Node LR(Node node)
    {
        node.left = RR(node.left);
        node = LL(node);
        return node;
    }
    Node RL(Node node)
    {
        node.right = LL(node.right);
        node = RR(node);
        return node;
    }
    Node insert(Node root, Node temp)
    { 
        int bal;
        if(root == null)
        {
            root = temp;
            return root;
        }
        if(temp.name.compareTo(root.name) < 0)
        {
            root.left = insert(root.left, temp);
            bal = balanceFactor(root);
            if(bal == 2)
            {
                if(temp.name.compareTo(root.left.name) < 0)
                    root = LL(root);
                else
                    root = LR(root);
            }
        }
        else
        {   
            root.right = insert(root.right, temp);
            bal = balanceFactor(root);
            if(bal == 2)
            {
                if(temp.name.compareTo(root.right.name) > 0)
                    root = RR(root);
                else
                    root = RL(root);
            }
        }
        root.h = height(root);
        return root;		
    }
    public void create()            // information from user
    {
        Scanner sc = new Scanner(System.in);
        String name, telephone;
        System.out.println("Enter the name:");
        name = sc.next();
        System.out.println("Enter the telephone number:");
        telephone = sc.next();
        Node temp = new Node(name,telephone);
        root = insert(root,temp);
    }
    void recursiveInorderhelper(Node node)
    {
        if(node == null)
            return;
        recursiveInorderhelper(node.left);
        System.out.println(node.name + "\t" + node.telephone);
        recursiveInorderhelper(node.right);
    }
    void recursiveInorder()     //Recursive inorder function
    {
        recursiveInorderhelper(root);
    }
}
public class LAB3 
{
	public static void main(String[] args) 
    {
        AVL avl = new AVL();
        Scanner sc = new Scanner(System.in);
        int ch;
        do
        {
            System.out.println("\n*********************");
            System.out.println("MENU:\n1.ACCEPT\n2.DISPLAY\n3.EXIT");
            System.out.println("*********************");
            System.out.println("Enter your choice:");
            ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                    avl.create();
                    break;
                case 2:
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Name     \tTelephone  ");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                    avl.recursiveInorder();
                    break;
            }
        }while(ch != 3);
    }
}
/*
    Time Complexity:
    insert                                 O(log n)
    RL                                     O(1)
    LR                                     O(1)
    RR                                     O(1)
    RL                                     O(1)  
    balancefactor                          O(1)
    height                                 O(logn)
*/ 

/*  OUTPUT :

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT
*********************
Enter your choice:
1
Enter the name:
aditi
Enter the telephone number:
98700000

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT
*********************
Enter your choice:
1
Enter the name:
priya
Enter the telephone number:
50000022

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT
*********************
Enter your choice:
1
Enter the name:
zoya
Enter the telephone number:
49999999

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT
*********************
Enter your choice:
1
Enter the name:
madhav
Enter the telephone number:
59999999

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT
*********************
Enter your choice:
1
Enter the name:
aaditya
Enter the telephone number:
4000022

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT
*********************
Enter your choice:
1
Enter the name:
dhavni
Enter the telephone number:
6999999

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT
*********************
Enter your choice:
2
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Name            Telephone
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

aaditya 4000022
aditi   98700000
dhavni  6999999
madhav  59999999
priya   50000022
zoya    49999999

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT
*********************
Enter your choice:
1
Enter the name:
jaya
Enter the telephone number:
59839332

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT
*********************
Enter your choice:
1
Enter the name:
darya
Enter the telephone number:
53948343

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT
*********************
Enter your choice:
2
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Name            Telephone
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

aaditya 4000022
aditi   98700000
darya   53948343
dhavni  6999999
jaya    59839332
madhav  59999999
priya   50000022
zoya    49999999

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT
*********************
Enter your choice:
3
*/
 
