/*
A news paper delivery boy every day drops news paper in a society having many lanes and houses.
Represent this as a graph using adjacency matrix or adjacency list. 
Perform Depth First traversal and Breadth First traversal.           
*/
import java.util.*;
class Graph
{
    int n;               //number of vertices
    int e;               //number of edges
    int[][] adjMat;      //adjacency matrix of the graph
    public Graph(int n, int e)
    {
        this.n = n;
        this.e = e;
        adjMat = new int[n][n];
    }
    public void createUsingAdjMat()
    {
        Scanner sc = new Scanner(System.in);   
        System.out.print("Enter lanes starting and ending point \n");
        int s, end;
        for(int i = 0; i < e; i++)
        {
            System.out.println("Enter edge " + (i + 1));
            System.out.print("Start : ");
            s = sc.nextInt();
            System.out.print("End : ");
            end = sc.nextInt();
            adjMat[s][end] = 1;
            adjMat[end][s] = 1;        
        }
    }
    public void displayAdjMat()
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                System.out.print(adjMat[i][j] + " ");
            System.out.println();
        }
    }
    public void bfs()   
    {   
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<Integer>();
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++)
            visited[i] = false;
        System.out.print("Starting point : ");
        int s = sc.nextInt();
        q.add(s);
        visited[s] = true;
        while(q.size() != 0)
        {
            s = q.remove();
            System.out.print(s + " ");
            for(int i = 0; i < n; i++)
            {
                if(adjMat[s][i] == 1 && visited[i] == false)
                {
                    q.add(i);    
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }
    public void dfs()
    {
        Scanner sc = new Scanner(System.in);
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++)
            visited[i] = false;
        Stack<Integer> stack = new Stack<Integer>();
        System.out.print("Starting point : ");
        int s = sc.nextInt();
        stack.push(s);
        while (!stack.empty())
        {
            s = stack.pop();
            // Stack may contain same vertex twice. So we need to print the popped item only if it is not visited.
            if (!visited[s])
            {
                System.out.print(s + " ");
                visited[s] = true;
            }
            for(int i = 0; i < n; i++)
            {
                if (adjMat[s][i] == 1 && visited[i] == false)
                    stack.push(i);
            }
        }
        System.out.println();
    }
}
public class LAB4
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Graph g;
        int n, e;
        System.out.print("Enter no of houses : ");
        n = sc.nextInt();
        System.out.print("Enter no of lanes : ");
        e = sc.nextInt();
        g = new Graph(n, e);
        g.createUsingAdjMat();
        g.displayAdjMat();
        while(true)
        {
            System.out.println("\n\t~~~~~~~~MENU~~~~~~~~");
            System.out.println("\n\t1. DFS");
            System.out.println("\n\t2. BFS");
            System.out.println("\n\t3. Exit");
            System.out.print("Enter your choice : ");
            int ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                    g.dfs();
                    break;
                case 2:
                    g.bfs();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
/*
    TIME COMPLEXITY :
            TC        
    BFS : O(V + E)   
    DFS : O(V + E)
    CREATE USING ADJACENCY MATRIX : O(V^2)
*/
/* OUTPUT
Enter no of houses : 8
Enter no of lanes : 7
Enter lanes starting and ending point
Enter edge 1
Start : 0
End : 1
Enter edge 2
Start : 1
End : 2
Enter edge 3
Start : 2
End : 3
Enter edge 4
Start : 2
End : 4
Enter edge 5
Start : 2
End : 5
Enter edge 6
Start : 3
End : 6
Enter edge 7
Start : 5
End : 7
0 1 0 0 0 0 0 0
1 0 1 0 0 0 0 0
0 1 0 1 1 1 0 0
0 0 1 0 0 0 1 0
0 0 1 0 0 0 0 0
0 0 1 0 0 0 0 1
0 0 0 1 0 0 0 0
0 0 0 0 0 1 0 0

        ~~~~~~~~MENU~~~~~~~~

        1. DFS

        2. BFS

        3. Exit
Enter your choice : 1
Starting point : 0
0 1 2 5 7 4 3 6

        ~~~~~~~~MENU~~~~~~~~

        1. DFS

        2. BFS

        3. Exit
Enter your choice : 2
Starting point : 0
0 1 2 3 4 5 6 7

        ~~~~~~~~MENU~~~~~~~~

        1. DFS

        2. BFS

        3. Exit
Enter your choice : 1
Starting point : 3
3 6 2 5 7 4 1 0

        ~~~~~~~~MENU~~~~~~~~

        1. DFS

        2. BFS

        3. Exit
Enter your choice : 2
Starting point : 3
3 2 6 1 4 5 0 7

        ~~~~~~~~MENU~~~~~~~~

        1. DFS

        2. BFS

        3. Exit
Enter your choice : 1
Starting point : 2
2 5 7 4 3 6 1 0

        ~~~~~~~~MENU~~~~~~~~

        1. DFS

        2. BFS

        3. Exit
Enter your choice : 2
Starting point : 2
2 1 3 4 5 0 6 7

        ~~~~~~~~MENU~~~~~~~~

        1. DFS

        2. BFS

        3. Exit
Enter your choice : 3
*/
