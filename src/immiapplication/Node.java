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
public class Node
{
    protected Applicant data;
    protected Node link;
    protected int appNo;
 
    /*  Constructor  */
    //to create a random number, we add ppNo to a random 3 digit number at the end.
    public Node()
    {
        link = null;
        data = new Applicant();
        //random application number logic
        appNo = (data.getPPNo() * 1000) + (int)(Math.random() * 1000);
    }    
    /*  Constructor  */
    public Node(Applicant d,Node n)
    {
        data = d;
        link = n;
        appNo = (data.getPPNo() * 1000) + (int)(Math.random() * 1000);
    }    
    /*  Function to set link to next Node  */
    public void setLink(Node n)
    {
        link = n;
    }    
    /*  Function to set data to current Node  */
    public void setData(Applicant d)
    {
        data = d;
    }    
    /*  Function to get link to next node  */
    public Node getLink()
    {
        return link;
    }    
    /*  Function to get data from current Node  */
    public Applicant getData()
    {
        return data;
    }
    
    public int getAppNo(){
        return appNo;
    }
    
}