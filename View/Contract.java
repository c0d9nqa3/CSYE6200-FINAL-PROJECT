package view;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;

public class Contract {

    private static final String URL = "jdbc:mysql://localhost:3306/contract";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String QUERY = "SELECT * FROM contract_relation WHERE status = 'inactive'";

    public static VBox getView() {
        VBox vbox = new VBox();
        TableView<ContractData> table = new TableView<>();
        ObservableList<ContractData> data = FXCollections.observableArrayList();

        // Define columns
        TableColumn<ContractData, Integer> columnContractId = new TableColumn<>("Contract ID");
        columnContractId.setCellValueFactory(new PropertyValueFactory<>("contractId"));

        TableColumn<ContractData, String> columnPAName = new TableColumn<>("PA Name");
        columnPAName.setCellValueFactory(new PropertyValueFactory<>("paName"));

        TableColumn<ContractData, String> columnPBName = new TableColumn<>("PB Name");
        columnPBName.setCellValueFactory(new PropertyValueFactory<>("pbName"));

        TableColumn<ContractData, String> columnStatus = new TableColumn<>("Status");
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<ContractData, String> columnContractName = new TableColumn<>("Contract Name");
        columnContractName.setCellValueFactory(new PropertyValueFactory<>("contractName"));

        TableColumn<ContractData, Void> actionColumn = new TableColumn<>("Actions");

        Callback<TableColumn<ContractData, Void>, TableCell<ContractData, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<ContractData, Void> call(final TableColumn<ContractData, Void> param) {
                final TableCell<ContractData, Void> cell = new TableCell<>() {

                    private final Button btnView = new Button("View");
                    private final Button btnDelete = new Button("Delete");

                    {
                        // View button action
                        btnView.setOnAction((ActionEvent event) -> {
                            ContractData data = getTableView().getItems().get(getIndex());
                            showViewDialog(data);
                        });

                        // Delete button action
                        btnDelete.setOnAction((ActionEvent event) -> {
                            ContractData data = getTableView().getItems().get(getIndex());
                            showDeleteDialog(data, getTableView());
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox manageBtn = new HBox(btnView, btnDelete);
                            manageBtn.setStyle("-fx-alignment: CENTER");
                            setGraphic(manageBtn);
                        }
                    }
                };
                return cell;
            }
        };

        actionColumn.setCellFactory(cellFactory);

        table.getColumns().addAll(columnContractId, columnPAName, columnPBName, columnStatus, columnContractName, actionColumn);

        // Load data from database
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {

            while (rs.next()) {
                data.add(new ContractData(
                        rs.getInt("contract_id"),
                        rs.getString("PA_name"),
                        rs.getString("PB_name"),
                        rs.getString("status"),
                        rs.getString("contract_name")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table.setItems(data);
        vbox.getChildren().add(table);

        return vbox;
    }

    private static void showViewDialog(ContractData data) {
        Platform.runLater(() -> {
            Stage viewStage = new Stage();
            viewStage.setTitle("View Contract");
            VBox viewVbox = new VBox(new Text("Viewing contract details..."));
            Scene viewScene = new Scene(viewVbox, 300, 200);
            viewStage.setScene(viewScene);
            viewStage.show();
        });
    }

    private static void showDeleteDialog(ContractData data, TableView<ContractData> table) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete this contract?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                deleteContract(data.getContractId(), table);
            }
        });
    }

    private static void deleteContract(int contractId, TableView<ContractData> table) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            String sql = "DELETE FROM contract_relation WHERE contract_id = " + contractId;
            int affectedRows = stmt.executeUpdate(sql);
            if (affectedRows > 0) {
                Platform.runLater(() -> table.getItems().removeIf(contract -> contract.getContractId() == contractId));
            }
        } catch (Exception e) {
            Platform.runLater(() -> {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Error Dialog");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Error occurred while deleting the contract: " + e.getMessage());
                errorAlert.showAndWait();
            });
            e.printStackTrace();
        }
    }

    public static class ContractData {
        private final int contractId;
        private final String paName;
        private final String pbName;
        private final String status;
        private final String contractName;

        public ContractData(int contractId, String paName, String pbName, String status, String contractName) {
            this.contractId = contractId;
            this.paName = paName;
            this.pbName = pbName;
            this.status = status;
            this.contractName = contractName;
        }

        public int getContractId() {
            return contractId;
        }

        public String getPaName() {
            return paName;
        }

        public String getPbName() {
            return pbName;
        }

        public String getStatus() {
            return status;
        }

        public String getContractName() {
            return contractName;
        }
    }
}
