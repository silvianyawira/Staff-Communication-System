package loginui;

import java.sql.*;
import java.util.*;

public class MyConnect extends MainUI{

    ResultSet rs1;
    Connection  conn; 
    String sql;
    PreparedStatement pst;
    Statement stmt;
    ResultSet rs;
    int r;
    String nm,dept;
    Scanner  in;
    public MyConnect() {
        
   
         
        
                
       try{
       Class.forName("com.mysql.jdbc.Driver");
         conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");
       System.out.println("Connected to database");
       
       stmt=conn.createStatement();
       sql="select * from studentInfo ";
       rs=stmt.executeQuery(sql);
       
       
       
       while(rs.next()){
           r=rs.getInt("Roll");
           nm=rs.getString("Name");
           dept=rs.getString("Dept");
           
           System.out.print("   Roll:"+r);
           System.out.print("  Name:"+nm);
           System.out.println("  Dept:"+dept);
       }
   }
                
    catch(Exception e)
    {
       e.printStackTrace();
    }
       list.setOnMouseClicked(e -> {
            try{
               sql="select * from studentInfo ";
               pst=conn.prepareStatement(sql);
               pst.setString(1,(String)list.getSelectionModel().getSelectedItem());
               rs1=pst.executeQuery(sql); 
               
               while(rs.next()){
           r=rs.getInt("Roll");
           nm=rs.getString("Name");
           dept=rs.getString("Dept");
           
           System.out.print("   Roll:"+r);
           System.out.print("  Name:"+nm);
           System.out.println("  Dept:"+dept);
       }
            }
            catch(Exception ev){
            }
    
});
    }
}
    
    
    

