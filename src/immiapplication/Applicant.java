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
public class Applicant {
    private int ppNo;
    private String DOA;
    private String firstName;
    private String lastName;
    private String type;
    
    public Applicant() {
        ppNo = 0;
        DOA = "";
        firstName = "";
        lastName = "";
        type = "";
    }
    
    public Applicant(int pno, String d, String fn, String ln, String t) {
        ppNo = pno;
        DOA = d;
        firstName = fn;
        lastName = ln;
        type = t;
    }
    
    public String getAppInfo() {
        return "Applicants Details are: "
                + "\n Passport no: "+ ppNo + 
                "\n Date of Arrival: " + DOA + 
                "\n First Name: " + firstName + 
                "\n Last Name: " + lastName +
                "\n Type of Applicant:" + type +"\n";
    }
    
    public void editApplicant(int pp, String d, String fn, String ln) {
        ppNo = pp;
        DOA = d;
        firstName = fn;
        lastName = ln;
    }
    
    public int getPPNo(){
        return ppNo;
    }
           
}

