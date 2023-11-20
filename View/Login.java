package View;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Model.AUserDao;
import Model.BUserDao;
import Model.AdminDao;
public class Login extends Application {
	AUserDao auser = new AUserDao();
	BUserDao buser = new BUserDao();
	AdminDao admin = new AdminDao();
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

        // Add ComboBox for user type
        Label userTypeLabel = new Label("User Type:");
        userTypeLabel.setTextFill(Color.WHITE);
        grid.add(userTypeLabel, 0, 5);

        ComboBox<String> userTypeComboBox = new ComboBox<>();
        userTypeComboBox.getItems().addAll("PartyA User", "PartyB User", "Admin");
        userTypeComboBox.setValue("PartyA User"); // Set default value
        userTypeComboBox.setMinSize(200, 30);
        grid.add(userTypeComboBox, 0, 6, 2, 1); // Span 2 columns

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #555555; -fx-text-fill: white;"); // Set button style
        loginButton.setMinSize(100, 30); // Set minimum size
        grid.add(loginButton, 0, 8, 2, 1); // Span 2 columns

        final Text actionTarget = new Text();
        actionTarget.setFill(Color.WHITE); // Set text color to white
        grid.add(actionTarget, 0, 9, 2, 1); // Span 2 columns
        // Add Register Button
        Button registerButton = new Button("Register");
        registerButton.setStyle("-fx-background-color: #555555; -fx-text-fill: white;");
        registerButton.setMinSize(100, 30);
        grid.add(registerButton, 0, 10, 2, 1); // Span 2 columns

        // Register Button Event
        registerButton.setOnAction(e -> {
        	RegistrationPage registrationPage = new RegistrationPage();
            Stage registrationStage = new Stage();
            registrationPage.start(registrationStage); 
        });

        // set the form
        GridPane.setHalignment(loginButton, HPos.CENTER);
        GridPane.setHalignment(registerButton, HPos.CENTER);
        // Login Event
        loginButton.setOnAction(e -> {
            String username = userTextField.getText();
            String password = passwordField.getText();
            String userType = userTypeComboBox.getValue();

            if (isValidCredentials(username, password, userType)) {
                actionTarget.setFill(Color.GREEN);
                actionTarget.setText("Successfully Login as " + userType);
            } else if (username.isEmpty() || password.isEmpty()) {
                actionTarget.setFill(Color.RED);
                actionTarget.setText("Please enter the password and username!");
            } else {
                actionTarget.setFill(Color.RED);
                actionTarget.setText("Invalid credentials!");
            }
        });

        Scene scene = new Scene(grid, 500, 500); // Adjusted window size
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private boolean isValidCredentials(String username, String password, String userType) {
        // Check credentials and user type
    	boolean result = false;
    	
    	if(userType=="PartyA User") {
    		result = auser.checkAUserPwd(username, password);
    	}
    	else if(userType=="PartyB User") {
    		result = buser.checkBUserPwd(username, password);
    	}
    	else {
    		result = admin.checkAdminPwd(username, password);
    	}
        return result;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

