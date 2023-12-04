package view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.sql.SQLException;

public class Password {

    private static final int USER_ID = 111; // 默认的UserID

    public static VBox getView() {
        // 主布局
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        // 网格布局用于表单输入
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        // 创建标签和密码字段
        Label oldPasswordLabel = new Label("Old password:");
        PasswordField oldPasswordField = new PasswordField();
        Label newPasswordLabel = new Label("New password:");
        PasswordField newPasswordField = new PasswordField();
        Label confirmLabel = new Label("Confirm new password:");
        PasswordField confirmPasswordField = new PasswordField();

        // 创建按钮
        Button changeButton = new Button("Change password");

        // 事件处理
        changeButton.setOnAction(actionEvent -> {
            String oldPassword = oldPasswordField.getText();
            String newPassword = newPasswordField.getText();
            String confirmPassword = confirmPasswordField.getText();
            
            if (oldPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                showAlert("Password cannot be empty");
                return;
            }
            
            if (!newPassword.equals(confirmPassword)) {
                showAlert("New password is inconsistent");
                return;
            }

            BUserDao userDao = new BUserDao();
            try {
                boolean isChanged = userDao.changeUserPassword(USER_ID, oldPassword, newPassword);
                if (isChanged) {
                    showAlert("Password changed successfully");
                    // 这里实现回到主页的逻辑
                } else {
                    showAlert("Old password is incorrect");
                }
            } catch (SQLException e) {
                showAlert("Database error: " + e.getMessage());
                e.printStackTrace();
            }
        });

        // 将组件添加到网格布局
        grid.add(oldPasswordLabel, 0, 0);
        grid.add(oldPasswordField, 1, 0);
        grid.add(newPasswordLabel, 0, 1);
        grid.add(newPasswordField, 1, 1);
        grid.add(confirmLabel, 0, 2);
        grid.add(confirmPasswordField, 1, 2);

        // 将网格布局和按钮添加到VBox布局
        layout.getChildren().addAll(grid, changeButton);

        return layout;
    }

    private static void showAlert(String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(message);
            alert.showAndWait();
        });
    }
}
