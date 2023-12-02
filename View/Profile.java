package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Profile {

    public static VBox getView() {
        // 创建包含个人资料字段的GridPane
        GridPane profileGrid = new GridPane();
        profileGrid.setHgap(10);
        profileGrid.setVgap(10);
        profileGrid.setPadding(new Insets(20));

        // 创建标签和文本字段
        Label companyNameLabel = new Label("Company name:");
        TextField companyNameField = new TextField();
        Label addressLabel = new Label("Address:");
        TextField addressField = new TextField();
        Label telLabel = new Label("TEL:");
        TextField telField = new TextField();
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        Label moreInfoLabel = new Label("More INFO:");
        TextArea moreInfoArea = new TextArea();
        moreInfoArea.setPrefHeight(100);

        // 将标签和文本字段添加到GridPane
        profileGrid.add(companyNameLabel, 0, 0);
        profileGrid.add(companyNameField, 1, 0);
        profileGrid.add(addressLabel, 0, 1);
        profileGrid.add(addressField, 1, 1);
        profileGrid.add(telLabel, 0, 2);
        profileGrid.add(telField, 1, 2);
        profileGrid.add(emailLabel, 0, 3);
        profileGrid.add(emailField, 1, 3);
        profileGrid.add(moreInfoLabel, 0, 4);
        profileGrid.add(moreInfoArea, 1, 4);

        // 创建并配置应用按钮
        Button applyButton = new Button("Apply");
        VBox layout = new VBox(10); // 主VBox布局
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(profileGrid, applyButton);

        return layout;
    }
}

