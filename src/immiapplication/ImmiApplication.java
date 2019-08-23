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
import java.util.Scanner;

public class ImmiApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int ppno;
        String doa, fn, ln, type;
        Applicant temp;
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        LinkedList list = new LinkedList(); 
        
        char ch = 'n';
        /*  Perform list operations  */
        while (ch == 'n'|| ch == 'n')
        {
            System.out.println("\n Welcome to Immigration Assist Program: \n");
            System.out.println("0. Press 0 to view the current queue)");
            System.out.println("1. Press 1 to Start a Child Applicant(start of the queue)");
            System.out.println("2. Press 2 to Start a Normal Applicant(end of the queue)");
            System.out.println("3. Press 3 to Enter applicant at a given position");
            System.out.println("4. Press 4 to Delete an Applicant with Application ID");
            System.out.println("5. Press 5 to Search an applicant with an ID");
            System.out.println("6. Press 6 to Get the size of the queue"); 
            System.out.println("7. Press 7 to Display and Verify Applicant Information with App ID"); 
            System.out.println("8. Press 8 to Edit Applicant Information with App ID");
            System.out.println("9. Press 9 to Delete the last n records");
            System.out.println("10. Press 10 to EXIT.");
            System.out.println(" \n Enter Option: ");       

            int choice = scan.nextInt();            
            switch (choice)
            {
            case 0 :
                list.display();
                break;
                
            case 1 : 
                System.out.println("\n Child Application started: \n ");
                System.out.println("Enter Passport Number of Applicant?");
                ppno = scan.nextInt();
                System.out.println("Enter Date of Arrival of the Applicant?");
                doa = scan.next();
                System.out.println("Enter First Name of the Applicant?");
                fn = scan.next();
                System.out.println("Enter Last Name of the Applicant?");
                ln = scan.next();
                type = "Child Applicant";
                temp = new Applicant(ppno, doa, fn, ln, type);
                System.out.println("\n Success. The Application No is: "+ list.insertAtStart(temp) + ". Please keep it safe.");              
                break;  
                
            case 2 : 
                System.out.println("\n Normal Application started: \n ");
                System.out.println("Enter Passport Number of Applicant?");
                ppno = scan.nextInt();
                System.out.println("Enter Date of Arrival of the Applicant?");
                doa = scan.next();
                System.out.println("Enter First Name of the Applicant?");
                fn = scan.next();
                System.out.println("Enter Last Name of the Applicant?");
                ln = scan.next();
                type = "Normal Applicant";
                temp = new Applicant(ppno, doa, fn, ln, type);
                System.out.println("\n Success. The Application No is: "+ list.insertAtEnd(temp) + ". Please keep it safe.");                
                break;    
            
            case 3 : 
                System.out.println("\n Child Application at Position Specified: \n ");
                System.out.println("Enter the position to enter applicant at?");
                int pos = scan.nextInt();
                //Checking if the postion is valid
                if (pos <= 1 || pos > list.getSize() )
                    System.out.println("Invalid position \n");
                else {
                    //insert into a given postion               
                    System.out.println("Enter Passport number of Applicant?");
                    ppno = scan.nextInt();
                    System.out.println("Enter Date of Arrival of the Applicant?");
                    doa = scan.next();
                    System.out.println("Enter First Name of the Applicant?");
                    fn = scan.next();
                    System.out.println("Enter Last Name of the Applicant?");
                    ln = scan.next();
                    type = "Child Applicant";
                    temp = new Applicant(ppno, doa, fn, ln, type);
                    System.out.println("\n Success! \n The Application No is: "+ list.insertAtPos(temp, pos) + ". Please keep it safe.");                
                }
                break;                                          
            
            case 4 : 
                System.out.println("\n Delete Menu: \n ");
                System.out.println("Enter the Application ID?");               
                int delid = scan.nextInt();
                int delpos = list.search(delid);
                if (delpos == -1)
                    System.out.println("No such applicant exists! Invalid Application ID. Please try again. \n");
                else {
                    list.deleteAtPos(delpos); 
                    System.out.println("Item id: " + delid + " successfully deleted. \n New Size = " + list.getSize());
                }
                break;
                
            case 5 : 
                System.out.println("\n Search Menu: \n ");
                System.out.println("Enter the Application ID?");
                int appid = scan.nextInt();      
                int counter = list.search(appid);
                if (counter != -1)
                    System.out.println("Your Application is in:  " + counter + " position.");
                else
                    System.out.println("Application  ID:" + appid + "not found. Please try valid ID.");
                break;  
                
            case 6 : 
                System.out.println("\n Search Menu: \n ");
                System.out.println("Size = "+ list.getSize() +" \n");
                break; 
            
            case 7 :
                System.out.println("\n Display and Verify Menu: \n ");
                System.out.println("Enter the Application ID?");
                int viewID = scan.nextInt();
                if (list.displayApplicant(viewID) == null)
                    System.out.println("Invalid Application ID. Please try again.");
                else {
                    System.out.println("Following Applicant Found:");
                    System.out.println(list.displayApplicant(viewID).getAppInfo());        
                }
                break; 
                
            case 8 : 
                System.out.println("\n Edit Menu: \n ");
                System.out.println("Enter the Application ID?");
                int editID = scan.nextInt();
                if (list.displayApplicant(editID) == null)
                    System.out.println("Invalid Application ID. Please try again.");
                else {
                    System.out.println("Following Applicant Found:");
                    System.out.println(list.displayApplicant(editID).getAppInfo());
                    System.out.println("\n Re-enter the following details: \n ");
                    System.out.println("Edit Passport Number of Applicant?");
                    ppno = scan.nextInt();
                    System.out.println("Edit Date of Arrival of the Applicant?");
                    doa = scan.next();
                    System.out.println("Edit First Name of the Applicant?");
                    fn = scan.next();
                    System.out.println("Edit Last Name of the Applicant?");
                    ln = scan.next();
                    
                    if (list.editApplicant(editID, ppno, doa, fn, ln))
                        System.out.println("Applicant record update successful");
                    else 
                        System.out.println("There was some problem");
                    
                }
                break; 
                
            case 9 :
                System.out.println("\n Bulk Delete Menu: \n ");
                System.out.println("Enter the number of records you would like to delete?");
                int n = scan.nextInt();
                if (n <= list.getSize()) {
                    if (list.bulkDelete(n)) {
                         System.out.println(n + " records successfully deleted. \n New Size: " + list.getSize());
                     }
                    else {
                        System.out.println("Error Occurred");
                    }
                }
                else {
                    System.out.println("Error. Cannot delete more elements that on the queue. Please try again!");
                }
                break;
                
            //exit case    
            case 10 :
                System.out.println("Exiting... \n Thank you for using the application! \n See you again!");
                System.exit(0);
                
            //if anything else    
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            
            System.out.println("\n Do you want to exit (Type y or n)");
            ch = scan.next().charAt(0); 
            
        } 
        System.out.println("Exiting... \n Thank you for using the application! \n See you again!");
    }
    
}
