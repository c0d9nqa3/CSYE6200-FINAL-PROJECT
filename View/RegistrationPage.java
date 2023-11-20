package View;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistrationPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Registration Page");

        // Create GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Apply dark theme to GridPane
        grid.setStyle("-fx-background-color: #333333;");

        // Add components to GridPane
        Label userNameLabel = new Label("Username:");
        userNameLabel.setTextFill(Color.WHITE);
        grid.add(userNameLabel, 0, 1);

        TextField userTextField = new TextField();
        userTextField.setMinSize(200, 30);
        grid.add(userTextField, 1, 1, 2, 1);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setTextFill(Color.WHITE);
        grid.add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        passwordField.setMinSize(200, 30);
        grid.add(passwordField, 1, 2, 2, 1);

        Label confirmPasswordLabel = new Label("Confirm Password:");
        confirmPasswordLabel.setTextFill(Color.WHITE);
        grid.add(confirmPasswordLabel, 0, 3);

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setMinSize(200, 30);
        grid.add(confirmPasswordField, 1, 3, 2, 1);

        Label userTypeLabel = new Label("User Type:");
        userTypeLabel.setTextFill(Color.WHITE);
        grid.add(userTypeLabel, 0, 4);

        ComboBox<String> userTypeComboBox = new ComboBox<>();
        userTypeComboBox.getItems().addAll("PartyA", "PartyB");
        userTypeComboBox.setMinSize(200, 30);
        grid.add(userTypeComboBox, 1, 4, 2, 1);
        userTypeComboBox.setValue("PartyA"); // Set default value

        Label companyNameLabel = new Label("Company Name:");
        companyNameLabel.setTextFill(Color.WHITE);
        grid.add(companyNameLabel, 0, 5);

        TextField companyNameField = new TextField();
        companyNameField.setMinSize(200, 30);
        grid.add(companyNameField, 1, 5, 2, 1);

        Label nameLabel = new Label("Name:");
        nameLabel.setTextFill(Color.WHITE);
        grid.add(nameLabel, 0, 6);

        TextField nameField = new TextField();
        nameField.setMinSize(200, 30);
        grid.add(nameField, 1, 6, 2, 1);

        Label positionLabel = new Label("Position:");
        positionLabel.setTextFill(Color.WHITE);
        grid.add(positionLabel, 0, 7);

        TextField positionField = new TextField();
        positionField.setMinSize(200, 30);
        grid.add(positionField, 1, 7, 2, 1);

        Button registerButton = new Button("Register");
        registerButton.setStyle("-fx-background-color: #555555; -fx-text-fill: white;");
        registerButton.setMinSize(100, 30);
        grid.add(registerButton, 1, 8);

        Button cancelButton = new Button("Cancel");
        cancelButton.setStyle("-fx-background-color: #555555; -fx-text-fill: white;");
        cancelButton.setMinSize(100, 30);
        grid.add(cancelButton, 2, 8);

        final Text actionTarget = new Text();
        actionTarget.setFill(Color.WHITE);
        grid.add(actionTarget, 1, 9, 2, 1);

        // set the form
        GridPane.setHalignment(registerButton, HPos.CENTER);
        GridPane.setHalignment(cancelButton, HPos.CENTER);

        // Register Button Event
        registerButton.setOnAction(e -> {
            // Add logic for registration
            actionTarget.setFill(Color.GREEN);
            actionTarget.setText("Registration successful!");
        });

        // Cancel Button Event
        cancelButton.setOnAction(e -> {
            // Close the registration page
            primaryStage.close();
        });

        Scene scene = new Scene(grid, 600, 500);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
