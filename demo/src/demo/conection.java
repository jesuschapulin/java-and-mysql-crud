/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;
import java.sql.*;
public class conection {
   private static final String USER="root";
   private static final String PASSWORD="";
   private static final String DB="jdbc:mysql://localhost:3307/hotel";
   
   public static void main(String[] args){
      
   }
   void query(String query){
       Connection conn=null;
       PreparedStatement stmt = null;
       try{
           conn=DriverManager.getConnection(DB,USER,PASSWORD);
           System.out.println("connected");
           stmt = conn.prepareStatement(query);
           ResultSet result = stmt.executeQuery();
           int columns = result.getMetaData().getColumnCount();

            StringBuilder message = new StringBuilder();

            while (result.next()) {
                for (int i = 1; i <= columns; i++) {
                    message.append(result.getString(i) + " ");
                }
                message.append("\n");
            }

            System.out.println(message); 
           stmt.close();
       }catch(SQLException e){
           
       }
   }
   
}
