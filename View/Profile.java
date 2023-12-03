package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Profile {

    // 替换为你的数据库连接信息
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/userinfo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

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
        applyButton.setOnAction(event -> updateUserProfile(
                nameField.getText(),
                telField.getText(),
                emailField.getText(),
                moreInfoArea.getText(),
                addressField.getText(),
                1 // 这里应该是从登陆信息或者用户输入获取的用户ID
        ));

        VBox layout = new VBox(10); // 主VBox布局
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(profileGrid, applyButton);

        return layout;
    }

    private static void updateUserProfile(String name, String tel, String email, String more, String address, int userId) {
        String sql = "UPDATE userinfo SET Name = ?, Tel = ?, Email = ?, More = ?, Address = ? WHERE UserID = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, tel);
            pstmt.setString(3, email);
            pstmt.setString(4, more);
            pstmt.setString(5, address);
            pstmt.setInt(6, userId);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Update successful.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Update failed. No user found with the given ID.");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Update failed. Error: " + e.getMessage());
            alert.showAndWait();
        }
    }
}
//假设ID是已知的