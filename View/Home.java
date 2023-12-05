package view;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Home {

    public static VBox getView() {
        VBox homeView = new VBox(10);
        homeView.setPadding(new Insets(20));

        // 用户信息框
        BorderPane userInfoPane = new BorderPane();
        userInfoPane.setPadding(new Insets(10));
        Label userNameLabel = new Label("用户名: John Doe");
        Label userPhoneLabel = new Label("电话: 123-456-7890");
        Label userAddressLabel = new Label("地址: 123 Main St, Anytown, USA");
        VBox userInfoLabels = new VBox(5, userNameLabel, userPhoneLabel, userAddressLabel);
        userInfoPane.setCenter(userInfoLabels);

        // 已完成合同数量框
        BorderPane contractsCompletedPane = new BorderPane();
        contractsCompletedPane.setPadding(new Insets(10));
        Label contractsCompletedLabel = new Label("已完成的签约合同数量: 5");
        contractsCompletedPane.setCenter(contractsCompletedLabel);

        // 未完成合同数量框
        BorderPane contractsPendingPane = new BorderPane();
        contractsPendingPane.setPadding(new Insets(10));
        Label contractsPendingLabel = new Label("未完成的签约合同数量: 2");
        contractsPendingPane.setCenter(contractsPendingLabel);

        // 将所有框添加到主视图
        homeView.getChildren().addAll(userInfoPane, contractsCompletedPane, contractsPendingPane);

        return homeView;
    }
}





confirmButton.setOnAction(event -> {
    String signature = signatureTextField.getText().trim();
    if (signature.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Please enter your signature before confirming.");
        alert.showAndWait();
    } else {
        // 更新 PDF 文件的签名
        PDFGenerate pdfGenerator = new PDFGenerate();
        try {
            // 假设您已有其他所需参数
            pdfGenerator.generatePDFFile("2023-01-01", "PA Name", "PB Name", "Contract Address", "Service Description", "Deadline", "Invoice Frequency", "Total Amount", "PB Person Name", "PA Person Name", "Contract Name", signature);
            System.out.println("Confirmed with signature: " + signature);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
});

