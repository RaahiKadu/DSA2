import java.util.*;
class heap
{
    int[] arr;
    int size, maxsize;
    Scanner sc = new Scanner(System.in);
    public heap(int size, int m) 
    {
        maxsize = size;
        this.size = 0;
        arr = new int[maxsize + 1];
        if(m == 1)             
            arr[0] = Integer.MAX_VALUE;
        else
            arr[0] = Integer.MIN_VALUE;
    }
    public void insert(int x) 
    {
        int el;
        char ch;
        do
        {
            System.out.print("Enter element : ");
            el = sc.nextInt();
            arr[++size] = el;
            int current = size;
            if(x == 1)          // for maxheap
            {
                while (arr[current] > arr[current / 2]) 
                { 
                    swap(current, current / 2); 
                    current = current / 2; 
                } 
            }
            else              // for minheap
            {
                while (arr[current] < arr[current / 2]) 
                { 
                    swap(current, current / 2); 
                    current = current / 2;  
                }
            } 
            System.out.print("Do you want to continue inserting elements? (Y / N) ");
            ch = sc.next().charAt(0); 
        }while(ch == 'Y' || ch == 'y');
    }
    void swap(int f, int s) 
    {
        int t;
        t = arr[f];
        arr[f] = arr[s];
        arr[s] = t;
    }
    void downHeapify(int pos) 
    {
        if (isLeaf(pos))
            return;
        if (arr[pos] < arr[2 * pos] || arr[pos] < arr[2 * pos + 1]) 
        {

            if (arr[2 * pos] > arr[2 * pos + 1]) 
            {
                swap(pos, 2 * pos);
                downHeapify(2 * pos);
            } 
            else 
            {
                swap(pos, 2 * pos + 1);
                downHeapify(2 * pos + 1);
            }
        }
    }   
    public void print() 
    {
        System.out.println("Root  "+"\tLeft child  "+"\tRight child  ");
        for (int i = 1; i <= size / 2; i++)
        {
            if(i == size / 2 && size % 2 == 0)
                System.out.print(arr[i] + "  \t" + arr[2 * i] + "\t\t" + "NULL");
            else
                System.out.print(arr[i] + "  \t" + arr[2 * i] + "\t\t" + arr[2 * i + 1]);
            System.out.println();
        }
    }
    public int extractMax() 
    {
        int max = arr[1];
        arr[1] = arr[size--];
        downHeapify(1);
        return max;
    }
    boolean isLeaf(int pos) 
    { 
        if (pos >= (size / 2) && pos <= size) 
            return true;  
        return false; 
    } 
    public void minHeapify(int pos) 
    { 
        if (!isLeaf(pos))                // If the node is not a leaf node and greater than any of its children
        { 
            if (arr[pos] > arr[2 * pos] || arr[pos] > arr[2 * pos + 1]) 
            { 
                if (arr[2 * pos] < arr[2 * pos + 1])        // Swap with the left child and heapify the left child 
                { 
                    swap(pos, 2 * pos ); 
                    minHeapify(2 * pos); 
                } 
                else                        // Swap with the right child and heapify the right child 
                { 
                    swap(pos, 2 * pos + 1); 
                    minHeapify(2 * pos + 1); 
                } 
            } 
        } 
    } 
    public int remove() 
    { 
        int p = arr[1];
        arr[1] = arr[size--]; // reduce size
        minHeapify(1); 
        return p; 
    } 
}
public class LAB5
{   
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int ch;
        heap maxHeap = new heap(25, 1);  
        heap minheap =  new heap(25, 0);   
        do
        {
            System.out.println("\n~~~~~~~~~~~MENU~~~~~~~~~~~~~");
            System.out.println("\n1. Insert in Max heap\n2. Delete from Max heap \n3. Print Max heap \n4. Insert in Min heap\n5. Delete from Min heap \n6. Print Min heap \n7. Exit");
            System.out.print("\nEnter your choice: ");
            ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                        maxHeap.insert(1);          
                        break;
                case 2:
                        System.out.println("The max is " + maxHeap.extractMax());  
                        break;
                case 3:
                        maxHeap.print();
                        break;     
                case 4:
                        minheap.insert(0);     
                        break;
                case 5:
                        System.out.println("The min is " + minheap.remove());
                        break;
                case 6:
                        minheap.print();   
                        break;    
            }         
        }while(ch != 7);
    }
} 
/*
upheapify/downheapify - O(H)
insert             - O(log N)
delete             - O(log N)
extract min/max    - O(1)
*/
/*
~~~~~~~~~~~MENU~~~~~~~~~~~~~

1. Insert in Max heap
2. Delete from Max heap
3. Print Max heap
4. Insert in Min heap
5. Delete from Min heap
6. Print Min heap
7. Exit

Enter your choice: 1
Enter element: 7
Do you want to continue inserting elements? (Y / N) y
Enter element: 9
Do you want to continue inserting elements? (Y / N) y
Enter element: 78
Do you want to continue inserting elements? (Y / N) y
Enter element: 3
Do you want to continue inserting elements? (Y / N) y
Enter element: 5
Do you want to continue inserting elements? (Y / N) y
Enter element: 2
Do you want to continue inserting elements? (Y / N) y
Enter element: 2
Do you want to continue inserting elements? (Y / N) n

~~~~~~~~~~~MENU~~~~~~~~~~~~~

1. Insert in Max heap
2. Delete from Max heap
3. Print Max heap
4. Insert in Min heap
5. Delete from Min heap
6. Print Min heap
7. Exit

Enter your choice: 3
Root    Left child      Right child
78      7               9
7       3               5
9       2               2

~~~~~~~~~~~MENU~~~~~~~~~~~~~

1. Insert in Max heap
2. Delete from Max heap
3. Print Max heap
4. Insert in Min heap
5. Delete from Min heap
6. Print Min heap
7. Exit

Enter your choice: 2
The max is 78

~~~~~~~~~~~MENU~~~~~~~~~~~~~

1. Insert in Max heap
2. Delete from Max heap
3. Print Max heap
4. Insert in Min heap
5. Delete from Min heap
6. Print Min heap
7. Exit

Enter your choice: 3
Root    Left child      Right child
9       7               2
7       3               5
2       2               NULL

~~~~~~~~~~~MENU~~~~~~~~~~~~~

1. Insert in Max heap
2. Delete from Max heap
3. Print Max heap
4. Insert in Min heap
5. Delete from Min heap
6. Print Min heap
7. Exit

Enter your choice: 4
Enter element: 5
Do you want to continue inserting elements? (Y / N) y
Enter element: 8
Do you want to continue inserting elements? (Y / N) y
Enter element: 78
Do you want to continue inserting elements? (Y / N) y
Enter element: 1
Do you want to continue inserting elements? (Y / N) y
Enter element: 6
Do you want to continue inserting elements? (Y / N) y
Enter element: 3
Do you want to continue inserting elements? (Y / N) y
Enter element: 7
Do you want to continue inserting elements? (Y / N) y
Enter element: 4
Do you want to continue inserting elements? (Y / N) n

~~~~~~~~~~~MENU~~~~~~~~~~~~~

1. Insert in Max heap
2. Delete from Max heap
3. Print Max heap
4. Insert in Min heap
5. Delete from Min heap
6. Print Min heap
7. Exit

Enter your choice:
6
Root    Left child      Right child
1       4               3
4       5               6
3       78              7
5       8               NULL

~~~~~~~~~~~MENU~~~~~~~~~~~~~

1. Insert in Max heap
2. Delete from Max heap
3. Print Max heap
4. Insert in Min heap
5. Delete from Min heap
6. Print Min heap
7. Exit

Enter your choice: 5
The min is 1

~~~~~~~~~~~MENU~~~~~~~~~~~~~

1. Insert in Max heap
2. Delete from Max heap
3. Print Max heap
4. Insert in Min heap
5. Delete from Min heap
6. Print Min heap
7. Exit

Enter your choice: 6
Root    Left child      Right child
3       4               8
4       5               6
8       78              7

~~~~~~~~~~~MENU~~~~~~~~~~~~~

1. Insert in Max heap
2. Delete from Max heap
3. Print Max heap
4. Insert in Min heap
5. Delete from Min heap
6. Print Min heap
7. Exit

Enter your choice: 5
The min is 3

~~~~~~~~~~~MENU~~~~~~~~~~~~~

1. Insert in Max heap
2. Delete from Max heap
3. Print Max heap
4. Insert in Min heap
5. Delete from Min heap
6. Print Min heap
7. Exit

Enter your choice: 6
Root    Left child      Right child
4       5               8
5       7               6
8       78              NULL

~~~~~~~~~~~MENU~~~~~~~~~~~~~

1. Insert in Max heap
2. Delete from Max heap
3. Print Max heap
4. Insert in Min heap
5. Delete from Min heap
6. Print Min heap
7. Exit

Enter your choice: 5
The min is 4

~~~~~~~~~~~MENU~~~~~~~~~~~~~

1. Insert in Max heap
2. Delete from Max heap
3. Print Max heap
4. Insert in Min heap
5. Delete from Min heap
6. Print Min heap
7. Exit

Enter your choice: 6
Root    Left child      Right child
5       78              8
78      7               6

~~~~~~~~~~~MENU~~~~~~~~~~~~~

1. Insert in Max heap
2. Delete from Max heap
3. Print Max heap
4. Insert in Min heap
5. Delete from Min heap
6. Print Min heap
7. Exit

Enter your choice: 5
The min is 5

~~~~~~~~~~~MENU~~~~~~~~~~~~~

1. Insert in Max heap
2. Delete from Max heap
3. Print Max heap
4. Insert in Min heap
5. Delete from Min heap
6. Print Min heap
7. Exit

Enter your choice: 6
Root    Left child      Right child
6       78              8
78      7               NULL

~~~~~~~~~~~MENU~~~~~~~~~~~~~

1. Insert in Max heap
2. Delete from Max heap
3. Print Max heap
4. Insert in Min heap
5. Delete from Min heap
6. Print Min heap
7. Exit

Enter your choice: 7
*/
