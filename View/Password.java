package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Password {

    public static VBox getView() {
        // 主布局
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        // 网格布局用于表单输入
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        // 创建标签和密码字段
        Label oldPasswordLabel = new Label("Old Password:");
        PasswordField oldPasswordField = new PasswordField();
        Label newPasswordLabel = new Label("New Password:");
        PasswordField newPasswordField = new PasswordField();
        Label confirmLabel = new Label("Confirm New Password:");
        PasswordField confirmPasswordField = new PasswordField();

        // 创建按钮
        Button changeButton = new Button("Change Password");

        // 事件处理（这里只是打印输出，实际上应连接到认证系统）
        changeButton.setOnAction(event -> {
            String oldPassword = oldPasswordField.getText();
            String newPassword = newPasswordField.getText();
            String confirmPassword = confirmPasswordField.getText();
            
            // 这里应该添加密码更改的逻辑
            System.out.println("Old Password: " + oldPassword);
            System.out.println("New Password: " + newPassword);
            System.out.println("Confirm Password: " + confirmPassword);
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
}
