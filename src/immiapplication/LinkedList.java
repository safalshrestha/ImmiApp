/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package immiapplication;

/**
 *
 * @author Safal
 */
public class LinkedList {
    protected Node start;
    protected Node end ;
    public int size ;
 
    /*  Constructor  */
    public LinkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    
    public Node getStartNode() {
        return start;
    }
    
    public Node getEndNode(){
        return end;
    }   
    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        return start == null;
    }
    /*  Function to get size of list  */
    public int getSize()
    {
        return size;
    }    
    /*  Function to insert an element at begining  */
    public int insertAtStart(Applicant val)
    {
        Node nptr = new Node(val, null);    
        size++ ;    
        if(start == null) 
        {
            System.out.println("Start is null");
            start = nptr;
            end = start;
            
        }
        else 
        {
            nptr.setLink(start);
            start = nptr;
        }
        return nptr.getAppNo();
    }
    /*  Function to insert an element at end  */
    public int insertAtEnd(Applicant val)
    {
        Node nptr = new Node(val,null);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            end.setLink(nptr);
            end = nptr;
        }
        return nptr.getAppNo();
    }
    /*  Function to insert an element at position  */
    public int insertAtPos(Applicant val , int pos)
    {
        Node nptr = new Node(val, null);                
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getLink() ;
                ptr.setLink(nptr);
                nptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size++ ;
        return nptr.getAppNo();
    }
    /*  Deleting the element at a given postion. 
        If deleting position 1, just change the next item as start.
        If deleting the last, iterate through all the elements until you reach the second last and make it the end
        If any other between item, change the previous nodes link to next elements head.*/
    public void deleteAtPos(int pos)
    {        
        if (pos == 1) 
        {
            start = start.getLink();
            size--; 
            return ;
        }
        if (pos == size) 
        {
            Node s = start;
            Node t = start;
            while (s != end)
            {
                t = s;
                s = s.getLink();
            }
            end = t;
            end.setLink(null);
            size --;
            return;
        }
        Node x = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {            
                System.out.println("DEBUG: FOUND");
                Node tmp = x.getLink();
                tmp = tmp.getLink();
                x.setLink(tmp);
                size--;
                return;
            }
            x = x.getLink();
        }
        return;
    }    
    
    // Checks whether the value appNo is present and return its pos number
    // in linked list
    public int search(int num)
    {
        int index = 1;
        Node current = start;
        while (current != null) {
            if (num == current.appNo) {
                return index;
            }
            index++;
            current = current.link;
        }

        return -1;
    }
    
    public Applicant displayApplicant(int num){
        Node current = start;
        while (current != null) {
            if (num == current.appNo) {
                return current.data;
            }
            current = current.link;
        }   
    return null;
    }
    
    public boolean editApplicant(int id, int pp, String d, String f, String l) {
        Node current = start;
        while (current != null) {
            if (id == current.appNo) {
                current.data.editApplicant(pp, d, f, l);
                return true;
            }
            current = current.link;
        }
        return false;
    }
    
    public boolean bulkDelete(int n) {
        int index = 1;
        int lastnum = size - n;
        Node current = start;
        while (current != null) {
            if (index == lastnum) {
                current.link = null;
                size = size - n;
                return true;
            }
            index++;
            current = current.link;
        }
        return false;
    }
    /*  Function to display elements  */
    public void display()
    {
        System.out.print("\n List of Applicants \n");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }
        int index = 1;
        if (start.getLink() == null) 
        {
            System.out.println("Queue No:" + index);
            System.out.println(start.getData().getAppInfo());
            return;
        }
        Node ptr = start;
        System.out.println("Queue No:" + index);
        index++;
        System.out.print(start.getData().getAppInfo() + "\n");
        ptr = start.getLink();
        while (ptr.getLink() != null)
        {
            System.out.println("Queue No:" + index);
            index++;
            System.out.print(ptr.getData().getAppInfo()+ "\n");
            ptr = ptr.getLink();
        }
        System.out.println("Queue No:" + index);
        System.out.print(ptr.getData().getAppInfo()+ "\n");
    }
    
}
