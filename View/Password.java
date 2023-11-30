package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    private BorderPane borderPane;

    @Override
    public void start(Stage primaryStage) {
        borderPane = new BorderPane();

        // Left sidebar with buttons
        VBox leftSidebar = createLeftSidebar();

        // Top bar
        HBox topBar = createTopBar();

        // Set initial view, for example, the profile page
        borderPane.setCenter(createProfilePage());

        borderPane.setTop(topBar);
        borderPane.setLeft(leftSidebar);

        Scene scene = new Scene(borderPane, 1280, 720);
        primaryStage.setTitle("User Information Interface");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createLeftSidebar() {
        VBox leftSidebar = new VBox(10);
        leftSidebar.setPadding(new Insets(10));
        leftSidebar.setStyle("-fx-background-color: #2A5058; -fx-border-color: black; -fx-border-width: 1;");
        leftSidebar.setPrefWidth(200); // Left side bar width

        // Button style
        String buttonStyle = "-fx-border-color: white; -fx-border-width: 1; -fx-border-insets: 5; "
                             + "-fx-border-style: solid; -fx-background-color: #2A5058; -fx-text-fill: white;";

        Button btnProfile = createStyledButton("Profile", buttonStyle);
        btnProfile.setOnAction(e -> borderPane.setCenter(createProfilePage()));

        Button btnMessage = createStyledButton("Message", buttonStyle);
        btnMessage.setOnAction(e -> borderPane.setCenter(createMessagePage()));

        Button btnChangePassword = createStyledButton("Change Password", buttonStyle);
        btnChangePassword.setOnAction(e -> borderPane.setCenter(createChangePasswordPage()));

        leftSidebar.getChildren().addAll(btnProfile, btnMessage, btnChangePassword);
        return leftSidebar;
    }

    private HBox createTopBar() {
        HBox topBar = new HBox();
        topBar.setPadding(new Insets(20, 12, 20, 12));
        topBar.setStyle("-fx-background-color: #336699;");
        Text projectNameTopBar = new Text("ACE Project");
        projectNameTopBar.setFont(new Font("Arial", 24));
        projectNameTopBar.setFill(javafx.scene.paint.Color.WHITE);
        topBar.getChildren().add(projectNameTopBar);
        topBar.setAlignment(Pos.CENTER_LEFT);
        return topBar;
    }

    private Button createStyledButton(String text, String style) {
        Button button = new Button(text);
        button.setStyle(style);
        button.setPrefWidth(Double.MAX_VALUE);
        button.setOnMouseEntered(e -> button.setStyle(style + "; -fx-background-color: #3A7078;"));
        button.setOnMouseExited(e -> button.setStyle(style));
        button.setOnMousePressed(e -> button.setStyle(style + "; -fx-background-color: #1A3038;"));
        button.setOnMouseReleased(e -> button.setStyle(style + "; -fx-background-color: #3A7078;"));
        return button;
    }

    private GridPane createProfilePage() {
        GridPane profilePage = new GridPane();
        profilePage.setAlignment(Pos.CENTER);
        profilePage.setHgap(10);
        profilePage.setVgap(10);
        profilePage.setPadding(new Insets(20, 150, 20, 150));

        // Add content to the profile page
        profilePage.add(new Label("Profile Page"), 0, 0);
        // More content can be added here

        return profilePage;
    }

    private VBox createMessagePage() {
        VBox messagePage = new VBox(10);
        for (int i = 1; i <= 8; i++) {
            TextArea textArea = new TextArea("Message " + i);
            textArea.setEditable(false);
            textArea.setPrefHeight(80);
            messagePage.getChildren().add(textArea);
        }
        return messagePage;
    }

    private GridPane createChangePasswordPage() {
        GridPane passwordPage = new GridPane();
        passwordPage.setAlignment(Pos.CENTER);
        passwordPage.setHgap(10);
        passwordPage.setVgap(10);
        passwordPage.setPadding(new Insets(20, 150, 20, 150));

        // Text fields for password
        PasswordField newPasswordField = new PasswordField();
        newPasswordField.setFont(new Font("Arial", 16));
        newPasswordField.setPrefHeight(40);
        passwordPage.add(new Label("Enter New Password:"), 0, 0);
        passwordPage.add(newPasswordField, 1, 0);

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setFont(new Font("Arial", 16));
        confirmPasswordField.setPrefHeight(40);
        passwordPage.add(new Label("Confirm New Password:"), 0, 1);
        passwordPage.add(confirmPasswordField, 1, 1);

        // Apply button
        Button applyButton = new Button("Apply");
        applyButton.setFont(new Font("Arial", 14));
        HBox applyButtonBox = new HBox(applyButton);
        applyButtonBox.setAlignment(Pos.BOTTOM_RIGHT);
        applyButtonBox.setPadding(new Insets(10));

        passwordPage.add(applyButtonBox, 1, 2);
        return passwordPage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
