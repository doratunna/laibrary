/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Sith7
 */
public class Librarian_Model {
    int id=0;
     Connection conn ;
     Statement stmt ;
     ResultSet rs ;    
    DatabaseConnection db;
   public  Librarian_Model()
     {
         db = new DatabaseConnection(); 
         conn = db.getConnection();
         stmt = db.getStatement();
        
     }
    
    public boolean checkLogin(String role,String name , String pass)
    {
        if(role=="librarian"){
        String sql = "select * from Login where FirstName like '"+name+"'";
        
        try
        {
        
        rs = db.getResultSet(sql, stmt);
        if(rs.next())  
        {
        if(pass.equals(rs.getString(9)))
        {
         return true;   
        } else{
            return false;
             }
         }
          
         conn.close();
         return false;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        }    
    return false;
    }
     
    
    
     public void Insert(String BookRefNo,String Name,String Author,String Publisher,String Quantity)
   {
       
      // String role;
        // role = "librarian";
         //int PersonID=1;
    String sql1;
    sql1 = "INSERT INTO Books(Refno,Name, Author, Publisher, Quantity) values ('"+BookRefNo+"','"+Name+"','"+Author+"','"+Publisher+"','"+Quantity+"')";
         try{
      stmt.executeUpdate(sql1);
    System.out.println("Successfully added");
    JOptionPane.showMessageDialog(null,"Successfully added");
         }
         catch(Exception e)
         {
         System.out.println(e);
         }
   }
     
     
      public void Issue(String BookRefNo,String ID, String Name, String CONTACT)
   {
       
      // String role;
        // role = "librarian";
         //int PersonID=1;
    String sql1;
    sql1 = "INSERT INTO Student(Refno,student_id, student_name, student_contact, issued_date) values ('"+BookRefNo+"','"+ID+"','"+Name+"','"+CONTACT+"')";
         try{
      stmt.executeUpdate(sql1);
    System.out.println("Successfully added");
    JOptionPane.showMessageDialog(null,"Successfully added");
         }
         catch(Exception e)
         {
         System.out.println(e);
         }
   }

public void Book_RefNo()
{


}


}
