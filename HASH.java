import java.util.*;
class Customer 
{
	long id;
	String name;
	double balance;
	public Customer(long id, String nm, double bal) 
    {
		this.id = id;
		name = nm;
		balance = bal;
	}
}
class Table 
{
	int size;
	Customer hashtable[];	
    Scanner sc = new Scanner(System.in);
    public Table()
    {
        size = 10;
        hashtable = new Customer[size];	
    }
	int hash(long key)
	{
        return (int)key % size;
	}
    boolean full()
    {
        for(int i = 0; i < size; i++)
        {
            if(hashtable[i] == null)
                return false;
        }
        return true;
    }     
	void create()
	{
		if(full())
        {
            System.out.println("Table is full.");
            return;
        }
        System.out.print("Enter id to be inserted : ");
        long k = sc.nextLong();
        int hashofkey = hash(k);
        while(hashofkey < size && hashtable[hashofkey] != null)
        {
            hashofkey++;
            hashofkey = hashofkey % size;
        }
        System.out.print("Enter name : ");
        String n = sc.next();
        System.out.print("Enter balance : ");
        double bal = sc.nextDouble();
        hashtable[hashofkey] = new Customer(k, n, bal);
        System.out.println("Key sucessfully added.");
	}
    boolean empty()
    {
        for(int i = 0; i < size; i++)
        {
            if(hashtable[i] != null)
                return false;
        }
        return true;
    }
	void display()
	{
        if(empty())
        {
            System.out.println("Table is empty.");
            return;
        }
        System.out.println("ID " + "\t" + "NAME"+ "\t" + "BALANCE");
		for(int i = 0; i < size; i++)
        {
            if(hashtable[i] != null)
                System.out.println(hashtable[i].id  + "\t" + hashtable[i].name + "\t" + hashtable[i].balance);
        }
        System.out.println();
	}
	void search()
	{
        if(empty())
        {
            System.out.println("Table is empty.");
            return;
        }   
		System.out.print("Enter ID to be searched : ");
        int k = sc.nextInt();
        int hashofkey = hash(k);
        while(hashtable[hashofkey] != null)
        {
            if(hashtable[hashofkey].id == k)
            {
                System.out.println("ID : " + k + " is present.");
                return;
            }
            hashofkey++;
            hashofkey = hashofkey % size;
        }
        System.out.println("ID : " + k   + " is not present.");
	}
    void delete()
    {
        if(empty())
        {
            System.out.println("Table is empty.");
            return;
        }   
        System.out.print("Enter ID to be deleted : ");
        int k = sc.nextInt();
        int hashofkey = hash(k);
        while(hashtable[hashofkey] != null)
        {
            if(hashtable[hashofkey].id == k)
            {
                hashtable[hashofkey] = null;
                System.out.println("Record deleted.");
                return;
            }
            hashofkey++;
            hashofkey = hashofkey % size;
        }   
        System.out.println("Record not deleted not found.");
    }
}
public class LAB6
{
	public static void main(String args[]) 
    {
		Table t = new Table();
		Scanner sc = new Scanner(System.in);
		int choice;
		while(true)
        {
            System.out.println("\n~~~~~~~~~~~MENU~~~~~~~~~~~~~");
            System.out.println("1. INSERT \n2. DISPLAY\n3. SEARCH\n4. DELETE\n5. EXIT");
            System.out.print("Enter the option : ");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                        t.create();
                        break;
                case 2:
                        t.display();
                        break;
                case 3:
                        t.search();
                        break;
                case 4:
                        t.delete();
                        break;
                case 5:
                    System.exit(0);
            }
		}
	}
}
/*  time complexity :
create : O (1) WC : O(N )
display : O(N)
search : O(1)
delete : O(1)
isfull : O(N)
isempty : O(N)
*/
/* 
OUTPUT :
C:\Users\Yogesh\Desktop\labs\dsa2>java LAB6

~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 1
Enter id to be inserted : 89
Enter name : aditi
Enter balance : 67
Key sucessfully added.

~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 2
ID      NAME    BALANCE
89      aditi   67.0


~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 1
Enter id to be inserted : 99
Enter name : shilpa
Enter balance : 77
Key sucessfully added.

~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 2
ID      NAME    BALANCE
99      shilpa  77.0
89      aditi   67.0


~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 90

~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 1
Enter id to be inserted : 90
Enter name : yogesh
Enter balance : 21
Key sucessfully added.

~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 2
ID      NAME    BALANCE
99      shilpa  77.0
90      yogesh  21.0
89      aditi   67.0


~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 1
Enter id to be inserted : 55
Enter name : shilpa
Enter balance : 55
Key sucessfully added.

~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 2
ID      NAME    BALANCE
99      shilpa  77.0
90      yogesh  21.0
55      shilpa  55.0
89      aditi   67.0


~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 3
Enter ID to be searched : 66
ID : 66 is not present.

~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 3
Enter ID to be searched : 55
ID : 55 is present.

~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 4
Enter ID to be deleted : 44
Record not deleted not found.

~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 4
Enter ID to be deleted : 90
Record deleted.

~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 2
ID      NAME    BALANCE
99      shilpa  77.0
55      shilpa  55.0
89      aditi   67.0


~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 4
Enter ID to be deleted : 99
Record deleted.

~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 2
ID      NAME    BALANCE
55      shilpa  55.0
89      aditi   67.0


~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 4
Enter ID to be deleted : 89
Record deleted.

~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 2
ID      NAME    BALANCE
55      shilpa  55.0


~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 4
Enter ID to be deleted : 8
Record not deleted not found.

~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 4
Enter ID to be deleted : 55
Record deleted.

~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 2
Table is empty.

~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 3
Table is empty.

~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 4
Table is empty.

~~~~~~~~~~~MENU~~~~~~~~~~~~~
1. INSERT
2. DISPLAY
3. SEARCH
4. DELETE
5. EXIT
Enter the option : 5
*/

