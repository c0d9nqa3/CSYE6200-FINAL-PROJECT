package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        // Left side with buttons
        VBox leftSidebar = new VBox(10);
        leftSidebar.setPadding(new Insets(10));
        leftSidebar.setStyle("-fx-background-color: #2A5058; -fx-border-color: black; -fx-border-width: 1;");
        leftSidebar.setPrefWidth(200); // Left side width

        // Button style
        String buttonStyle = "-fx-border-color: white; -fx-border-width: 1; -fx-border-insets: 5; "
                             + "-fx-border-style: solid; -fx-background-color: #2A5058; -fx-text-fill: white;";
        String hoverStyle = "-fx-background-color: #3A7078;"; // Hover style
        String pressedStyle = "-fx-background-color: #1A3038;"; // Pressed style

        // Buttons
        Button btnProfile = createStyledButton("Profile", buttonStyle, hoverStyle, pressedStyle);
        Button btnMessage = createStyledButton("Message", buttonStyle, hoverStyle, pressedStyle);
        Button btnChangePassword = createStyledButton("Change Password", buttonStyle, hoverStyle, pressedStyle);
        
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

        // Center box
        VBox centerBox = new VBox(10);
        centerBox.setPadding(new Insets(10));
        centerBox.setAlignment(Pos.TOP_LEFT);
        for (int i = 1; i <= 8; i++) {
            TextArea textArea = new TextArea();
            textArea.setEditable(false); 
            textArea.setPrefHeight(80); 
            textArea.setText("Message " + i); 
            centerBox.getChildren().add(textArea);
        }

        // Page box
        HBox pageBox = new HBox();
        pageBox.setAlignment(Pos.CENTER);
        Label pageLabel = new Label("Number: 1/10");
        pageBox.getChildren().add(pageLabel);

        // Setting up the border pane
        borderPane.setTop(topBar);
        borderPane.setLeft(leftSidebar);
        borderPane.setCenter(centerBox);
        borderPane.setBottom(pageBox);

        // Setting up the scene
        Scene scene = new Scene(borderPane, 1280, 720);
        primaryStage.setTitle("User Information Interface");
        primaryStage.setScene(scene);
        // Removed the full-screen mode
        primaryStage.show();
    }

    // Method to create a button with specified styles
    private Button createStyledButton(String text, String baseStyle, String hoverStyle, String pressedStyle) {
        Button button = new Button(text);
        button.setStyle(baseStyle);
        button.setPrefWidth(Double.MAX_VALUE);
        button.setOnMouseEntered(e -> button.setStyle(baseStyle + hoverStyle));
        button.setOnMouseExited(e -> button.setStyle(baseStyle));
        button.setOnMousePressed(e -> button.setStyle(baseStyle + pressedStyle));
        button.setOnMouseReleased(e -> button.setStyle(baseStyle + hoverStyle));
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}


