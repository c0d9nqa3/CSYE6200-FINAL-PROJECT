package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import view.BUserDao; // 确保导入 BUserDao 类

public class Profile {

    public static VBox getView() {
        // 创建包含个人资料字段的GridPane
        GridPane profileGrid = new GridPane();
        profileGrid.setHgap(10);
        profileGrid.setVgap(10);
        profileGrid.setPadding(new Insets(20));

        // 创建标签和文本字段
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label telLabel = new Label("TEL:");
        TextField telField = new TextField();
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        Label moreInfoLabel = new Label("More INFO:");
        TextArea moreInfoArea = new TextArea();
        Label addressLabel = new Label("Address:");
        TextField addressField = new TextField();

        // 将标签和文本字段添加到GridPane
        profileGrid.add(nameLabel, 0, 0);
        profileGrid.add(nameField, 1, 0);
        profileGrid.add(telLabel, 0, 1);
        profileGrid.add(telField, 1, 1);
        profileGrid.add(emailLabel, 0, 2);
        profileGrid.add(emailField, 1, 2);
        profileGrid.add(moreInfoLabel, 0, 3);
        profileGrid.add(moreInfoArea, 1, 3);
        profileGrid.add(addressLabel, 0, 4);
        profileGrid.add(addressField, 1, 4);

        // 创建并配置应用按钮
        Button applyButton = new Button("Apply");
        applyButton.setOnAction(event -> {
            try {
                BUserDao userDao = new BUserDao();
                userDao.updateUserProfile(
                    nameField.getText(),
                    telField.getText(),
                    emailField.getText(),
                    moreInfoArea.getText(),
                    addressField.getText(),
                    1 // 假设用户ID是已知的
                );
                showAlert(AlertType.INFORMATION, "Update successful.");
            } catch (Exception e) {
                e.printStackTrace();
                showAlert(AlertType.ERROR, "Update failed. Error: " + e.getMessage());
            }
        });

        VBox layout = new VBox(10); // 主VBox布局
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(profileGrid, applyButton);

        return layout;
    }

    private static void showAlert(AlertType type, String message) {
        Alert alert = new Alert(type, message);
        alert.showAndWait();
    }
}
