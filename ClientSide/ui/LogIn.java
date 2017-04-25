package login;



import java.awt.Desktop;
import java.awt.EventQueue;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javax.swing.text.html.ImageView;
//import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class LogIn extends Application {
    private final Desktop desktop = Desktop.getDesktop();//get desktop

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {

        AnchorPane group1 = new AnchorPane();
        StackPane group2=new StackPane();
        AnchorPane group3 = new AnchorPane();
        final Scene scene1 = new Scene(group1,500,350);//login scene
        final Scene scene2 = new Scene(group2,900,600 );//main scene
        final Scene scene3 = new Scene(group3);//not yet used

        primaryStage.setTitle("Many Scenes");
        Label username =new Label("Username");
        username.setLayoutX(116);
        username.setLayoutY(145);
        TextField textuser=new TextField();
        textuser.setLayoutX(177);
        textuser.setLayoutY(141);
        username.setTextFill(Color.web("#0076a3"));
        textuser.setPromptText("Username");
        Label password=new Label("Password");
        password.setLayoutX(116);
        password.setLayoutY(197);
        PasswordField textpass=new PasswordField();
        textpass.setLayoutX(177);
        textpass.setLayoutY(193);
        textpass.setPromptText("Password");
        Button login=new Button("Sign");
       // login.setStyle("-fx-background-color: cornflowerblue;-fx-padding: 5");
        login.setLayoutY(193);
        login.setLayoutX(342);
        login.setOnAction(new EventHandler<ActionEvent>() {    //open main scene
            @Override
            public void handle(javafx.event.ActionEvent event) {
                final FileChooser fileChooser= new FileChooser();  //the class to getfiles
                primaryStage.setScene(scene2);//second scene layout
               // Button btn=new Button("YES");
                BorderPane border=new BorderPane();
                MenuBar menuBar=new MenuBar();
                //MENU 1
                Menu active=new Menu("Active");
                //menu items
                MenuItem itmNew=new javafx.scene.control.MenuItem("New");
                //menu 2
                Menu contact=new Menu("Contacts");
                //menu items
                MenuItem itmCut=new javafx.scene.control.MenuItem("Cut");
                //menu3
                Menu help=new Menu("Help");
                //menu items
                MenuItem itmAboutUs=new javafx.scene.control.MenuItem("About Us");
                //submenu
                Menu subSearch=new Menu("Search");
                //menuItems
                MenuItem itmFind=new javafx.scene.control.MenuItem("Find...");
                active.getItems().addAll(itmNew);
                contact.getItems().addAll(itmCut);
                help.getItems().addAll(itmAboutUs);
                subSearch.getItems().addAll(itmFind);
                contact.getItems().add(subSearch);
        
                menuBar.getMenus().addAll(active,contact,help );
                menuBar.setStyle("-fx-padding:10 0 10 5");
                menuBar.setMinHeight(40);
                menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
                border.setTop(menuBar);
                        
                final SplitPane sp = new SplitPane();
                GridPane left = new GridPane();
                SplitPane right = new SplitPane();
                sp.getItems().addAll(left,right);
                border.setCenter(sp);
                Platform.runLater(new Runnable() {
                @Override
                public void run() {
                sp.setDividerPositions(0.25f, 0.75f);
                }
            });
                
                VBox vbox=new VBox(20);
                
                HBox hbox1=new HBox(10);
                TextField search=new TextField();
                search.setId("textField");
                group2.getChildren().addAll(search);
                group2.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
                search.setPrefWidth(200);
                search.setPrefHeight(40);
                hbox1.setMargin(search, new javafx.geometry.Insets(10, 10, 20, 20));
                search.setPromptText("Search a contact");
                search.setFocusTraversable(false);
                ObservableList list=hbox1.getChildren();
                //adding all thenodes to the observable list(hbox)
                list.addAll(search);
                
                HBox hbox2=new HBox(10);
                hbox2.setPadding(new javafx.geometry.Insets(5,12,15,10));
                    String imagePath = "/images/icons/user-64.png";
                    // Scale the iamge to 200 X 100
                    double requestedWidth = 30;
                    double requestedHeight = 30;
                    boolean preserveRatio = true;
                    boolean smooth = true;
                    Image img = new Image(imagePath,
                    requestedWidth,
                    requestedHeight,
                    preserveRatio,
                    smooth);
                ImageView pIcon=new ImageView(img);
                Label people=new Label("People");
                ObservableList list2=hbox2.getChildren();
                //adding all thenodes to the observable list(hbox)
                list2.addAll(pIcon,people);
                
                
                HBox hbox3=new HBox(10);
                hbox3.setPadding(new javafx.geometry.Insets(5,12,15,10));
                    String imagePath2 = "images/icons/time-64.png";
                    // Scale the iamge to 200 X 100
                    double requestedWidth2 = 30;
                    double requestedHeight2 = 30;
                    boolean preserveRatio2 = true;
                    boolean smooth2 = true;
                    Image img2 = new Image(imagePath2,
                    requestedWidth2,
                    requestedHeight2,
                    preserveRatio2,
                    smooth2);
                ImageView rIcon=new ImageView(img2);
                Label recent=new Label("Recent");
                ObservableList list3=hbox3.getChildren();
                //adding all thenodes to the observable list(hbox)
                list3.addAll(rIcon,recent);
                
                
                HBox hbox4=new HBox(10);
                hbox4.setPadding(new javafx.geometry.Insets(5,12,15,10));
                String imagePath3 = "/images/icons/common-calendar-month-outline-stroke-64.png";
                    // Scale the iamge to 200 X 100
                    double requestedWidth3 = 30;
                    double requestedHeight3 = 30;
                    boolean preserveRatio3 = true;
                    boolean smooth3 = true;
                    Image img3 = new Image(imagePath3,
                    requestedWidth3,
                    requestedHeight3,
                    preserveRatio3,
                    smooth3);
                ImageView eIcon=new ImageView(img3);
                Label events=new Label("Events");
                ObservableList list4=hbox4.getChildren();
                //adding all thenodes to the observable list(hbox)
                list4.addAll(eIcon,events);
                
                
                HBox hbox5=new HBox(10);
                hbox5.setPadding(new javafx.geometry.Insets(5,12,15,10));
                String imagePath4 = ("/images/icons/Group_of_People-64.png");
                    // Scale the iamge to 200 X 100
                    double requestedWidth4 = 40;
                    double requestedHeight4 = 40;
                    boolean preserveRatio4 = true;
                    boolean smooth4 = true;
                    Image img4 = new Image(imagePath4,
                    requestedWidth4,
                    requestedHeight4,
                    preserveRatio4,
                    smooth4);
                
                ImageView wIcon=new ImageView(img4);
                Label workgroups=new Label("Workgroups");
                ObservableList list5=hbox5.getChildren();
                //adding all thenodes to the observable list(hbox)
                list5.addAll(wIcon,workgroups);
                left.add(hbox1, 0, 0);
                left.add(hbox2, 0, 1);
                left.add(hbox3, 0, 2);
                left.add(hbox4, 0, 3);
                left.add(hbox5, 0, 4);
                vbox.getChildren().addAll(left);
                group2.getChildren().addAll(border);
                
                SplitPane top=new SplitPane();
                SplitPane bottom=new SplitPane();
                right.getItems().addAll(top,bottom);
                Platform.runLater(new Runnable() {
                @Override
                public void run() {
                sp.setDividerPositions(0.20f, 0.80f);
                }
            });
                right.setOrientation(Orientation.VERTICAL);
                
               
                String imagePathProf = "/images/icons/ryan.jpg";
                    // Scale the iamge to 200 X 100
                    double requestedWidthProf = 200;
                    double requestedHeightProf = 200;
                    boolean preserveRatioProf = true;
                    boolean smoothProf = true;
                    Image profile = new Image(imagePathProf,
                    requestedWidthProf,
                    requestedHeightProf,
                    preserveRatioProf,
                    smoothProf);
                ImageView profView=new ImageView(profile);
                                
                VBox iconsBox=new VBox();
                HBox profBox=new HBox();
                profBox.setPrefHeight(200);
                profBox.setPadding(new javafx.geometry.Insets(15,10,10,15));
                Button btn=new Button("Edit profile");
                profBox.setMargin(btn, new javafx.geometry.Insets(170, 0, 10, 10));
                btn.setOnAction(                        //set the file from dektop
                        (javafx.event.ActionEvent e) -> {
                            File file = fileChooser.showOpenDialog(primaryStage);
                            if (file != null) {
                                openFile(file);
                            }
                        });
                
                String imagePathCall = "/images/icons/11_function-64.png";
                    // Scale the iamge to 200 X 100
                    double requestedWidthCall = 50;
                    double requestedHeightCall = 50;
                    boolean preserveRatioCall = true;
                    boolean smoothCall = true;
                    Image call = new Image(imagePathCall,
                    requestedWidthCall,
                    requestedHeightCall,
                    preserveRatioCall,
                    smoothCall);
                ImageView callView=new ImageView(call);
                profBox.setMargin(callView, new javafx.geometry.Insets(10, 10, 0, 150));
                
                String imagePathPause = "/images/icons/ic_pause_circle_fill_48px-64.png";
                    // Scale the iamge to 200 X 100
                    double requestedWidthPause = 40;
                    double requestedHeightPause = 40;
                    boolean preserveRatioPause = true;
                    boolean smoothPause = true;
                    Image pause = new Image(imagePathPause,
                    requestedWidthPause,
                    requestedHeightPause,
                    preserveRatioPause,
                    smoothPause);
                ImageView pauseView=new ImageView(pause);
                profBox.setMargin(pauseView, new javafx.geometry.Insets(15, 10, 0, 0));
                ObservableList profList=profBox.getChildren();
                profList.addAll(profView,btn,callView,pauseView);
                
                
                HBox icons=new HBox();
                icons.setPadding(new javafx.geometry.Insets(5,12,15,50));
                String imagePathRecord = "/images/icons/icon-mic-a-64.png";
                    // Scale the iamge to 200 X 100
                    double requestedWidthRecord = 40;
                    double requestedHeightRecord = 40;
                    boolean preserveRatioRecord = true;
                    boolean smoothRecord = true;
                    Image record = new Image(imagePathRecord,
                    requestedWidthRecord,
                    requestedHeightRecord,
                    preserveRatioRecord,
                    smoothRecord);
                ImageView recordView=new ImageView(record);
                profBox.setMargin(recordView, new javafx.geometry.Insets(10, 10, 10, 10));
                
                String imagePathVideo = "/images/icons/icons_video-64.png";
                    // Scale the iamge to 200 X 100
                    double requestedWidthVideo = 40;
                    double requestedHeightVideo = 40;
                    boolean preserveRatioVideo = true;
                    boolean smoothVideo = true;
                    Image video = new Image(imagePathVideo,
                    requestedWidthVideo,
                    requestedHeightVideo,
                    preserveRatioVideo,
                    smoothVideo);
                ImageView videoView=new ImageView(video);
                profBox.setMargin(videoView, new javafx.geometry.Insets(10, 10, 10, 10));
                String imagePathShare = "/images/icons/139-64.png";
                    // Scale the iamge to 200 X 100
                    double requestedWidthShare = 40;
                    double requestedHeightShare = 40;
                    boolean preserveRatioShare = true;
                    boolean smoothShare = true;
                    Image share = new Image(imagePathShare,
                    requestedWidthShare,
                    requestedHeightShare,
                    preserveRatioShare,
                    smoothShare);
                ImageView shareView=new ImageView(share);
                profBox.setMargin(shareView, new javafx.geometry.Insets(10, 10, 10, 10));
                
                String imagePathAddPerson = "/images/icons/add_user-64.png";
                    // Scale the iamge to 200 X 100
                    double requestedWidthAddPerson = 40;
                    double requestedHeightAddPerson = 40;
                    boolean preserveRatioAddPerson = true;
                    boolean smoothAddPerson = true;
                    Image addPerson = new Image(imagePathAddPerson,
                    requestedWidthAddPerson,
                    requestedHeightAddPerson,
                    preserveRatioAddPerson,
                    smoothAddPerson);
                ImageView addPersonView=new ImageView(addPerson);
                profBox.setMargin(addPersonView, new javafx.geometry.Insets(10, 10, 10, 10));
                
                String imagePathCall2 = "/images/icons/11_function-64.png";
                    // Scale the iamge to 200 X 100
                    double requestedWidthCall2 = 40;
                    double requestedHeightCall2 = 40;
                    boolean preserveRatioCall2 = true;
                    boolean smoothCall2 = true;
                    Image call2 = new Image(imagePathCall2,
                    requestedWidthCall2,
                    requestedHeightCall2,
                    preserveRatioCall2,
                    smoothCall2);
                ImageView call2View=new ImageView(call2);
                profBox.setMargin(call2View, new javafx.geometry.Insets(10, 10, 10, 10));
                
                String imagePathText = "/images/icons/messages-64.png";
                    // Scale the iamge to 200 X 100
                    double requestedWidthText = 40;
                    double requestedHeightText = 40;
                    boolean preserveRatioText = true;
                    boolean smoothText = true;
                    Image text = new Image(imagePathText,
                    requestedWidthText,
                    requestedHeightText,
                    preserveRatioText,
                    smoothText);
                ImageView textView=new ImageView(text);
                profBox.setMargin(textView, new javafx.geometry.Insets(10, 10, 0, 10));
                
                String imagePathFile = "/images/icons/send-64.png";
                    // Scale the iamge to 200 X 100
                    double requestedWidthFile = 40;
                    double requestedHeightFile = 40;
                    boolean preserveRatioFile = true;
                    boolean smoothFile = true;
                    Image file = new Image(imagePathFile,
                    requestedWidthFile,
                    requestedHeightFile,
                    preserveRatioFile,
                    smoothFile);
                ImageView fileView=new ImageView(file);
                profBox.setMargin(fileView, new javafx.geometry.Insets(10, 10, 10, 10));
                
                ObservableList iconList=icons.getChildren();
                iconList.addAll(recordView,videoView,shareView,addPersonView,call2View,textView,fileView);
                
                
                iconsBox.getChildren().addAll(profBox,icons);
                top.getItems().addAll(iconsBox);
                
                TextArea smsDisplay=new TextArea();
                bottom.getItems().addAll(smsDisplay);
            }
        });
        group1.getChildren().addAll(new Label("Welcome"),username,textpass,password,textuser,login);//added all nodes to root ancho

        primaryStage.setScene(scene1);
        primaryStage.show();


    }
    private void openFile(File file) {              //file method
        EventQueue.invokeLater(() -> {
            try {
                desktop.open(file);
            } catch (IOException ex) {
                Logger.getLogger(LogIn.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        });
    }
        }


    
    

