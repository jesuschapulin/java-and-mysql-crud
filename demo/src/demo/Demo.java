/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class Demo {
    private static final String USER="root";
    private static final String PASSWORD="";
    private static final String DB="jdbc:mysql://localhost:3307/hotel";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Demo d=new Demo();
       String query="select *from habitaciones";
       d.query(query);
    }
    public void query(String query){
       Connection conn=null;
       try{
           conn=DriverManager.getConnection(DB,USER,PASSWORD);
           System.out.println("connected");
           Statement statement=conn.createStatement();
           ResultSet results = statement.executeQuery(query);
           while(results.next()){
               System.out.println(results.getString("nombre"));
           }
          
       }catch(SQLException e){
           
       }
   }
    
}
