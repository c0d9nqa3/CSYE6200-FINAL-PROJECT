package view;

import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BUserDao {

    private static final String URL = "jdbc:mysql://localhost:3306/userinfo";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public void updateUserProfile(String name, String tel, String email, String more, String address, int userId) throws SQLException {
        String sql = "UPDATE userinfo SET Name = ?, Tel = ?, Email = ?, More = ?, Address = ? WHERE UserID = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, tel);
            pstmt.setString(3, email);
            pstmt.setString(4, more);
            pstmt.setString(5, address);
            pstmt.setInt(6, userId);

            pstmt.executeUpdate();
        }
    }

    public void getInactiveContracts(ObservableList<Contract.ContractData> data) throws SQLException {
        String query = "SELECT * FROM contract_relation WHERE status = 'inactive'";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                data.add(new Contract.ContractData(
                    rs.getInt("contract_id"),
                    rs.getString("PA_name"),
                    rs.getString("PB_name"),
                    rs.getString("status"),
                    rs.getString("contract_name")
                ));
            }
        }
    }

    public void deleteContract(int contractId) throws SQLException {
        String query = "DELETE FROM contract_relation WHERE contract_id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, contractId);
            pstmt.executeUpdate();
        }
    }
 // 在 BUserDao 类中
    public void getInactiveContractsForMessage(ObservableList<Message.ContractData> data) throws SQLException {
        String query = "SELECT contract_id, PA_name, contract_name FROM contract_relation WHERE status = 'inactive'";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                data.add(new Message.ContractData(
                    rs.getInt("contract_id"),
                    rs.getString("PA_name"),
                    rs.getString("contract_name")
                ));
            }
        }
    }
    
    private boolean isOldPasswordCorrect(int userId, String oldPassword) throws SQLException {
        String query = "SELECT Password FROM userinfo WHERE UserID = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("Password");
                    return storedPassword.equals(oldPassword);
                }
            }
        }
        return false;
    }

    public boolean changeUserPassword(int userId, String oldPassword, String newPassword) throws SQLException {
        if (!isOldPasswordCorrect(userId, oldPassword)) {
            return false;
        }

        String update = "UPDATE userinfo SET Password = ? WHERE UserID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(update)) {

            pstmt.setString(1, newPassword);
            pstmt.setInt(2, userId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }


    // ... 其他方法 ...
}
