/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sith7
 */
public class DatabaseConnection {
   static Connection conn ;
static Statement stmt ;
static ResultSet rs ;    
    
public DatabaseConnection()
{
    try{
        Class.forName("com.mysql.jdbc.Driver");  
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");  
      stmt=conn.createStatement();  
        }
    catch(ClassNotFoundException | SQLException e)
       { System.out.println("DatabaseConnection error = "+e);} 
}

public Connection getConnection()
{   return conn;
}

public Statement getStatement()
{   
    return stmt;
}
public ResultSet getResultSet(String s , Statement st)
{
    try{
    rs=st.executeQuery(s);
     return rs;
    }
    catch(SQLException e)
    {   
        System.out.println("ResultSet error");
    }
    return null;
} 


}
