/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Sith7
 */
public class Admin_Model {
    
     Connection conn ;
     Statement stmt ;
     ResultSet rs ;    
    DatabaseConnection dc;
   public  Admin_Model()
     {
         dc = new DatabaseConnection(); 
         conn = dc.getConnection();
         stmt = dc.getStatement();
     }
    
    public boolean checkLogin(String name , String pass)
    {
        String sql = "select * from Login where FirstName like '"+name+"'";
        
        try
        {
        rs = dc.getResultSet(sql, stmt);
        if(rs.next())  
        {
            String q=rs.getString(9);
            System.out.println(q);
        if(pass.equals(q))
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
            System.out.println("CheckLogin error= "+e);
        }
        
        
        
    return false;
    }
    
    
    
    public void Insert(int PersonID,String FirstName,String LastName,String Email,String Address,String City,String ContactNumber,String Password)
   {
       String prRole = "Librarian";
         //int PersonID=1;
    String sql1;
    sql1 = "INSERT INTO Login(PersonID,role,FirstName,LastName,Email,Address,City,ContactNumber,Password) values ("+PersonID+",'"+prRole+"','"+FirstName+"','"+LastName+"','"+Email+"','"+Address+"','"+City+"',"+ContactNumber+",'"+Password+"')";
         try{
      stmt.executeUpdate(sql1);
    System.out.println("Successfully inserted");
         }
         catch(Exception e)
         {
         System.out.println("Insert Error"+e);
         }
   }
    
     public void Delete(int id)
   {
    String sql2;
    
         sql2 = "DELETE FROM Login where PersonID=('"+id+"')";
         try{
      stmt.executeUpdate(sql2);
    System.out.println("Successfully Deleted");
         }
         catch(Exception e)
         {
         System.out.println(e);
         }
   }
     
     
    

     
}
