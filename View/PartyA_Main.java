package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// 如果Password类不在view包中，请确保导入正确的包
import view.Home;
import view.Profile;
import view.Message;
import view.Password; // 导入Password类

public class Main extends Application {

    private BorderPane mainLayout; // 主布局的引用

    @Override
    public void start(Stage primaryStage) {
        // 顶部导航栏
        BorderPane headerPane = new BorderPane();
        headerPane.setPadding(new Insets(10));
        headerPane.setStyle("-fx-background-color: #34495e;");
        headerPane.setPrefHeight(50);

        // 左侧导航栏
        VBox sideMenu = new VBox(15);
        sideMenu.setPadding(new Insets(10));
        sideMenu.setStyle("-fx-background-color: #2c3e50;");
        Button homeButton = new Button("Home");
        homeButton.setPrefWidth(150);
        Button profileButton = new Button("Profile");
        profileButton.setPrefWidth(150);
        Button messageButton = new Button("Message");
        messageButton.setPrefWidth(150);
        Button passwordButton = new Button("Change Password"); // 更改按钮文本以匹配功能
        passwordButton.setPrefWidth(150);
        sideMenu.getChildren().addAll(homeButton, profileButton, messageButton, passwordButton);

        // 主布局
        mainLayout = new BorderPane(); // 保存主布局的引用
        mainLayout.setTop(headerPane);
        mainLayout.setLeft(sideMenu);

        // 为Home按钮添加事件处理
        homeButton.setOnAction(event -> mainLayout.setCenter(Home.getView()));

        // 为Profile按钮添加事件处理
        profileButton.setOnAction(event -> mainLayout.setCenter(Profile.getView()));

        // 为Message按钮添加事件处理
        messageButton.setOnAction(event -> mainLayout.setCenter(Message.getView()));

        // 为Change Password按钮添加事件处理
        passwordButton.setOnAction(event -> mainLayout.setCenter(Password.getView())); // 使用Password.getView()来获取视图

        // 设置和显示场景
        Scene scene = new Scene(mainLayout, 800, 500);
        primaryStage.setTitle("User Information Interface");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
