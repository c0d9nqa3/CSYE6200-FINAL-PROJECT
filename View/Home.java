package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        // Left sidebar with buttons
        VBox leftSidebar = createLeftSidebar();

        // Top bar
        HBox topBar = createTopBar();

        // Home page content
        VBox centerArea = createCenterArea();

        // Setting up the border pane
        borderPane.setTop(topBar);
        borderPane.setLeft(leftSidebar);
        borderPane.setCenter(centerArea);

        // Setting up the scene
        Scene scene = new Scene(borderPane, 1280, 720);
        primaryStage.setTitle("User Information Interface");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createLeftSidebar() {
        VBox leftSidebar = new VBox(10);
        leftSidebar.setPadding(new Insets(10));
        leftSidebar.setStyle("-fx-background-color: #2A5058; -fx-border-color: black; -fx-border-width: 2;");
        leftSidebar.setPrefWidth(200);

        String buttonStyle = "-fx-border-color: white; -fx-border-width: 1; -fx-border-insets: 5; "
                             + "-fx-border-style: solid; -fx-background-color: #2A5058; -fx-text-fill: white;";
        String hoverStyle = "-fx-background-color: #3A7078;";
        String pressedStyle = "-fx-background-color: #1A3038;";

        Button btnHome = createStyledButton("Home", buttonStyle, hoverStyle, pressedStyle);
        Button btnProfile = createStyledButton("Profile", buttonStyle, hoverStyle, pressedStyle);
        Button btnMessage = createStyledButton("Message", buttonStyle, hoverStyle, pressedStyle);
        Button btnChangePassword = createStyledButton("Change Password", buttonStyle, hoverStyle, pressedStyle);

        leftSidebar.getChildren().addAll(btnHome, btnProfile, btnMessage, btnChangePassword);

        return leftSidebar;
    }

    private HBox createTopBar() {
        HBox topBar = new HBox();
        topBar.setPadding(new Insets(20, 12, 20, 12));
        topBar.setStyle("-fx-background-color: #336699; -fx-border-color: black; -fx-border-width: 2;");
        Text projectNameTopBar = new Text("ACE Project");
        projectNameTopBar.setFont(new Font("Arial", 24));
        projectNameTopBar.setStyle("-fx-fill: white;");
        topBar.getChildren().add(projectNameTopBar);
        topBar.setAlignment(Pos.CENTER_LEFT);

        return topBar;
    }

    private VBox createCenterArea() {
        VBox centerArea = new VBox(20);
        centerArea.setAlignment(Pos.TOP_LEFT);
        centerArea.setPadding(new Insets(40, 0, 0, 20));

        // 创建用户信息包围框
        VBox userInfoBox = createStyledBox("User Info:");
        String userInfo = "Company Name: Your Company Name\nPhone: 123-456-7890\nAddress: 123 Main St, City, Country";
        Label lblUserInfoDetails = createStyledLabel(userInfo);
        userInfoBox.getChildren().add(lblUserInfoDetails);

        // 创建合同信息包围框，无大框
        VBox contractsBox = createStyledBox(""); // 空标题
        VBox pendingContractsBox = createStyledBox("Pending Contracts: " + getPendingContractsCount());
        VBox signedContractsBox = createStyledBox("Signed Contracts: " + getSignedContractsCount());
        contractsBox.getChildren().addAll(pendingContractsBox, signedContractsBox);

        centerArea.getChildren().addAll(userInfoBox, contractsBox);

        return centerArea;
    }

    // 创建带有样式的按钮
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

    // 创建带有样式的标签
    private Label createStyledLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-text-fill: black;");
        return label;
    }

    // 创建带有样式的 VBox
    private VBox createStyledBox(String title) {
        VBox box = new VBox(10);
        box.setStyle("-fx-background-color: white;");
        Label lblTitle = createStyledLabel(title);
        if (!title.isEmpty()) {
            lblTitle.setStyle("-fx-font-weight: bold;");
        }
        box.getChildren().add(lblTitle);
        return box;
    }

    private int getPendingContractsCount() {
        // 实现获取待签署合约数量的逻辑
        return 5; // 示例返回值
    }

    private int getSignedContractsCount() {
        // 实现获取已签署合约数量的逻辑
        return 10; // 示例返回值
    }

    public static void main(String[] args) {
        launch(args);
    }
}
