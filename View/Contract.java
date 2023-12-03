package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Contract {

    private static final String URL = "jdbc:mysql://localhost:3306/contract";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String QUERY = "SELECT * FROM contract WHERE status = 'active'";

    public static VBox getView() {
        VBox vbox = new VBox();
        TableView<ContractData> table = new TableView<>();
        ObservableList<ContractData> data = FXCollections.observableArrayList();

        // Define columns
        TableColumn<ContractData, String> columnPAName = new TableColumn<>("PA_name");
        columnPAName.setCellValueFactory(new PropertyValueFactory<>("paName"));

        TableColumn<ContractData, String> columnPBName = new TableColumn<>("PB_name");
        columnPBName.setCellValueFactory(new PropertyValueFactory<>("pbName"));

        TableColumn<ContractData, String> columnStatus = new TableColumn<>("status");
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<ContractData, String> columnContractName = new TableColumn<>("contract_name");
        columnContractName.setCellValueFactory(new PropertyValueFactory<>("contractName"));

        table.getColumns().addAll(columnPAName, columnPBName, columnStatus, columnContractName);

        // Load data from database
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {

            while (rs.next()) {
                // Assuming you have a ContractData class with these fields and a constructor
                data.add(new ContractData(rs.getString("PA_name"), rs.getString("PB_name"),
                        rs.getString("status"), rs.getString("contract_name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle errors
        }

        table.setItems(data);
        vbox.getChildren().add(table);

        return vbox;
    }

    // Define the ContractData class according to your table structure
    public static class ContractData {
        private final String paName;
        private final String pbName;
        private final String status;
        private final String contractName;

        public ContractData(String paName, String pbName, String status, String contractName) {
            this.paName = paName;
            this.pbName = pbName;
            this.status = status;
            this.contractName = contractName;
        }

        // Getters (possibly setters if needed)
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
