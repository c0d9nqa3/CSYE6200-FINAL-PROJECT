package Controller;

import View.Login;
import View.LoginTest;
import View.RegistrationPage;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Model.AUserDao;
import Model.BUserDao;
import Model.AdminDao;

public class LoginController {
    private LoginTest login;
    private AUserDao auser;
    private BUserDao buser;
    private AdminDao admin;
    private GridPane grid;
    private ColumnConstraints col1;
    private Text actionTarget;

    public LoginController(LoginTest login) {
        this.login = login;
        this.auser = new AUserDao();
        this.buser = new BUserDao();
        this.admin = new AdminDao();
        this.grid = login.getGrid();
        this.col1 = login.getCol1();
        this.actionTarget = login.getActionTarget();
    }

    public void start(Stage primaryStage) {
        // Other initialization logic, if needed

        // Add Register Button
        //Button registerButton = new Button("Register");
        //login.getRegisterButton().setStyle("-fx-background-color: #555555; -fx-text-fill: white;");
        //login.getRegisterButton().setMinSize(100, 30);
        //grid.add(login.getRegisterButton(), 0, 10, 2, 1); // Span 2 columns

        // Register Button Event
    	primaryStage.setTitle("Compliance System Login");
    	login.getRegisterButton().setOnAction(e -> {
            RegistrationPage registrationPage = new RegistrationPage();
            Stage registrationStage = new Stage();
            registrationPage.start(registrationStage);
        });

       

        // Login Event
        login.getLoginButton().setOnAction(e -> {
            String username = login.getUserTextField().getText();
            String password = login.getPasswordField().getText();
            String userType = login.getUserTypeComboBox().getValue();

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
//TBD
        Scene scene = new Scene(grid, 500, 500); // Adjusted window size
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private boolean isValidCredentials(String username, String password, String userType) {
        // Check credentials and user type
        boolean result = false;

        if ("PartyA User".equals(userType)) {
            result = auser.checkAUserPwd(username, password);
        } else if ("PartyB User".equals(userType)) {
            result = buser.checkBUserPwd(username, password);
        } else if ("Admin".equals(userType)) {
            result = admin.checkAdminPwd(username, password);
        }
        return result;
    }
}
