package LogIn;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class LogIn extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        AnchorPane root=new AnchorPane();
        Scene scene=new Scene(root,500,350);
        
        //username label
        Label username =new Label("Username");
        username.setLayoutX(116);
        username.setLayoutY(145);
        
        //textfield username
        TextField textuser=new TextField();
        textuser.setLayoutX(177);
        textuser.setLayoutY(141);
        username.setTextFill(Color.web("#0076a3"));
        textuser.setPromptText("Username");
        
        //password label
        Label password=new Label("Password");
        password.setLayoutX(116);
        password.setLayoutY(197);
        
        //password field
        PasswordField textpass=new PasswordField();
        textpass.setLayoutX(177);
        textpass.setLayoutY(193);
        textpass.setPromptText("Password");
        Button login=new Button("Sign");
        
       // login.setStyle("-fx-background-color: cornflowerblue;-fx-padding: 5");
        login.setLayoutY(193);
        login.setLayoutX(342);
        
        StackPane border=new StackPane();
        Scene scene2=new Scene(border,800,600);
        //open main scene
        login.setOnAction(new EventHandler<ActionEvent>() {    //open main scene
            @Override
            public void handle(javafx.event.ActionEvent event) {
                
                Bar open = new Bar();

                border.getChildren().add(open);
                primaryStage.setScene(scene2);//second scene layout
            }
        });
        root.getChildren().addAll(new Label("Welcome"),username,textpass,password,textuser,login);//added all nodes to root ancho
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Inheritance");
        primaryStage.show();

       

    

    //Scene scene = new Scene(root, 800,600);
    primaryStage.setScene(scene);
    primaryStage.show();
}
    public static void main(String[] args) {
        launch(args);
    }
    
}
