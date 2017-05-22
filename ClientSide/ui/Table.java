package loginui;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import java.sql.*;


public class Table {
    
    public static TableView <Person>events=new TableView();
    public static  ObservableList<Person> data =FXCollections.observableArrayList();
    static HBox hb=new HBox();
    
    static Connection  conn; 
    static String sql;
    static PreparedStatement pst=null;
    static Statement stmt;
    static ResultSet rs=null;
    
    
    
    public static StackPane table1(){
        TableColumn event = new TableColumn("Event");
        event.setMinWidth(200);
        event.setCellValueFactory(new PropertyValueFactory<>("Event"));
 
        TableColumn venue = new TableColumn("Venue");
        venue.setMinWidth(200);
        venue.setCellValueFactory(new PropertyValueFactory<>("Venue"));
        
        TableColumn date = new TableColumn("Date");
        date.setMinWidth(200);
        date.setCellValueFactory(new PropertyValueFactory<>("Date"));
 
        events.setItems(data);
        events.getColumns().addAll(event, venue,date);
 
        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            data.add(new Person("Z","X","4/5/2017"));
         });
        
        Button load=new Button("Load Table");
        load.setFont(Font.font("sanserif",15));
        load.setOnAction((ActionEvent e) -> {
            try{
                //MyConnect myConnect=new MyConnect();
                //myConnect.ConnectDB();
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Users?useSSL=false","root",""); 
              String query="select * from EventTable";  
              pst=conn.prepareStatement(query);
              rs=pst.executeQuery();
              
              while(rs.next()){
                  data.add(new Person (
                    rs.getString("Events"),
                    rs.getString("Venue"),
                    rs.getString("Date")
                  
                  ));
              
              
                events.setItems(data);
                
              }
              pst.close();
              rs.close();
            }
            catch(Exception e2){
                System.err.println(e2);
            }
         });
        
        hb.getChildren().addAll(addButton,load);
        hb.setSpacing(3);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(events, hb);
        StackPane stack =new StackPane();
        //stack.setPadding(events,new Insets(10,10,10,));
        stack.getChildren().add(vbox);        
        return stack;
    }
    
    
}
