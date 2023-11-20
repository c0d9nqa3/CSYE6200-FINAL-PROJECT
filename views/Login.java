package View;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Compliance System Login");

        // Create GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Apply dark theme to GridPane
        grid.setStyle("-fx-background-color: #333333;");

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(100);
        grid.getColumnConstraints().add(col1);

        // add component to GridPane
        Label userNameLabel = new Label("Username");
        userNameLabel.setTextFill(Color.WHITE); // Set text color to white
        grid.add(userNameLabel, 0, 1);

        TextField userTextField = new TextField();
        userTextField.setMinSize(200, 30); // Set minimum size
        grid.add(userTextField, 0, 2, 2, 1); // Span 2 columns

        Label passwordLabel = new Label("Password:");
        passwordLabel.setTextFill(Color.WHITE); // Set text color to white
        grid.add(passwordLabel, 0, 3);

        PasswordField passwordField = new PasswordField();
        passwordField.setMinSize(200, 30); // Set minimum size
        grid.add(passwordField, 0, 4, 2, 1); // Span 2 columns

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #555555; -fx-text-fill: white;"); // Set button style
        loginButton.setMinSize(100, 30); // Set minimum size
        grid.add(loginButton, 0, 6, 2, 1); // Span 2 columns

        Button registerButton = new Button("Register");
        registerButton.setStyle("-fx-background-color: #555555; -fx-text-fill: white;"); // Set button style
        registerButton.setMinSize(100, 30); // Set minimum size
        grid.add(registerButton, 0, 7, 2, 1); // Span 2 columns

        final Text actionTarget = new Text();
        actionTarget.setFill(Color.WHITE); // Set text color to white
        grid.add(actionTarget, 0, 8, 2, 1); // Span 2 columns

        //set the form
        GridPane.setHalignment(loginButton, HPos.CENTER);
        GridPane.setHalignment(registerButton, HPos.CENTER);

        // Login Event
        loginButton.setOnAction(e -> {
            String username = userTextField.getText();
            String password = passwordField.getText();

            
            if (isValidCredentials(username, password)) {
                actionTarget.setFill(Color.GREEN);
                actionTarget.setText("Successfully Login");
            } else if (username.isEmpty() || password.isEmpty()) {
                actionTarget.setFill(Color.RED);
                actionTarget.setText("Please enter the password and username!");
            } else {
                actionTarget.setFill(Color.RED);
                actionTarget.setText("Unexist user!");
            }
        });

        Scene scene = new Scene(grid, 500, 400); 
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private boolean isValidCredentials(String username, String password) {
        // TBD(Query the user_name and pwd in the database) this need to check the user type
        return "admin".equals(username) && "admin123".equals(password);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

