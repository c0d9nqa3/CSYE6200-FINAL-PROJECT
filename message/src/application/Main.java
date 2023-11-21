package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        // left side 
        VBox leftSidebar = new VBox(10);
        leftSidebar.setPadding(new Insets(10));
        leftSidebar.setStyle("-fx-background-color: #2A5058; -fx-border-color: black; -fx-border-width: 1;");
        leftSidebar.setPrefWidth(200); // 左侧状态栏宽度

        
        String buttonStyle = "-fx-border-color: white; -fx-border-width: 1; -fx-border-insets: 5; "
                             + "-fx-border-style: solid; -fx-background-color: #2A5058; -fx-text-fill: white;";

        Button btnProfile = new Button("Profile");
        btnProfile.setStyle(buttonStyle);
        btnProfile.setPrefWidth(Double.MAX_VALUE);
        Button btnMessage = new Button("Message");
        btnMessage.setStyle(buttonStyle);
        btnMessage.setPrefWidth(Double.MAX_VALUE);
        Button btnChangePassword = new Button("Change Password");
        btnChangePassword.setStyle(buttonStyle);
        btnChangePassword.setPrefWidth(Double.MAX_VALUE);

        leftSidebar.getChildren().addAll(btnProfile, btnMessage, btnChangePassword);

        // Top bar
        HBox topBar = new HBox();
        topBar.setPadding(new Insets(20, 12, 20, 12));
        topBar.setStyle("-fx-background-color: #336699;");
        Text projectNameTopBar = new Text("ACE Project");
        projectNameTopBar.setFont(new Font("Arial", 24));
        projectNameTopBar.setFill(javafx.scene.paint.Color.WHITE);
        topBar.getChildren().add(projectNameTopBar);
        topBar.setAlignment(Pos.CENTER_LEFT);

        
        VBox centerBox = new VBox(10);
        centerBox.setPadding(new Insets(10));
        centerBox.setAlignment(Pos.TOP_LEFT);

        
        for (int i = 1; i <= 8; i++) {
            TextArea textArea = new TextArea();
            textArea.setEditable(false); 
            textArea.setPrefHeight(80); 
            textArea.setText("message " + i); 
            centerBox.getChildren().add(textArea);
        }

        
        HBox pageBox = new HBox();
        pageBox.setAlignment(Pos.CENTER);
        Label pageLabel = new Label("number: 1/10"); // 
        pageBox.getChildren().add(pageLabel);

        borderPane.setTop(topBar);
        borderPane.setLeft(leftSidebar);
        borderPane.setCenter(centerBox);
        borderPane.setBottom(pageBox);


        Scene scene = new Scene(borderPane, 1280, 720);
        primaryStage.setTitle("User Information Interface");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


