package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
        leftSidebar.setPrefWidth(200); // Left side bar width

        // Button style
        String buttonStyle = "-fx-border-color: white; -fx-border-width: 1; -fx-border-insets: 5; "
                             + "-fx-border-style: solid; -fx-background-color: #2A5058; -fx-text-fill: white;";

        // Side buttons
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

        // Main info area
        GridPane centerGrid = new GridPane();
        centerGrid.setAlignment(Pos.CENTER);
        centerGrid.setHgap(10);
        centerGrid.setVgap(10);
        centerGrid.setPadding(new Insets(20, 150, 20, 150));

        // Text fields for password
        PasswordField newPasswordField = new PasswordField();
        newPasswordField.setFont(new Font("Arial", 16)); // Larger font size
        newPasswordField.setPrefHeight(40); // Taller field
        centerGrid.add(new Label("Enter New Password:"), 0, 0);
        centerGrid.add(newPasswordField, 1, 0);

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setFont(new Font("Arial", 16)); // Larger font size
        confirmPasswordField.setPrefHeight(40); // Taller field
        centerGrid.add(new Label("Confirm New Password:"), 0, 1);
        centerGrid.add(confirmPasswordField, 1, 1);

        // Apply button
        Button applyButton = new Button("Apply");
        applyButton.setFont(new Font("Arial", 14));
        HBox applyButtonBox = new HBox(applyButton);
        applyButtonBox.setAlignment(Pos.BOTTOM_RIGHT);
        applyButtonBox.setPadding(new Insets(10));

        borderPane.setTop(topBar);
        borderPane.setLeft(leftSidebar);
        borderPane.setCenter(centerGrid);
        borderPane.setBottom(applyButtonBox);

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

