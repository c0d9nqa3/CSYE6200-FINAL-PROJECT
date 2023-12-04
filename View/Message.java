package view;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;

public class Message {

    private static final String URL = "jdbc:mysql://localhost:3306/contract";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String QUERY = "SELECT contract_id, PA_name, contract_name FROM contract_relation WHERE status = 'inactive'";

    public static VBox getView() {
        VBox messagesLayout = new VBox(10);
        messagesLayout.setPadding(new Insets(20));

        ListView<ContractData> messageList = new ListView<>();
        ObservableList<ContractData> items = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {

            while (rs.next()) {
                items.add(new ContractData(
                        rs.getInt("contract_id"),
                        rs.getString("PA_name"),
                        rs.getString("contract_name")
                ));
            }
        } catch (Exception e) {
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Database Error");
                alert.setHeaderText(null);
                alert.setContentText("Unable to load contracts from the database: " + e.getMessage());
                alert.showAndWait();
            });
            e.printStackTrace();
        }

        messageList.setItems(items);
        messageList.setCellFactory(param -> new ContractListCell());

        messageList.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                showContractDetails(newVal);
            }
        });

        messagesLayout.getChildren().add(messageList);

        return messagesLayout;
    }

    private static void showContractDetails(ContractData contractData) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Contract Details");
        alert.setHeaderText("Contract Information");
        alert.setContentText("Contract ID: " + contractData.getContractId() + "\n" +
                             "PA Name: " + contractData.getPaName() + "\n" +
                             "Contract Name: " + contractData.getContractName());
        
        alert.showAndWait(); // 等待用户响应

        // 用户关闭对话框后，跳转到 Contract 视图
        Main.switchToContractView();

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Placeholder for navigating to the contract view
            navigateToContractView();
        }
    }

    // Placeholder method to simulate navigating to the contract view
    private static void navigateToContractView() {
        System.out.println("Navigating to the contract view...");
        // Implement actual navigation logic here
    }

    public static class ContractData {
        private final int contractId;
        private final String paName;
        private final String contractName;

        public ContractData(int contractId, String paName, String contractName) {
            this.contractId = contractId;
            this.paName = paName;
            this.contractName = contractName;
        }

        public int getContractId() {
            return contractId;
        }

        public String getPaName() {
            return paName;
        }

        public String getContractName() {
            return contractName;
        }
    }

    // Custom cell to display the contract name in the ListView
    static class ContractListCell extends javafx.scene.control.ListCell<ContractData> {
        @Override
        protected void updateItem(ContractData item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
            } else {
                setText(item.getContractName());
            }
        }
    }
}
